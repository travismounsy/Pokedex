import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexManager {
    private List<PokemonInfo> pokemonInfoList;
    public PokedexManager() {
        this.pokemonInfoList = new ArrayList<>();
    }
    public void addPokemon (PokemonInfo pokemon) {
        pokemonInfoList.add(pokemon);
        System.out.println("Pokemon added to Pokedex!");
    }
    public PokemonInfo searchPokemon (String name) {
        for (PokemonInfo pokemon : pokemonInfoList) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }
    public List<PokemonInfo> getPokemonList() {
        return pokemonInfoList;
    }
    public void viewAllPokemon() {
        Collections.sort(pokemonInfoList, Comparator.comparing(PokemonInfo :: getName, String.CASE_INSENSITIVE_ORDER ));
        for (PokemonInfo pokemon : pokemonInfoList) {
            System.out.println(pokemon.toString());
        }
    }


}
