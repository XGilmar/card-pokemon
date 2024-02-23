package app.pokemon.controlador;

import app.pokemon.util.Validaciones;
import app.pokemon.util.WrapLayout;
import app.pokemon.vista.PaneInicio;
import cardSwing.PnCard;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.pokemon.PokemonSpecies;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.FlavorText;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import glasspanepopup.GlassPanePopup;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import pagination.style.PaginationItemRenderStyle1;

public class ControladorInicio {

    private final PaneInicio paneInicio;

    public ControladorInicio(PaneInicio paneInicio) {
        this.paneInicio = paneInicio;
        GlassPanePopup.install(ControladorDashboard.getInstance());
    }

    public void iniciar() {
        Validaciones.barraEstiloCategoria(paneInicio.pnContenedor);
        cargarDatosPagina(1);
        pagina();
    }

    private void pagina() {
        paneInicio.pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        paneInicio.pagination1.addEventPagination((int page) -> {
            cargarDatosPagina(page);
        });
    }

    private void cargarDatosPagina(int pagina) {
        int limiteDatos = 20;
        int totalDatos = getTotalPokemonSpecies();
        int totalPagina = (int) Math.ceil((double) totalDatos / limiteDatos);
        listarPokemonSpecies(limiteDatos, pagina);
        paneInicio.pagination1.setPagegination(pagina, totalPagina);
    }

    private void listarPokemonSpecies(int limitDatos, int pagina) {
        paneInicio.pnContenedor.setLayout(new WrapLayout(FlowLayout.LEFT, 8, 8));
        SwingWorker<Void, PnCard> worker = new SwingWorker<Void, PnCard>() {
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
                }
                paneInicio.pnContenedor.repaint();
                paneInicio.pnContenedor.revalidate();
            }

            @Override
            protected void done() {
                System.out.println("listo");
            }
        };

        worker.execute();
    }

    /* private void animateCard(PnCard card) {
        if (card != null) {
            int initialY = card.getY();
            int targetY = 5;

            Animator animator = new Animator(500, new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    int newY = (int) (initialY + fraction * (targetY - initialY));
                    // Calcular nueva escala basada en el progreso de la animación
                    // Calcular nueva escala basada en el progreso de la animación

                    card.setLocation(card.getX(), newY);
                    card.repaint();
                }
            });
            animator.setResolution(5);
            animator.start();
        }
    }*/
    private int getTotalPokemonSpecies() {
        NamedAPIResourceList pokemonSpeciesList = PokemonSpecies.getList(0, 0);
        return pokemonSpeciesList.getCount();
    }

    private String obtenerDescripcionPokemon(PokemonSpecies species) {
        List<FlavorText> flavorTexts = species.getFlavorTextEntries();
        for (FlavorText flavorText : flavorTexts) {
            // Filtrar por el idioma deseado (por ejemplo, inglés)
            if (flavorText.getLanguage().getName().equals("es")) {
                return flavorText.getFlavorText();
            }
        }
        return "Descripción no disponible";
    }

}
