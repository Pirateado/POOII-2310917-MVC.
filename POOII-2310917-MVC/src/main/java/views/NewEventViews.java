package views;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class NewEventViews extends JFrame {
    private JTextField descripcionField, emailField, fechaField;
    private JComboBox<String> frecuenciaBox;
    private JCheckBox aceptarCheckBox;
    private JButton guardarButton, limpiarButton;
    private DefaultTableModel tableModel;

    private JTextField nombreInvitadoField, telefonoInvitadoField, direccionInvitadoField;
    private JComboBox<String> diaNacimientoBox, mesNacimientoBox, añoNacimientoBox;
    private JRadioButton generoMasculino, generoFemenino;
    private ButtonGroup grupoGenero;
    private JCheckBox terminosCheckBox;
    private JButton registrarInvitadoButton, resetearButton;

    public NewEventViews() {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel formularioPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        descripcionField = new JTextField();
        emailField = new JTextField();
        fechaField = new JTextField();
        String[] frecuencias = {"Diario", "Semanal", "Mensual"};
        frecuenciaBox = new JComboBox<>(frecuencias);
        aceptarCheckBox = new JCheckBox("Alarma");
        guardarButton = new JButton("Guardar");
        limpiarButton = new JButton("Limpiar");

        formularioPanel.add(new JLabel("Descripción del Evento:"));
        formularioPanel.add(descripcionField);
        formularioPanel.add(new JLabel("Email:"));
        formularioPanel.add(emailField);
        formularioPanel.add(new JLabel("Fecha:"));
        formularioPanel.add(fechaField);
        formularioPanel.add(new JLabel("Frecuencia:"));
        formularioPanel.add(frecuenciaBox);
        formularioPanel.add(aceptarCheckBox);
        formularioPanel.add(new JLabel()); // Espacio vacío
        formularioPanel.add(guardarButton);
        formularioPanel.add(limpiarButton);

        tabbedPane.addTab("Formulario", formularioPanel);

        JPanel tablaPanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Descripción");
        tableModel.addColumn("Email");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Frecuencia");
        tableModel.addColumn("Términos");
        JTable tablaEventos = new JTable(tableModel);
        JScrollPane tablaScrollPane = new JScrollPane(tablaEventos);
        tablaPanel.add(tablaScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Registros", tablaPanel);

        JPanel invitadoPanel = new JPanel(new GridLayout(9, 2, 5, 5));

        nombreInvitadoField = new JTextField();
        telefonoInvitadoField = new JTextField();
        direccionInvitadoField = new JTextField();

        String[] dias = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String[] años = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"};

        diaNacimientoBox = new JComboBox<>(dias);
        mesNacimientoBox = new JComboBox<>(meses);
        añoNacimientoBox = new JComboBox<>(años);

        generoMasculino = new JRadioButton("Masculino");
        generoFemenino = new JRadioButton("Femenino");
        grupoGenero = new ButtonGroup();
        grupoGenero.add(generoMasculino);
        grupoGenero.add(generoFemenino);

        terminosCheckBox = new JCheckBox("Aceptar Términos y Condiciones");

        registrarInvitadoButton = new JButton("Registrar");
        resetearButton = new JButton("Resetear");

        invitadoPanel.add(new JLabel("Nombre:"));
        invitadoPanel.add(nombreInvitadoField);
        invitadoPanel.add(new JLabel("Número de Celular:"));
        invitadoPanel.add(telefonoInvitadoField);
        invitadoPanel.add(new JLabel("Género:"));
        JPanel panelGenero = new JPanel();
        panelGenero.add(generoMasculino);
        panelGenero.add(generoFemenino);
        invitadoPanel.add(panelGenero);
        invitadoPanel.add(new JLabel("Fecha de Nacimiento:"));
        invitadoPanel.add(diaNacimientoBox);
        invitadoPanel.add(new JLabel("/"));
        invitadoPanel.add(mesNacimientoBox);
        invitadoPanel.add(new JLabel("/"));
        invitadoPanel.add(añoNacimientoBox);
        invitadoPanel.add(new JLabel("Dirección:"));
        invitadoPanel.add(direccionInvitadoField);
        invitadoPanel.add(terminosCheckBox);
        invitadoPanel.add(new JLabel()); // Espacio vacío
        invitadoPanel.add(registrarInvitadoButton);
        invitadoPanel.add(resetearButton);

        tabbedPane.addTab("Registrar Invitado", invitadoPanel);

        add(tabbedPane);

        setTitle("Gestión de Eventos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JTextField getDescriptionField() { return descripcionField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getDateField() { return fechaField; }
    public JComboBox<String> getFrequencyBox() { return frecuenciaBox; }
    public JCheckBox getAgreeCheckBox() { return aceptarCheckBox; }
    public JButton getSaveButton() { return guardarButton; }
    public JButton getClearButton() { return limpiarButton; }
    public DefaultTableModel getTableModel() { return tableModel; }

    public JTextField getGuestNameField() { return nombreInvitadoField; }
    public JTextField getGuestPhoneField() { return telefonoInvitadoField; }
    public JTextField getGuestAddressField() { return direccionInvitadoField; }
    public JComboBox<String> getGuestDOBDayBox() { return diaNacimientoBox; }
    public JComboBox<String> getGuestDOBMonthBox() { return mesNacimientoBox; }
    public JComboBox<String> getGuestDOBYearBox() { return añoNacimientoBox; }
    public JRadioButton getGuestGenderMale() { return generoMasculino; }
    public JRadioButton getGuestGenderFemale() { return generoFemenino; }
    public JCheckBox getGuestTermsCheckBox() { return terminosCheckBox; }
    public JButton getGuestRegisterButton() { return registrarInvitadoButton; }
    public JButton getGuestResetButton() { return resetearButton; }
}

