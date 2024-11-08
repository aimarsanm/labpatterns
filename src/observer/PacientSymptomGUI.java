package observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import domain.Covid19Pacient;
import domain.Symptom;
import domain.SymptomFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;

public class PacientSymptomGUI extends JFrame {
    private JPanel contentPane;
    private JTextField weightField;
    JComboBox<Symptom> symptomComboBox;
    private JButton btnRemoveSymptom;
    private JLabel errorLabel;
    private JLabel lblPacient;
    private JLabel labelPacient;
    private Covid19Pacient pacient;// Atributo para almacenar el paciente

    /**
     * Create the frame.
     */
    public PacientSymptomGUI(Covid19Pacient p) {
        this.pacient = p;  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblSelectSymptom = new JLabel("Select Symptom");
        lblSelectSymptom.setBounds(32, 68, 100, 16);
        contentPane.add(lblSelectSymptom);
        
        symptomComboBox = new JComboBox<Symptom>();
        symptomComboBox.setBounds(195, 57, 192, 27);
        SymptomFactory factory = SymptomFactory.getInstance();
        List<Symptom> symptoms = factory.getAllSymptoms();
        
        for (Symptom symptom : symptoms) {
            symptomComboBox.addItem(symptom); // Añadir cada síntoma al JComboBox
        }
        //añadir mas cosas
        contentPane.add(symptomComboBox);
        
        JLabel lblSymptomWeight = new JLabel("Symptom weight");
        lblSymptomWeight.setBounds(32, 96, 125, 16);
        contentPane.add(lblSymptomWeight);
        
        weightField = new JTextField();
        weightField.setBounds(195, 91, 130, 26);
        contentPane.add(weightField);
        weightField.setColumns(10);
        
        JButton btnAddSymptom = new JButton("Add Symptom");
        btnAddSymptom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                try {
                    int weight = Integer.parseInt(weightField.getText());
                    if (weight <= 3) {
                        Symptom selectedSymptom = (Symptom) symptomComboBox.getSelectedItem();
                        pacient.addSymptomByName(selectedSymptom.getName(), weight);
                        errorLabel.setText("Symptom added: " + selectedSymptom.getName());
                    } else {
                        errorLabel.setText("ERROR, Weight between [1..3]");
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("ERROR, invalid weight");
                }
            }
        });
        btnAddSymptom.setBounds(88, 202, 117, 29);
        contentPane.add(btnAddSymptom);
        
        btnRemoveSymptom = new JButton("Remove Symptom");
        btnRemoveSymptom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                Symptom selectedSymptom = (Symptom) symptomComboBox.getSelectedItem();
                pacient.removeSymptomByName(selectedSymptom.getName());
                errorLabel.setText("Symptom removed: " + selectedSymptom.getName());
            }
        });
        btnRemoveSymptom.setBounds(255, 202, 147, 29);
        contentPane.add(btnRemoveSymptom);
        
        errorLabel = new JLabel("");
        errorLabel.setBounds(117, 146, 238, 16);
        contentPane.add(errorLabel);
        
        lblPacient = new JLabel("Pacient:");
        lblPacient.setBounds(210, 17, 61, 16);
        contentPane.add(lblPacient);
        
        labelPacient = new JLabel(p.getName());
        labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        labelPacient.setBounds(271, 17, 131, 16);
        contentPane.add(labelPacient);

        this.setVisible(true);
    }
    public void addSymptom(String symptomName, int weight) {
        pacient.addSymptomByName(symptomName, weight);
    }

    public void removeSymptom(String symptomName) {
        pacient.removeSymptomByName(symptomName);
    }
}
