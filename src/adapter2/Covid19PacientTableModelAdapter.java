package adapter2;

import javax.swing.table.AbstractTableModel;
import domain.Covid19Pacient;
import domain.Symptom;
import java.util.List;
import java.util.Map;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
    protected Covid19Pacient pacient;
    protected String[] columnNames = new String[] {"Symptom", "Weight"};

    public Covid19PacientTableModelAdapter(Covid19Pacient pacient) {
        this.pacient = pacient;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return pacient.getSymptoms().size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        // Convertimos el Map de síntomas en una lista para obtener el síntoma en una posición específica
        List<Map.Entry<Symptom, Integer>> symptomsList = List.copyOf(pacient.getSymptoms().entrySet());
        Symptom symptom = symptomsList.get(row).getKey();
        Integer weight = symptomsList.get(row).getValue();

        switch (col) {
            case 0: return symptom.getName();  // Nombre del síntoma
            case 1: return weight;             // Peso del síntoma
            default: return null;
        }
    }
}
