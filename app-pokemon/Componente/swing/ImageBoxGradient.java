package swing;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.UIScale;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JLayeredPane;

public class ImageBoxGradient extends JLayeredPane {

    private Image imagen;

    public void setImagen(Image imagen) {
        this.imagen = imagen;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        FlatUIUtils.setRenderingHints(g2);
        int arc = UIScale.scale(10);
        Color color = FlatLaf.isLafDark() ? ColorFunctions.lighten(getParent().getBackground(), 0.07f) : ColorFunctions.darken(getParent().getBackground(), 0.05f);
        g2.setPaint(new GradientPaint(0, getHeight(), color, 0, 0, getBackground()));
        g2.setComposite(AlphaComposite.SrcOver.derive(0.90f));
        FlatUIUtils.paintComponentBackground(g2, 0, 0, getWidth(), getHeight(), 0, arc);
        if (imagen != null) {
            // Obtenemos el tamaño del componente
            Dimension size = getSize();
            // Obtenemos el tamaño de la imagen
            int imageWidth = imagen.getWidth(this);
            int imageHeight = imagen.getHeight(this);
            double scaleX = (double) size.width / imageWidth;
            double scaleY = (double) size.height / imageHeight;
            double scale = Math.min(scaleX, scaleY); // Tomamos el menor de los dos escalados para mantener la proporción
            // Calculamos el nuevo tamaño de la imagen
            int newWidth = (int) (imageWidth * scale);
            int newHeight = (int) (imageHeight * scale);
            // Calculamos la posición para centrar la imagen en el contenedor
            int x = (size.width - newWidth) / 2;
            int y = (size.height - newHeight) / 2;
            g2.drawImage(imagen, x, y, newWidth, newHeight, this);
        }
        g2.dispose();

    }

    // Método para establecer un cursor personalizado
    public void setCustomCursor() {
        Cursor customCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); // Ejemplo de cursor personalizado
        setCursor(customCursor);
    }

}
