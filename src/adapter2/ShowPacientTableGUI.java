package adapter2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.TableModel;

import domain.Covid19Pacient;


public class ShowPacientTableGUI extends JFrame{
	
	JTable table;
	Covid19Pacient pacient;
	
  
  public ShowPacientTableGUI(Covid19Pacient pacient ) {
	  	this.setTitle("Covid Symptoms "+pacient.getName());
	  	
	  	this.pacient=pacient;
	  	
	  	setFonts();
	    
	  	
	   
	    setTitle("Síntomas de " + pacient.getName());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(new Covid19PacientTableModelAdapter(pacient));
        add(new JScrollPane(table), BorderLayout.CENTER);
	    
	  
  }

  private static void setFonts() {
    Font font = new Font("Dialog", Font.PLAIN, 18);
    UIManager.put("Table.font", font);
    UIManager.put("TableHeader.font", font);
  }
}
