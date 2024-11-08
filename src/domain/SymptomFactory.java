package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomFactory {
	
	
    private static SymptomFactory instance;

	  private Map<String, Symptom> symptomMap;

	   public SymptomFactory() {
	        symptomMap = new HashMap<>();
	    }
	    
	 public Symptom createSymptom(String symptomName) {
		 
		 if (symptomMap.containsKey(symptomName)) {
	            return symptomMap.get(symptomName);
	        }
		 
	    List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia","expectoracion");
	    List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
	    List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea","mialgia","escalofrios");
	    List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
	    List<String> impact1 = Arrays.asList("mareos", "nauseas", "vómitos", "congestión nasal","diarrea","hemoptisis","congestion conjuntival");
	    List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8);
	    
	    List<String> digestiveSymptom=Arrays.asList("nauseas", "vómitos","diarrea");
	    List<String> neuroMuscularSymptom=Arrays.asList("fiebre", "astenia", "cefalea", "mialgia","escalofrios");
	    List<String> respiratorySymptom=Arrays.asList("tos seca","expectoracion","disnea","dolor de garganta", "congestión nasal","hemoptisis","congestion conjuntival");
	    List<String> movilitySymptom= Arrays.asList("mareos");

	    int impact=0;
	    double index=0;
	    if (impact5.contains(symptomName)) {
	        impact = 5;
	        int symptomIndex = impact5.indexOf(symptomName);
	        if (symptomIndex < index5.size()) {
	            index = index5.get(symptomIndex);
	        }
	    } else if (impact3.contains(symptomName)) {
	        impact = 3;
	        int symptomIndex = impact3.indexOf(symptomName);
	        if (symptomIndex < index3.size()) {
	            index = index3.get(symptomIndex);
	        }
	    } else if (impact1.contains(symptomName)) {
	        impact = 1;
	        int symptomIndex = impact1.indexOf(symptomName);
	        if (symptomIndex < index1.size()) {
	            index = index1.get(symptomIndex);
	        }
	    }
	 
	    if (impact!=0)  {
	    	if (digestiveSymptom.contains(symptomName)) return new DigestiveSymptom(symptomName,(int)index, impact);
	    	if (neuroMuscularSymptom.contains(symptomName)) return new NeuroMuscularSymptom(symptomName,(int)index, impact);
	    	if (respiratorySymptom.contains(symptomName)) return new RespiratorySymptom(symptomName,(int)index, impact);
	    	if (movilitySymptom.contains(symptomName)) return new MovilitySymptom(symptomName,(int)index, impact);
	    }
	    return null;		
		
	}
	   public static SymptomFactory getInstance() {
	        if (instance == null) {
	            instance = new SymptomFactory();
	        }
	        return instance;
	    }

	public List<Symptom> getAllSymptoms() {
        SymptomFactory factory = getInstance();
        return Arrays.asList(
            factory.createSymptom("fiebre"),
            factory.createSymptom("tos seca"),
            factory.createSymptom("astenia"),
            factory.createSymptom("expectoracion"),
            factory.createSymptom("disnea"),
            factory.createSymptom("dolor de garganta"),
            factory.createSymptom("cefalea"),
            factory.createSymptom("mialgia"),
            factory.createSymptom("escalofrios"),
            factory.createSymptom("mareos"),
            factory.createSymptom("nauseas"),
            factory.createSymptom("vómitos"),
            factory.createSymptom("congestión nasal"),
            factory.createSymptom("diarrea"),
            factory.createSymptom("hemoptisis"),
            factory.createSymptom("congestion conjuntival")
        );
	}

}
