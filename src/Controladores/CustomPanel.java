package Controladores;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
    private Shape forma;

//    public CustomPanel() {
//        // Establece la forma con bordes redondeados
//        forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 85, 85);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        
//        // Habilita el antialiasing para mejorar la calidad de los bordes
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        
//        // Dibuja la forma con bordes redondeados
//        g2d.fill(forma);
//    }
//
//    // Método para establecer la forma del componente
//    public void setShape(Shape shape) {
//        this.forma = shape;
//        repaint();
//    }
     public CustomPanel() {
        // Establece la forma con bordes redondeados basados en el tamaño inicial del panel
        forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 85, 85);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Habilita el antialiasing para mejorar la calidad de los bordes
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Asegúrate de que la forma tenga las dimensiones correctas basadas en el tamaño actual del panel
        forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 85, 85);

        // Dibuja la forma con bordes redondeados
        g2d.fill(forma);
    }
}

