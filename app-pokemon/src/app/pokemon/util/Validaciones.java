package app.pokemon.util;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Validaciones {

    public static Icon createIcon(String path, float scale, Color light, Color dark) {
        FlatSVGIcon icon = new FlatSVGIcon(path, scale);
        if (light != null) {
            FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
            if (dark == null) {
                colorFilter.add(Color.decode("#969696"), light);
            } else {
                colorFilter.add(Color.decode("#969696"), light, dark);
            }
            icon.setColorFilter(colorFilter);
        }
        return icon;
    }

    public static void barraEstiloCategoria(Component component) {
        JScrollPane scroll = (JScrollPane) component.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,2%);"
                + "track:lighten(@background,2%);"
                + "trackArc:999");

    }

    public static void panelVacio(JPanel crazyPanel) {
        JLabel label = new JLabel("No hay elementos agregados");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +3;"
                + "[light]foreground:tint(@foreground,30%);"
                + "[dark]foreground:shade(@foreground,30%);"
        );

        int componentCount = crazyPanel.getComponentCount();
        if (componentCount == 0) {
            crazyPanel.add(label);
            //System.out.println("Vacio");
        } else {
            Component[] components = crazyPanel.getComponents();
            for (Component component : components) {
                if (component instanceof JLabel && ((JLabel) component).getText().equals("No hay elementos agregados")) {
                    crazyPanel.remove(component);
                    break;  // No es necesario seguir iterando si ya se encontró y eliminó el JLabel
                }
            }
            //System.out.println("No vacio");
        }

        crazyPanel.revalidate();
        crazyPanel.repaint();
    }

    public static boolean campoVacio(String campo) {
        String textoSinEspacios = campo.trim();
        return !"".equals(textoSinEspacios);
    }

}
