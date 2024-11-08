package adapter2;

import domain.Covid19Pacient;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35);
            Covid19Pacient pacient2 = new Covid19Pacient("Maria", 42);

            pacient1.addSymptomByName("tos seca", 2);
            pacient1.addSymptomByName("fiebre", 3);
            pacient2.addSymptomByName("astenia", 2);

            ShowPacientTableGUI tableGUI1 = new ShowPacientTableGUI(pacient1);
            ShowPacientTableGUI tableGUI2 = new ShowPacientTableGUI(pacient2);

            tableGUI1.setVisible(true);
            tableGUI2.setVisible(true);

            pacient1.addSymptomByName("disnea", 4);
            pacient2.addSymptomByName("cefalea", 1);
        });
    }
}
