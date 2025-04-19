
package utils;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author alancueva
 */
public class DragComponentHelper {
     private Point initialClick; // Punto inicial del clic del mouse
    private final Component component; // Componente que se va a arrastrar

    public DragComponentHelper(Component component) {
        this.component = component;
        makeDraggable();
    }

    // Hace que el componente sea arrastrable
    private void makeDraggable() {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Guardar el punto inicial del clic
                initialClick = e.getPoint();
            }
        });

        component.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Calcular la nueva posición del componente
                int x = component.getLocation().x + e.getX() - initialClick.x;
                int y = component.getLocation().y + e.getY() - initialClick.y;
                component.setLocation(x, y);
            }
        });
    }
}
