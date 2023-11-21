import javax.swing.*;
import java.util.Scanner;
// create a pokedex

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PokedexGui().setVisible(true);
            }
        });
    }
    }

