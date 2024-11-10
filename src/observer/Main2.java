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
        PacientObserverGUI gui1_1 = new PacientObserverGUI(pacient1);
        PacientSymptomGUI gui1_2 = new PacientSymptomGUI(pacient1);
        PacientThermometerGUI gui1_3 = new PacientThermometerGUI(pacient1);
        // Paciente 2
        PacientObserverGUI gui2_1 = new PacientObserverGUI(pacient2);
        PacientSymptomGUI gui2_2 = new PacientSymptomGUI(pacient2);
        PacientThermometerGUI gui2_3 = new PacientThermometerGUI(pacient2);
        // Paciente 3
        PacientObserverGUI gui3_1 = new PacientObserverGUI(pacient3);
        PacientSymptomGUI gui3_2 = new PacientSymptomGUI(pacient3);
        PacientThermometerGUI gui3_3 = new PacientThermometerGUI(pacient3);
        // Posicionar las ventanas para que no se superpongan
        
    }
}

