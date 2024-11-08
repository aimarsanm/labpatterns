package adapter;

import java.util.Iterator;

import domain.Covid19Pacient;
import domain.Symptom;

public class Main {
    public static void main(String[] args) {

    	Covid19Pacient pacient = new Covid19Pacient("John Doe", 45);
        
        pacient.addSymptomByName("fiebre", 4);
        pacient.addSymptomByName("tos seca", 3);
        pacient.addSymptomByName("dolor de garganta", 2);
        pacient.addSymptomByName("mialgia", 5);
        pacient.addSymptomByName("congesti�n nasal", 1);

        Covid19PacientInvertedAdapter adapter = new Covid19PacientInvertedAdapter(pacient);

        System.out.println("Sintomas ordenados por nombre:");
        Iterator<Symptom> nameSortedIterator = Sorting.sortedIteratorName(adapter.invertedIterator(), new SymptomNameComparator());
        while (nameSortedIterator.hasNext()) {
            System.out.println(nameSortedIterator.next());
        }

        System.out.println("Sintomas ordenados por indice de severidad:");
        Iterator<Symptom> severitySortedIterator = Sorting.sortedIteratorIndex(adapter.invertedIterator(), new SymptomSeverityComparator());
        while (severitySortedIterator.hasNext()) {
            System.out.println(severitySortedIterator.next());
        }
    }
}
