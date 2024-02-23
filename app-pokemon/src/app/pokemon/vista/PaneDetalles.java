package app.pokemon.vista;

import app.pokemon.util.Validaciones;
import com.formdev.flatlaf.FlatClientProperties;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.pokemon.PokemonStat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PaneDetalles extends javax.swing.JPanel {

    private final Pokemon pokemon;
    private final String descripcion;
    private final Color rgbFondo;

    public PaneDetalles(Pokemon pokemon, String descripcion, Color rgbFondo) {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        this.pokemon = pokemon;
        this.descripcion = descripcion;
        this.rgbFondo = rgbFondo;
        iniciar();

    }

    private void iniciar() {
        cargarImagen();
        lblNombre.setText(pokemon.getName());
        configurarTexto();
        mostrarStatss();
    }

    private void cargarImagen() {
        try {
            BufferedImage img = ImageIO.read(new URL(pokemon.getSprites().getFrontDefault()));
            imageBoxRadial1.setImagen(img);
            imageBoxRadial1.setColorRadial(rgbFondo);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void configurarTexto() {
        Validaciones.barraEstiloCategoria(txt);
        txt.putClientProperty(FlatClientProperties.STYLE, "font:plain -2;"
                + "[light]foreground:tint(@foreground,35%);"
                + "[dark]foreground:shade(@foreground,35%);");
        StyledDocument doc = txt.getStyledDocument();
        SimpleAttributeSet textAlignment = new SimpleAttributeSet();
        StyleConstants.setAlignment(textAlignment, StyleConstants.ALIGN_JUSTIFIED);
        doc.setParagraphAttributes(0, doc.getLength(), textAlignment, false);
        txt.setText(descripcion.replaceAll("[\n\f]", " "));
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private void mostrarStatss() {
        Map<String, Integer> statsMap = obtenerStatsMap(pokemon);
        actualizarBarra(barHp, statsMap.getOrDefault("hp", -1), lblHp);
        actualizarBarra(barAtaque, statsMap.getOrDefault("attack", -1), lblAtaque);
        actualizarBarra(barDefensa, statsMap.getOrDefault("defense", -1), lblDefensa);
        actualizarBarra(barAspecial, statsMap.getOrDefault("special-attack", -1), lblAspecial);
        actualizarBarra(barDspecial, statsMap.getOrDefault("special-defense", -1), lblDspecial);
        actualizarBarra(barVelocidad, statsMap.getOrDefault("speed", -1), lblVelocidad);
    }

    private void actualizarBarra(JProgressBar barra, int valor, JLabel label) {
        barra.setValue(valor);
        label.setText(String.valueOf(valor));
    }

    private Map<String, Integer> obtenerStatsMap(Pokemon pokemon) {
        Map<String, Integer> statsMap = new HashMap<>();
        List<PokemonStat> stats = pokemon.getStats();
        for (PokemonStat stat : stats) {
            statsMap.put(stat.getStat().getName(), stat.getBaseStat());
        }
        return statsMap;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new swing.PanelShadow();
        crContenedorImg = new raven.crazypanel.CrazyPanel();
        imageBoxRadial1 = new swing.ImageBoxRadial();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        lblNombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHp = new javax.swing.JLabel();
        barHp = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        lblAtaque = new javax.swing.JLabel();
        barAtaque = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        lblDefensa = new javax.swing.JLabel();
        barDefensa = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        lblAspecial = new javax.swing.JLabel();
        barAspecial = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        lblDspecial = new javax.swing.JLabel();
        barDspecial = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        lblVelocidad = new javax.swing.JLabel();
        barVelocidad = new javax.swing.JProgressBar();

        panelShadow1.setShadowSize(5);

        crContenedorImg.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:lighten(@background,1%);[light]border:0,0,0,0,shade(@background,12%),,10;[dark]border:0,0,0,0,tint(@background,12%),,10",
            null
        ));
        crContenedorImg.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 1",
            "[fill]",
            "[fill]",
            null
        ));
        crContenedorImg.add(imageBoxRadial1);

        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fillx,gap 2,insets 1 5 1 5",
            "[fill]",
            "",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "font:bold +1"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 5 5 5 1",
            "[]push[]",
            "",
            null
        ));

        lblNombre.setText("Nombre");
        crazyPanel2.add(lblNombre);

        crazyPanel1.add(crazyPanel2);
        crazyPanel1.add(jSeparator1);

        txt.setEditable(false);
        txt.setText("Est quia libero vel voluptatibus rerum sed unde voluptatem aut repudiandae voluptatem et iure voluptatem vel repudiandae neque ut praesentium voluptate.");
        jScrollPane2.setViewportView(txt);

        crazyPanel1.add(jScrollPane2);

        crazyPanel3.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fillx,gap 2",
            "[fill]",
            "",
            null
        ));

        jLabel1.setText("Estadísticas");
        crazyPanel3.add(jLabel1);

        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2",
                "",
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2",
                "",
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2",
                "",
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2",
                "",
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2",
                "",
                "font:plain -2;[light]foreground:tint(@foreground,20%);[dark]foreground:shade(@foreground,20%)",
                "font:plain -2"
            }
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fillx,gap 5",
            "[fill]",
            "",
            new String[]{
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "split 2",
                ""
            }
        ));

        jLabel2.setText("Hp");
        crazyPanel4.add(jLabel2);

        lblHp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHp.setText("0");
        crazyPanel4.add(lblHp);

        barHp.setForeground(new java.awt.Color(68, 170, 51));
        barHp.setValue(5);
        crazyPanel4.add(barHp);

        jLabel3.setText("Ataque");
        crazyPanel4.add(jLabel3);

        lblAtaque.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAtaque.setText("0");
        crazyPanel4.add(lblAtaque);

        barAtaque.setForeground(new java.awt.Color(255, 153, 51));
        barAtaque.setValue(5);
        crazyPanel4.add(barAtaque);

        jLabel4.setText("Defensa");
        crazyPanel4.add(jLabel4);

        lblDefensa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDefensa.setText("0");
        crazyPanel4.add(lblDefensa);

        barDefensa.setForeground(new java.awt.Color(0, 102, 153));
        barDefensa.setValue(5);
        crazyPanel4.add(barDefensa);

        jLabel5.setText("Ataque especial");
        crazyPanel4.add(jLabel5);

        lblAspecial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAspecial.setText("0");
        crazyPanel4.add(lblAspecial);

        barAspecial.setForeground(new java.awt.Color(153, 51, 255));
        barAspecial.setValue(5);
        crazyPanel4.add(barAspecial);

        jLabel6.setText("Defensa especial");
        crazyPanel4.add(jLabel6);

        lblDspecial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDspecial.setText("0");
        crazyPanel4.add(lblDspecial);

        barDspecial.setForeground(new java.awt.Color(255, 204, 51));
        barDspecial.setValue(5);
        crazyPanel4.add(barDspecial);

        jLabel7.setText("Velocidad");
        crazyPanel4.add(jLabel7);

        lblVelocidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVelocidad.setText("0");
        crazyPanel4.add(lblVelocidad);

        barVelocidad.setForeground(new java.awt.Color(255, 255, 255));
        barVelocidad.setValue(5);
        crazyPanel4.add(barVelocidad);

        crazyPanel3.add(crazyPanel4);

        crazyPanel1.add(crazyPanel3);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(crContenedorImg, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crContenedorImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barAspecial;
    private javax.swing.JProgressBar barAtaque;
    private javax.swing.JProgressBar barDefensa;
    private javax.swing.JProgressBar barDspecial;
    private javax.swing.JProgressBar barHp;
    private javax.swing.JProgressBar barVelocidad;
    private raven.crazypanel.CrazyPanel crContenedorImg;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private swing.ImageBoxRadial imageBoxRadial1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAspecial;
    private javax.swing.JLabel lblAtaque;
    private javax.swing.JLabel lblDefensa;
    private javax.swing.JLabel lblDspecial;
    private javax.swing.JLabel lblHp;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblVelocidad;
    private swing.PanelShadow panelShadow1;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables
}
