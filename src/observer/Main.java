package observer;

import domain.Covid19Pacient;

public class Main {
    public static void main(String[] args) {
        Covid19Pacient pacient = new Covid19Pacient("Aitor", 35);
        new PacientObserverGUI(pacient);
        PacientSymptomGUI symptomGUI = new PacientSymptomGUI(pacient);
        PacientThermometerGUI gui1_1 = new PacientThermometerGUI(pacient);
        SemaphorGUI gui= new SemaphorGUI(pacient);
    }
}
