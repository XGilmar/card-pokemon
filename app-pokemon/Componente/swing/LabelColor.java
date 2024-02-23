package swing;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.UIScale;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelColor extends JLabel {

    public LabelColor(Icon icon, Color color) {
        super(icon);
        putClientProperty(FlatClientProperties.STYLE, ""
                + "border:4,4,4,4");
        setBackground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        FlatUIUtils.setRenderingHints(g2);
        int arc = UIScale.scale(10);
        Color color = FlatLaf.isLafDark() ? ColorFunctions.lighten(getParent().getBackground(), 0.05f) : ColorFunctions.darken(getParent().getBackground(), 0.05f);
        g2.setPaint(new GradientPaint(0, getHeight(), color, 0, 0, getBackground()));
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        FlatUIUtils.paintComponentBackground(g2, 0, 0, getWidth(), getHeight(), 0, arc);
        g2.dispose();
        super.paintComponent(g);
    }
}
