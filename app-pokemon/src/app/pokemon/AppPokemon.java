package app.pokemon;

import app.pokemon.vista.Dashboard;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import javax.swing.UIManager;

public class AppPokemon {

    public static void main(String[] args) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("app/pokemon/util");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.BOLD, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);

        });

    }
}
