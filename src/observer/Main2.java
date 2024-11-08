package observer;

import java.util.Observable;

import domain.Covid19Pacient;
import observer.PacientThermometerGUI;

public class Main2 {
    public static void main(String[] args) {
        // Crear tres pacientes
    	Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35);
        Covid19Pacient pacient2 = new Covid19Pacient("Maria", 42);
        Covid19Pacient pacient3 = new Covid19Pacient("Juan", 50);

        // Crear dos interfaces para cada paciente
        // Paciente 1
        PacientThermometerGUI gui1_1 = new PacientThermometerGUI(pacient1);
        PacientThermometerGUI gui1_2 = new PacientThermometerGUI(pacient1);

        // Paciente 2
        PacientThermometerGUI gui2_1 = new PacientThermometerGUI(pacient2);
        PacientThermometerGUI gui2_2 = new PacientThermometerGUI(pacient2);

        // Paciente 3
        PacientThermometerGUI gui3_1 = new PacientThermometerGUI(pacient3);
        PacientThermometerGUI gui3_2 = new PacientThermometerGUI(pacient3);

        // Posicionar las ventanas para que no se superpongan
        gui1_1.setLocation(100, 100);
        gui1_2.setLocation(600, 100);
        
        gui2_1.setLocation(100, 400);
        gui2_2.setLocation(600, 400);
        
        gui3_1.setLocation(100, 700);
        gui3_2.setLocation(600, 700);
    }
}

