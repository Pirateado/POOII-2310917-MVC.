package Compilador;

import controllers.NewEventController;
import javax.swing.SwingUtilities;
import views.NewEventViews;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NewEventViews view = new NewEventViews();
            new NewEventController(view);
            view.setVisible(true);
        });
    }
}
