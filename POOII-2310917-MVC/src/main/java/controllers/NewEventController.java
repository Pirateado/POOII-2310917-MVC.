package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import models.NewEventModel;
import views.NewEventViews;

public class NewEventController {
    private NewEventViews vista;

    public NewEventController(NewEventViews vista) {
        this.vista = vista;

        vista.getSaveButton().addActionListener(new SaveButtonListener());
        vista.getClearButton().addActionListener(new ClearButtonListener());

        vista.getGuestRegisterButton().addActionListener(new GuestRegisterButtonListener());
        vista.getGuestResetButton().addActionListener(new GuestResetButtonListener());
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String descripcion = vista.getDescriptionField().getText();
            String email = vista.getEmailField().getText();
            String fecha = vista.getDateField().getText();
            String frecuencia = (String) vista.getFrequencyBox().getSelectedItem();
            boolean aceptado = vista.getAgreeCheckBox().isSelected();

            if (descripcion.isEmpty() || email.isEmpty() || fecha.isEmpty() || !aceptado) {
                JOptionPane.showMessageDialog(vista, "Por favor, rellene todos los campos y acepte los términos.");
                return;
            }

            NewEventModel evento = new NewEventModel(descripcion, email, fecha, frecuencia, aceptado);
            vista.getTableModel().addRow(new Object[]{
                evento.getDescription(),
                evento.getEmail(),
                evento.getDate(),
                evento.getFrequency(),
                evento.isAgreed() ? "Aceptado" : "No aceptado"
            });
            clearEventForm();
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearEventForm();
        }
    }

    private class GuestRegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getGuestNameField().getText();
            String telefono = vista.getGuestPhoneField().getText();
            String genero = vista.getGuestGenderMale().isSelected() ? "Masculino" : "Femenino";
            int dia = Integer.parseInt((String) vista.getGuestDOBDayBox().getSelectedItem());
            String mes = (String) vista.getGuestDOBMonthBox().getSelectedItem();
            int año = Integer.parseInt((String) vista.getGuestDOBYearBox().getSelectedItem());
            String direccion = vista.getGuestAddressField().getText();
            boolean condiciones = vista.getGuestTermsCheckBox().isSelected();

            if (nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || !condiciones) {
                JOptionPane.showMessageDialog(vista, "Por favor, rellene todos los campos y acepte los términos.");
                return;
            }

            if (!telefono.matches("\\d+")) {
                JOptionPane.showMessageDialog(vista, "El número de teléfono solo puede contener dígitos.");
                return;
            }

            NewEventModel invitado = new NewEventModel(nombre, telefono, genero, dia, mes, año, direccion, condiciones);
            saveGuestToFile(invitado);
            clearGuestForm();
        }
    }

    private class GuestResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearGuestForm();
            clearGuestFile();
        }
    }

    private void saveGuestToFile(NewEventModel invitado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invitados.txt", true))) {
            writer.write(invitado.getGuestName() + "," + invitado.getGuestPhoneNumber() + "," + invitado.getGuestGender() + "," +
                         invitado.getGuestDOBDay() + "/" + invitado.getGuestDOBMonth() + "/" + invitado.getGuestDOBYear() + "," +
                         invitado.getGuestAddress() + "," + (invitado.isGuestConditions() ? "Aceptado" : "No aceptado"));
            writer.newLine();
            JOptionPane.showMessageDialog(vista, "Invitado registrado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar el invitado.");
        }
    }

    private void clearGuestFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invitados.txt"))) {
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al limpiar el archivo de invitados.");
        }
    }

    private void clearEventForm() {
        vista.getDescriptionField().setText("");
        vista.getEmailField().setText("");
        vista.getDateField().setText("");
        vista.getFrequencyBox().setSelectedIndex(0);
        vista.getAgreeCheckBox().setSelected(false);
    }

    private void clearGuestForm() {
        vista.getGuestNameField().setText("");
        vista.getGuestPhoneField().setText("");
        vista.getGuestAddressField().setText("");
        vista.getGuestDOBDayBox().setSelectedIndex(0);
        vista.getGuestDOBMonthBox().setSelectedIndex(0);
        vista.getGuestDOBYearBox().setSelectedIndex(0);
        vista.getGuestGenderMale().setSelected(false);
        vista.getGuestGenderFemale().setSelected(false);
        vista.getGuestTermsCheckBox().setSelected(false);
    }
}
