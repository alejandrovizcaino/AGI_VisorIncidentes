
package ventana;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A waypoint that is represented by a button on the map.
 *
 * @author Daniel Stahr
 */
public class SwingWaypoint extends DefaultWaypoint {
    private final JButton button;
    private final String text;

    public SwingWaypoint(String text, GeoPosition coord) {
            super(coord);
        this.text = text;
       
        button = new JButton();
        button.setSize(8, 8);
        button.setBackground(Color.red);
        button.setPreferredSize(new Dimension(8, 8));
        button.addMouseListener(new SwingWaypointMouseListener());
        button.setVisible(true);
    }

    JButton getButton() {
        return button;
    }

    private class SwingWaypointMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(button, "You clicked on " + text);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}