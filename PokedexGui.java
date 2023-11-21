import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexGui extends JFrame {
    private final PokedexManager pokedex;
    private final JTextArea displayArea;

    public PokedexGui() {
        this.pokedex = new PokedexManager();

        setTitle("Pokedex");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel buttonPanel = getButtonPanel();

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel getButtonPanel() {
        JButton addPokemonButton = new JButton("Add Pokemon");
        JButton searchPokeButton = new JButton("Search Pokemon");

        addPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPokemon();
            }
        });

        searchPokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPokemon();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addPokemonButton);
        buttonPanel.add(searchPokeButton);
        return buttonPanel;
    }

    private void addPokemon () {
        String name = JOptionPane.showInputDialog(this, "Enter the Pokemon name: ");
        String type = JOptionPane.showInputDialog(this, "Enter the Pokemon type: ");
        String levelStr = JOptionPane.showInputDialog(this, "Enter the Pokemon level: ");
        int level = Integer.parseInt(levelStr);

        PokemonInfo newPokemon = new PokemonInfo(name, type, level);
        pokedex.addPokemon(newPokemon);

        List<PokemonInfo> allPokemon = pokedex.getPokemonList();
        Collections.sort(allPokemon, Comparator.comparing(PokemonInfo :: getName, String.CASE_INSENSITIVE_ORDER));

        StringBuilder allPokemonText = new StringBuilder("All Pokemon in the Pokedex:\n");
        for (PokemonInfo pokemon : allPokemon) {
            allPokemonText.append(pokemon.toString()).append("\n");
        }
        displayArea.setText(allPokemonText.toString());

        JOptionPane.showMessageDialog(this, "Pokemon added to the Pokedex!");
    }
    private void searchPokemon() {
        String name = JOptionPane.showInputDialog(this, "Enter the Pokemon name to search:");

        PokemonInfo foundPokemon = pokedex.searchPokemon(name);

        if (foundPokemon != null) {
            displayArea.setText(foundPokemon.toString());
        } else {
            displayArea.setText("Pokemon not found in the Pokedex.");
        }
    }
    private void viewAllPokemon() {
        pokedex.viewAllPokemon();
        StringBuilder allPokemonText = new StringBuilder("All Pokemon in the Pokedex:\n");
        for (PokemonInfo pokemon : pokedex.getPokemonList()) {
            allPokemonText.append(pokemon.toString()).append("\n");
        }
        displayArea.setText(allPokemonText.toString());
    }
}
