package app.pokemon.modelo;

import java.awt.Color;

public enum PokemonColor {

    NORMAL(new Color(168, 167, 122)),
    FIRE(new Color(251, 146, 60)),
    WATER(new Color(37, 99, 235)),
    ELECTRIC(new Color(252, 212, 2)),
    GRASS(new Color(34, 197, 94)),
    ICE(new Color(96, 165, 250)),
    FIGHTING(new Color(194, 46, 40)),
    POISON(new Color(163, 62, 161)),
    GROUND(new Color(226, 191, 101)),
    FLYING(new Color(169, 143, 243)),
    PSYCHIC(new Color(249, 85, 135)),
    BUG(new Color(166, 185, 26)),
    ROCK(new Color(182, 161, 54)),
    GHOST(new Color(115, 87, 151)),
    DRAGON(new Color(111, 53, 252)),
    DARK(new Color(112, 87, 70)),
    STEEL(new Color(183, 183, 206)),
    FAIRY(new Color(214, 133, 173));

    private final Color rgbColor;

    PokemonColor(Color rgbColor) {
        this.rgbColor = rgbColor;
    }

    public Color getRgbColor() {
        return rgbColor;
    }

}
