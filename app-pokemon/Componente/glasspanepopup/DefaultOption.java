package glasspanepopup;

import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author Raven
 */
public class DefaultOption implements Option {

    private float animate;

    @Override
    public String getLayout(Component parent, float animate) {
        if (parent.getHeight() > 0) {
            float an = 20f / parent.getHeight();
            float space = 0.5f + an - (animate * an);
            return "pos 0.5al " + space + "al";
        } else {
            // Handle the case when parent.getHeight() is 0
            // For example, set a default value for space
            return "pos 0.5al 0.25al"; // Example default value
        }
    }

    @Override
    public boolean useSnapshot() {
        return true;
    }

    @Override
    public boolean closeWhenPressedEsc() {
        return true;
    }

    @Override
    public boolean closeWhenClickOutside() {
        return true;
    }

    @Override
    public boolean blockBackground() {
        return true;
    }

    @Override
    public Color background() {
        return new Color(100, 100, 100);
    }

    @Override
    public float opacity() {
        return 0.5f;
    }

    @Override
    public int duration() {
        return 300;
    }

    @Override
    public float getAnimate() {
        return animate;
    }

    @Override
    public void setAnimate(float animate) {
        this.animate = animate;
    }
}
