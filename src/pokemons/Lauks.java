package pokemons;

import javax.swing.JOptionPane;

public class Lauks {
	public static void CelsUzOzolu() {
	    int mapSize = 5; 
        int playerX = 0; 
        int playerY = 0; 

        int oakX = 4; 
        int oakY = 4;

        boolean gameRunning = true;

        while (gameRunning) {
          
            StringBuilder map = new StringBuilder();
            for (int y = mapSize - 1; y >= 0; y--) { 
                for (int x = 0; x < mapSize; x++) {
                    if (x == playerX && y == playerY) {
                        map.append(" P "); 
                    } else if (x == oakX && y == oakY) {
                        map.append(" O "); 
                    } else {
                        map.append(" . ");
                    }
                }
                map.append("\n");
            }

            String[] options = {"Augšā", "Lejā", "Pa labi", "Pa kreisi", "Iziet"};
            String choice = (String) JOptionPane.showInputDialog( null, "Kur tu ej?\n\n" + map,"Pokémon Staigāšana",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if (choice == null || choice.equals("Iziet")) {
                JOptionPane.showMessageDialog(null, "Spēle beidzās.");
                break;
            }

            switch (choice) {
                case "Augšā" -> { if (playerY < mapSize - 1) playerY++; }
                case "Lejā" -> { if (playerY > 0) playerY--; }
                case "Pa labi" -> { if (playerX < mapSize - 1) playerX++; }
                case "Pa kreisi" -> { if (playerX > 0) playerX--; }
            }

            if (playerX == oakX && playerY == oakY) {
                JOptionPane.showMessageDialog(null, "Tu esi pie Profesora Oak mājas!");
                gameRunning = false;
                
            }
        }
    }
}