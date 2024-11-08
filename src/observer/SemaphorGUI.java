package observer;

import java.awt.Color;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import domain.Covid19Pacient;


public class SemaphorGUI extends JFrame implements Observer {
    public SemaphorGUI(Observable obs) {
        setSize(100, 100);
        setLocation(350, 10);
        getContentPane().setBackground(Color.green);
        repaint();
        setVisible(true);
        obs.addObserver(this);  // Register as observer
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Covid19Pacient) {
            Covid19Pacient p = (Covid19Pacient) o;
            Color c;
            double current = p.covidImpact();
            if (current < 5) {
                c = Color.green;
            } else if (current <= 10) {
                c = Color.yellow;
            } else {
                c = Color.red;
            }
            getContentPane().setBackground(c);
            repaint();  // Ensure the new background color is painted
        }
    }
}
   

