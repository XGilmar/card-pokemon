package app.pokemon.controlador;

import app.pokemon.util.Validaciones;
import app.pokemon.util.WrapLayout;
import app.pokemon.vista.PaneInicio;
import cardSwing.PnCard;
import com.formdev.flatlaf.FlatClientProperties;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.pokemon.PokemonSpecies;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.FlavorText;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import pagination.style.PaginationItemRenderStyle1;

public class ControladorInicio {

    private final PaneInicio paneInicio;

    public ControladorInicio(PaneInicio paneInicio) {
        this.paneInicio = paneInicio;
        paneInicio.boxItem.addActionListener(new boxCantidadDatos());
    }

    public void iniciar() {
        Validaciones.barraEstiloCategoria(paneInicio.pnContenedor);
        paneInicio.pagination1.putClientProperty(FlatClientProperties.STYLE, "background:lighten(@background,0%);");
        paneInicio.barDatos.putClientProperty(FlatClientProperties.STYLE, "background:lighten(@background,5%)");
        cargarDatosPagina(1);
        pagina();
    }

    private void pagina() {
        paneInicio.pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        paneInicio.pagination1.addEventPagination((int page) -> {
            cargarDatosPagina(page);
        });
    }

    private class boxCantidadDatos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            seleccionarCantidadDatos();
            cargarDatosPagina(1);
        }
    }

    private int seleccionarCantidadDatos() {
        int cantidad = 0;
        removerComponente(paneInicio.pagination1);
        pintarComponente(paneInicio.barDatos);
        paneInicio.barDatos.setMaximum(cantidad);

        switch (paneInicio.boxItem.getSelectedIndex()) {
            case 0 -> {
                cantidad = 10;
                paneInicio.barDatos.setMaximum(cantidad);
            }
            case 1 -> {
                cantidad = 25;
                paneInicio.barDatos.setMaximum(cantidad);
            }
            case 2 -> {
                cantidad = 50;
                paneInicio.barDatos.setMaximum(cantidad);
            }
            case 3 -> {
                cantidad = 100;
                paneInicio.barDatos.setMaximum(cantidad);
            }
            default ->
                throw new AssertionError();
        }
        return cantidad;
    }

    private void cargarDatosPagina(int pagina) {
        int limiteDatos = seleccionarCantidadDatos();
        int totalDatos = getTotalPokemonSpecies();
        int totalPagina = (int) Math.ceil((double) totalDatos / limiteDatos);
        listarPokemonSpecies(limiteDatos, pagina);
        paneInicio.pagination1.setPagegination(pagina, totalPagina);
    }

    private void listarPokemonSpecies(int limitDatos, int pagina) {
        paneInicio.pnContenedor.setLayout(new WrapLayout(FlowLayout.LEFT, 8, 8));

        SwingWorker<Void, PnCard> worker = new SwingWorker<Void, PnCard>() {
            int totalCartas = 0;

            @Override
            protected Void doInBackground() throws Exception {

                paneInicio.pnContenedor.removeAll();
                NamedAPIResourceList pokemonSpecies = Pokemon.getList(limitDatos, ((pagina - 1) * limitDatos));
                for (NamedAPIResource iResource : pokemonSpecies.getResults()) {
                    Pokemon pokemon = Pokemon.getByName(iResource.getName());
                    PokemonSpecies species = pokemon.getSpecies(); // Obtener la especie del Pokémon
                    String descripcion = obtenerDescripcionPokemon(species);
                    PnCard card = new PnCard(pokemon, descripcion);
                    publish(card);
                }
                return null;
            }

            @Override
            protected void process(List<PnCard> chunks) {
                for (PnCard card : chunks) {
                    SwingUtilities.invokeLater(() -> {
                        paneInicio.pnContenedor.add(card);
                    });
                    ++totalCartas;
                }
                paneInicio.barDatos.setValue(totalCartas);
                paneInicio.pnContenedor.repaint();
                paneInicio.pnContenedor.revalidate();

            }

            @Override
            protected void done() {
                if (totalCartas >= paneInicio.barDatos.getMaximum()) {
                    removerComponente(paneInicio.barDatos);
                    pintarComponente(paneInicio.pagination1);
                }
            }
        };

        worker.execute();

    }

    private int getTotalPokemonSpecies() {
        NamedAPIResourceList pokemonSpeciesList = PokemonSpecies.getList(0, 0);
        return pokemonSpeciesList.getCount();
    }

    private String obtenerDescripcionPokemon(PokemonSpecies species) {
        List<FlavorText> flavorTexts = species.getFlavorTextEntries();
        for (FlavorText flavorText : flavorTexts) {
            // Filtrar por el idioma deseado (por ejemplo, español)
            if (flavorText.getLanguage().getName().equals("es")) {
                return flavorText.getFlavorText();
            }
        }
        return "Descripción no disponible";
    }

    private void pintarComponente(Component component) {
        paneInicio.contendorPaginable.add(component);
        paneInicio.contendorPaginable.revalidate();
        paneInicio.contendorPaginable.repaint();

    }

    private void removerComponente(Component component) {
        paneInicio.contendorPaginable.remove(component);

    }

}
