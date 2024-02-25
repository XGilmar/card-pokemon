package app.pokemon.vista;

import app.pokemon.controlador.ControladorInicio;

public class PaneInicio extends javax.swing.JPanel {

    private final ControladorInicio controladorInicio;

    public PaneInicio() {
        initComponents();
        controladorInicio = new ControladorInicio(this);
        controladorInicio.iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contendorPaginable = new raven.crazypanel.CrazyPanel();
        pagination1 = new pagination.Pagination();
        barDatos = new javax.swing.JProgressBar();
        lblCheck = new javax.swing.JLabel();
        contenedorCartas = new raven.crazypanel.CrazyPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnContenedor = new javax.swing.JPanel();
        contenedorControl = new raven.crazypanel.CrazyPanel();
        boxItem = new javax.swing.JComboBox<>();

        contendorPaginable.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "background:lighten(@background,0%)"
            }
        ));
        contendorPaginable.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 10 1 10 1",
            "[grow,center]push[]",
            "",
            new String[]{
                "",
                ""
            }
        ));
        contendorPaginable.add(pagination1);

        barDatos.setForeground(new java.awt.Color(34, 197, 94));
        barDatos.setMaximumSize(new java.awt.Dimension(50, 5));
        barDatos.setMinimumSize(new java.awt.Dimension(50, 5));
        barDatos.setPreferredSize(new java.awt.Dimension(50, 5));
        contendorPaginable.add(barDatos);
        contendorPaginable.add(lblCheck);

        contenedorCartas.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "fill,insets 1",
            "[fill]",
            "[fill]",
            null
        ));

        javax.swing.GroupLayout pnContenedorLayout = new javax.swing.GroupLayout(pnContenedor);
        pnContenedor.setLayout(pnContenedorLayout);
        pnContenedorLayout.setHorizontalGroup(
            pnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1175, Short.MAX_VALUE)
        );
        pnContenedorLayout.setVerticalGroup(
            pnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnContenedor);

        contenedorCartas.add(jScrollPane1);

        contenedorControl.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "background:lighten(@background,4%);arc:10"
            }
        ));
        contenedorControl.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 2 8 2 8",
            "",
            "",
            null
        ));

        boxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "25", "50", "100" }));
        boxItem.setFocusable(false);
        contenedorControl.add(boxItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contendorPaginable, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(contenedorCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(contenedorControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(contenedorControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorCartas, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contendorPaginable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barDatos;
    public javax.swing.JComboBox<String> boxItem;
    public raven.crazypanel.CrazyPanel contendorPaginable;
    private raven.crazypanel.CrazyPanel contenedorCartas;
    private raven.crazypanel.CrazyPanel contenedorControl;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCheck;
    public pagination.Pagination pagination1;
    public javax.swing.JPanel pnContenedor;
    // End of variables declaration//GEN-END:variables
}
