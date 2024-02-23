package app.pokemon.controlador;

import app.pokemon.vista.Dashboard;
import app.pokemon.vista.PaneInicio;
import java.awt.Component;

public class ControladorDashboard {

    private static Dashboard instancia;
    private final Dashboard dashboard;

    public ControladorDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        ControladorDashboard.instancia = dashboard;
    }

    public void iniciar() {
        mostrarForm(new PaneInicio());
    }

    private void mostrarForm(Component com) {
        dashboard.body.removeAll();
        dashboard.body.add(com);
        dashboard.body.repaint();
        dashboard.body.revalidate();
    }

    public static Dashboard getInstance() {
        if (instancia == null) {
            instancia = new Dashboard();
        }
        return instancia;
    }

}
