package adapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import domain.Symptom;


public class Sorting {
	public static Iterator<Object> sortedIterator(InvertedIterator it, Comparator<Object> comparator) {
	      List<Object> list = new ArrayList<>();
	      it.goLast();
	      while (it.hasPrevious()) {
	    	  Symptom s= (Symptom)it.previous();
	          list.add(s);
	      }

	      Collections.sort(list, comparator);
	      return list.iterator();
	  }

	public static Iterator<Symptom> sortedIteratorName(Iterator<Symptom> invertedIterator,
			SymptomNameComparator symptomNameComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Iterator<Symptom> sortedIteratorIndex(Iterator<Symptom> invertedIterator,
			SymptomSeverityComparator symptomSeverityComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
