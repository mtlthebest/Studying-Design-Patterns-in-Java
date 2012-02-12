
import java.awt.FlowLayout;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author shintaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ControlPanel controlPanel = new ControlPanel();
        PieChart circleGraphPanel = new PieChart(controlPanel);
        BandChart bandChart = new BandChart(controlPanel);
        BarGraph barGraph = new BarGraph(controlPanel);
        controlPanel.addObserver(circleGraphPanel);
        controlPanel.addObserver(bandChart);
        controlPanel.addObserver(barGraph);
        frame.add(controlPanel);
        frame.add(circleGraphPanel);
        frame.add(bandChart);
        frame.add(barGraph);
        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setVisible(true);
                
    }
}
