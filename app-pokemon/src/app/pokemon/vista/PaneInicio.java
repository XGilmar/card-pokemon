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

        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        pagination1 = new pagination.Pagination();
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnContenedor = new javax.swing.JPanel();

        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill",
            "[fill]",
            "[fill]",
            null
        ));

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "background:lighten(@background,0%)"
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "insets 10 1 10 1",
            "[grow,center]",
            "",
            null
        ));
        crazyPanel1.add(pagination1);

        crazyPanel2.add(crazyPanel1);

        crazyPanel3.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 10 1 10 1",
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

        crazyPanel3.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crazyPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(crazyPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(crazyPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crazyPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public pagination.Pagination pagination1;
    public javax.swing.JPanel pnContenedor;
    // End of variables declaration//GEN-END:variables
}
