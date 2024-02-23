package paneRound;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JpanelFlatRound extends JPanel {

    public JpanelFlatRound() {
        init();
    }

    private void init() {
        setOpaque(false);
        //setLayout(new BorderLayout());
        //+ "border:5,5,5,5;"
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,3%);"
                + "[light]border:0,0,0,0,shade(@background,15%),,20;"
                + "[dark]border:0,0,0,0,tint(@background,15%),,20");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        FlatUIUtils.setRenderingHints(g2);
        int arc = UIScale.scale(20);
        g2.setColor(getBackground());
        FlatUIUtils.paintComponentBackground(g2, 0, 0, getWidth(), getHeight(), 0, arc);
        g2.dispose();
        super.paintComponent(g);
    }
}
