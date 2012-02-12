import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
import observer.Observer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shintaro
 */
public class BarGraph extends javax.swing.JPanel implements Observer{
    
    private static final int C00 = 250;
    private static final int C01 = 250;
    private static final int C02 = 20;
    private static final int C03 = 5; 
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private Color I00 = new Color(64, 64, 64);    // 影とふちの色
    private Color colorA = new Color(255, 32, 32);
    private Color colorB = new Color(64, 192, 32);
    private Color colorC = new Color(96, 32, 255);
    
    private Map<Color, Integer> I01;
    private int total;
    private ControlPanel controlPanel;
    /**
     * Creates new form BarGraph
     */
    public BarGraph(ControlPanel controlPanel){
        initComponents();
        this.controlPanel = controlPanel;
       
        
        initComponents();
        setBackground(Color.white);
        setPreferredSize(new Dimension(C00, C01));

        I01 = new LinkedHashMap<Color, Integer>();
        setRates();
    }
    
    
    private void setRates(){
        I01.put(colorA, controlPanel.getA());
        I01.put(colorB, controlPanel.getB());
        I01.put(colorC, controlPanel.getC());
        total = 0;
        for (int L01 : I01.values()) {
            total += L01;
        }
    }
    
    
    @Override
    public void paintComponent(Graphics A00) {
        
        super.paintComponent(A00);

        Graphics2D L00 = (Graphics2D) A00;
        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        L00.setColor(I00);
        L00.drawRect(C02, C02, WIDTH, HEIGHT);
        
        
        L00.setColor(Color.white);
        L00.fillRect(C02 + 2, C02 - 2, WIDTH, HEIGHT);

        setRates();
        
        int start = C02 + 20;
        for (Color L03 : I01.keySet()) {
            double value = I01.get(L03);
            int height = (int)((value / 100)*HEIGHT);
            L00.setColor(L03);
            L00.fillRect(start, C02 + (HEIGHT - height) , 30, height);
            start += 60;
        }
        // 四捨五入の都合で塗り残しが出た場合の対処
        for (Color L03 : I01.keySet()){
            if(I01.get(L03) != 0)
                L00.setColor(L03);
        }

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void nortify() {
        this.repaint();
    }
}
