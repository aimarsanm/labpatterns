package adapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientInvertedAdapter implements InvertedIteratorS<Symptom> {
    private List<Symptom> symptoms;

    public Covid19PacientInvertedAdapter(Covid19Pacient pacient) {
        this.symptoms = new ArrayList<>(pacient.getSymptoms().keySet()); 
    }

    public Iterator<Symptom> invertedIterator() {
        Collections.reverse(symptoms); 
        return symptoms.iterator();
    }
}
