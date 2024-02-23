package cardSwing;

import app.pokemon.controlador.ControladorDashboard;
import app.pokemon.modelo.PokemonColor;
import app.pokemon.vista.PaneDetalles;
import com.formdev.flatlaf.FlatClientProperties;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.pokemon.PokemonType;
import com.github.oscar0812.pokeapi.models.pokemon.Type;
import glasspanepopup.DefaultOption;
import glasspanepopup.GlassPanePopup;
import glasspanepopup.Option;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import raven.crazypanel.CrazyPanel;
import raven.crazypanel.MigLayoutConstraints;

public class PnCard extends JPanel {

    private final Pokemon pokemon;
    private final String descripcion;

    private Color rgbFondo;

    public String getDescripcion() {
        return descripcion;
    }

    public Color getRgbFondo() {
        return rgbFondo;
    }

    public void setRgbFondo(Color rgbFondo) {
        this.rgbFondo = rgbFondo;
    }

    public PnCard(Pokemon pokemon, String descripcion) {
        initComponents();
        setOpaque(false);
        GlassPanePopup.install(ControladorDashboard.getInstance());
        mostrarDatos(pokemon);

        this.pokemon = pokemon;
        this.descripcion = descripcion;
    }

    private void mostrarDatos(Pokemon pokemon) {
        try {
            BufferedImage img = ImageIO.read(new URL(pokemon.getSprites().getFrontDefault()));
            imgBox.setImagen(img);
            imgBox.setCustomCursor();
            imgBox.addMouseListener(new PanelMouseListener());
            labeId.setText(String.valueOf("N° 0" + pokemon.getId()));
            labeNombre.setText(pokemon.getName());
            ArrayList<PokemonType> pokemons = pokemon.getTypes();
            String primerTipo = pokemons.get(0).getType().getName();
            Color rgbColor = obtenerColorTipo(primerTipo, 40);
            imgBox.setColorRadial(rgbColor);
            setRgbFondo(rgbColor);
            for (PokemonType tipos : pokemons) {
                Type tipoInfo = tipos.getType();
                contenedorTipos.add(crearPanelTipo(tipoInfo.getName()));
            }
            labeAltura.setText(String.valueOf(pokemon.getHeight() + "M"));
            labePeso.setText(String.valueOf(pokemon.getWeight() + "Kg"));
        } catch (IOException ex) {
            Logger.getLogger(PnCard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private CrazyPanel crearPanelTipo(String pokemonTipo) {
        MigLayoutConstraints constraints = new MigLayoutConstraints("insets 5 10 5 10", null, null, null);
        CrazyPanel contenedor = new CrazyPanel();
        contenedor.setMigLayoutConstraints(constraints);
        JLabel labelTipo = new JLabel();
        labelTipo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:plain -4"
        );
        contenedor.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10"
        );
        contenedor.setBackground(obtenerColorTipo(pokemonTipo, 220));
        labelTipo.setText(pokemonTipo);
        labelTipo.setForeground(Color.white);
        contenedor.add(labelTipo);
        return contenedor;
    }

    private Color obtenerColorTipo(String tipo, int transparencia) {
        for (PokemonColor color : PokemonColor.values()) {
            if (color.name().equalsIgnoreCase(tipo)) {
                return new Color(color.getRgbColor().getRed(), color.getRgbColor().getGreen(), color.getRgbColor().getBlue(), transparencia);
            }
        }
        // Si no se encuentra un color correspondiente, se puede devolver un color predeterminado o lanzar una excepción
        return Color.GRAY;
    }

    private class PanelMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            PaneDetalles detalles = new PaneDetalles(pokemon, getDescripcion(), getRgbFondo());
            Option option = new DefaultOption() {
                @Override
                public float opacity() {
                    return 0.5f;
                }

                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }

                @Override
                public Color background() {
                    return new Color(40, 40, 40);
                }

            };
            GlassPanePopup.showPopup(detalles, option);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyBase = new raven.crazypanel.CrazyPanel();
        contenedorImagen = new raven.crazypanel.CrazyPanel();
        imgBox = new swing.ImageBoxRadial();
        contenedorDetalle = new raven.crazypanel.CrazyPanel();
        contenedorId = new raven.crazypanel.CrazyPanel();
        labeId = new javax.swing.JLabel();
        crazyPanel5 = new raven.crazypanel.CrazyPanel();
        labePeso = new javax.swing.JLabel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        labeAltura = new javax.swing.JLabel();
        contenedorNombreId = new raven.crazypanel.CrazyPanel();
        labeNombre = new javax.swing.JLabel();
        contenedorTipos = new raven.crazypanel.CrazyPanel();

        crazyBase.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,5%);[light]border:0,0,0,0,shade(@background,12%),,20;[dark]border:0,0,0,0,tint(@background,12%),,20",
            null
        ));
        crazyBase.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fillx,gap 2",
            "[fill]",
            "[grow 0][fill]",
            new String[]{
                "height 150,width 170"
            }
        ));

        contenedorImagen.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,1%);[light]border:0,0,0,0,shade(@background,15%),,15;[dark]border:0,0,0,0,tint(@background,15%),,15",
            null
        ));
        contenedorImagen.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 1,fill",
            "[fill]",
            "[fill]",
            null
        ));
        contenedorImagen.add(imgBox);

        crazyBase.add(contenedorImagen);

        contenedorDetalle.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,5%)",
            null
        ));
        contenedorDetalle.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 1,wrap,fillx,gap 2",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        contenedorId.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,5%)",
            new String[]{
                "font:bold -1;[light]foreground:tint(@foreground,40%);[dark]foreground:shade(@foreground,40%)"
            }
        ));
        contenedorId.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 5 2 5 2,gapx 5",
            "[]push[][]",
            "",
            null
        ));
        contenedorId.setName(""); // NOI18N

        labeId.setText("N° 001");
        contenedorId.add(labeId);

        crazyPanel5.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:10;background:lighten(@background,12%)",
            new String[]{
                "font:plain -4"
            }
        ));
        crazyPanel5.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 5",
            "",
            "",
            null
        ));

        labePeso.setText("500kg");
        crazyPanel5.add(labePeso);

        contenedorId.add(crazyPanel5);

        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:10;background:lighten(@background,12%)",
            new String[]{
                "font:plain -4"
            }
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 5",
            "",
            "",
            null
        ));

        labeAltura.setText("20M");
        crazyPanel4.add(labeAltura);

        contenedorId.add(crazyPanel4);

        contenedorDetalle.add(contenedorId);

        contenedorNombreId.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,5%)",
            new String[]{
                "font:bold +4"
            }
        ));
        contenedorNombreId.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 4 2 4 2",
            "",
            "",
            null
        ));

        labeNombre.setText("nombre");
        contenedorNombreId.add(labeNombre);

        contenedorDetalle.add(contenedorNombreId);

        contenedorTipos.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,5%)",
            null
        ));
        contenedorTipos.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 5 2 5 2,gapx 5",
            "",
            "",
            null
        ));
        contenedorDetalle.add(contenedorTipos);

        crazyBase.add(contenedorDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyBase, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyBase, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.crazypanel.CrazyPanel contenedorDetalle;
    private raven.crazypanel.CrazyPanel contenedorId;
    private raven.crazypanel.CrazyPanel contenedorImagen;
    private raven.crazypanel.CrazyPanel contenedorNombreId;
    private raven.crazypanel.CrazyPanel contenedorTipos;
    private raven.crazypanel.CrazyPanel crazyBase;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private raven.crazypanel.CrazyPanel crazyPanel5;
    private swing.ImageBoxRadial imgBox;
    private javax.swing.JLabel labeAltura;
    private javax.swing.JLabel labeId;
    private javax.swing.JLabel labeNombre;
    private javax.swing.JLabel labePeso;
    // End of variables declaration//GEN-END:variables
}
