package pokemons;

import javax.swing.JOptionPane;

public class Lauks {
	
	//Iespējams, šo vajadzēs pārmainīt uz kaut ko citu.
	public static void CelsUzOzolu() {
	    int mapSize = 5;
	    
        int playerX = 1; 
        int playerY = 0; 

        int oakX = 4; 
        int oakY = 4;
        
        int ZaleX = 2; 
        int ZaleY = 4;
        
        int MajasX = 0; 
        int MajasY = 0;

        boolean gameRunning = true;

        while (gameRunning) {
          
            StringBuilder map = new StringBuilder();
            for (int y = mapSize - 1; y >= 0; y--) { 
                for (int x = 0; x < mapSize; x++) {
                    if (x == playerX && y == playerY) {
                        map.append(" P "); 
                    } else if (x == oakX && y == oakY) {
                        map.append(" H "); 
                    } else if (x == ZaleX && y == ZaleY) {
                        map.append(" Z "); 
                    } else if (x == MajasX && y == MajasY) {
                        map.append(" M "); 
                    } else {
                        map.append(" [] ");
                    }
                }
                map.append("\n");
            }

            String[] options = {"Augšā", "Lejā", "Pa labi", "Pa kreisi"};
            String choice = (String) JOptionPane.showInputDialog( null, "Kur tu ej?\n\n" + map,"Pokémon Staigāšana",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if (choice == null) {
                JOptionPane.showMessageDialog(null, "Atgriežamies mājās.");
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
                izveidotPokemonu();
            }
            
            if (playerX == ZaleX && playerY == ZaleY) {
            	if(Pokedatnis.pokemoni.isEmpty()==true) {
            	JOptionPane.showMessageDialog(null, "Zāle ir bīstama! Man tur nevajadzētu iet bez pokemona!");
            	}else {
                JOptionPane.showMessageDialog(null, "Tu esi iegājis zaļajā zāle!");
               ZalaZale();
            	}
            }
            
            if (playerX == MajasX && playerY == MajasY) {
                JOptionPane.showMessageDialog(null, "Tu esi atgriezies mājās!");
                gameRunning = false;
                
            }
        }
    }

	static void izveidotPokemonu() {
		String[] tipi = {"Elektriskais", "Ūdens"};

	    String tips = (String) JOptionPane.showInputDialog(   null,"Izvēlies sava pokemona tipu:","Profesors Ozols",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Professors.jpg", 200, 250),tipi,tipi[0]
	    );

	    if (tips == null) {
	        JOptionPane.showMessageDialog(null, "Tu atteicies izvēlēties pokemonu.");
	        return;
	    }


	    String vards = Pokedatnis.virknesParbaude("Kā nosauksi savu pokemonu?", "Pika");
	    if (vards == null) return;


	    int dziviba = 20 + (int)(Math.random() * 10)+1;
	    int limenis = 1;
	    int uzbrukumDz = 5 + (int)(Math.random() * 4)+1;
	    int aizsardziba = 3 + (int)(Math.random() * 4)+1;

	    Pokemons p = null;


	    if (tips.equals("Elektriskais")) {

	        p = new ElektriskaisP(vards,"Spēlētājs","Zibens",dziviba,limenis,uzbrukumDz,aizsardziba);
	        
	        Pokedatnis.pokemoni.add(p);
		    JOptionPane.showMessageDialog(null,"Tavs jaunais pokemons ir gatavs!\n" + "Vārds: " +
		    p.getVards() +"\nTips: " + tips +"\nDzīvība: " + dziviba + "\nLimenis: " + limenis +"\nUzbrukums: " + uzbrukumDz +
		                    "\nAizsardzība: " + aizsardziba,
		            "Prof. Ozols",
		            JOptionPane.PLAIN_MESSAGE,
		            Pokedatnis.Bildes("Pikachu.png", 200, 200));
	        
	    } else if (tips.equals("Ūdens")) {
	        p = new UdensP(vards,"Spēlētājs","Burbuļi", dziviba,limenis,uzbrukumDz,aizsardziba);
	        		
	        Pokedatnis.pokemoni.add(p);
		    JOptionPane.showMessageDialog(null,"Tavs jaunais pokemons ir gatavs!\n" + "Vārds: " +
		    p.getVards() +"\nTips: " + tips +"\nDzīvība: " + dziviba + "\nLimenis: " + limenis +"\nUzbrukums: " + uzbrukumDz +
		                    "\nAizsardzība: " + aizsardziba,
		            "Prof. Ozols",
		            JOptionPane.PLAIN_MESSAGE,
		            Pokedatnis.Bildes("Squirtle.png", 200, 200));
	    }
	}

	static void ZalaZale() {
	    
	    int rand = (int)(Math.random() * 3) + 1;
	    Pokemons enemy = null;

	    switch (rand) {

	        case 1:
	            JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināta žurka!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Ratata.png", 200, 200));
     
	            enemy = new SavvalasPokemons("Ratata",(int)(Math.random()*12) + 6,
	            		(int)(Math.random()*6) + 1,(int)(Math.random()*8) + 4,(int)(Math.random()*8) + 8);
	            break;

	        case 2:
	            JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināts putns!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Pidgey.png", 200, 200)
	            );

	            enemy = new SavvalasPokemons("Pidgey",(int)(Math.random()*12) + 6,
	            		(int)(Math.random()*6) + 1,(int)(Math.random()*8) + 8,(int)(Math.random()*8) + 4);
	            break;

	        case 3:
	            JOptionPane.showMessageDialog(null, "Tev uzbruka nepieradināts kukainis!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Weedle.png", 200, 200));

	            enemy = new SavvalasPokemons("Weedle",(int)(Math.random()*12) + 6,(int)(Math.random()*6) + 1,
	            		(int)(Math.random()*8) + 6,(int)(Math.random()*8) + 6);
	            break;

	        default:
	            System.out.println("Kā mēs šeit tikām?");
	            break;
	    }

	    Cinisanas(enemy);
	}



		static void Cinisanas(Pokemons enemy) {

	
		    Pokemons player = Pokedatnis.pokemoni.get(0);

		    while (player.getDziviba() > 0 && enemy.getDziviba() > 0) {

		        String info =
		                "=== TAVS POKEMONS ===\n" +
		                "Vārds: " + player.getVards() +
		                "\nDzīvība: " + player.getDziviba() +
		                "\nUzbrukums: " + player.getUzbrukumDz() +
		                "\nAizsardzība: " + player.getAizsardziba() +
		                "\n\n=== PRETINIEKS ===\n" +
		                "Vārds: " + enemy.getVards() +
		                "\nDzīvība: " + enemy.getDziviba() +
		                "\nUzbrukums: " + enemy.getUzbrukumDz() +
		                "\nAizsardzība: " + enemy.getAizsardziba();

		        String[] izveles = {"Uzbrukt", "Bēgt"};
		        String izvele = (String) JOptionPane.showInputDialog( null,info + "\n\nKo tu vēlies darīt?","Cīņa",JOptionPane.PLAIN_MESSAGE,null, izveles,izveles[0]
		        );

		        if (izvele == null || izvele.equals("Bēgt")) {
		            JOptionPane.showMessageDialog(null, "Tu aizbēgi no cīņas!");
		            return;
		        }

		  
		        int spelUzbrukums = Math.max(1, player.getUzbrukumDz() - enemy.getAizsardziba());
		        enemy.setDziviba(enemy.getDziviba() - spelUzbrukums);

		   
		        if (enemy.getDziviba() <= 0) {
		            JOptionPane.showMessageDialog(null,
		                    player.getVards() + " uzvarēja!\n" +
		                    "Tu nodarīji: " + spelUzbrukums + " bojājumus."
		            );
		            return;
		        }

		        
		        int ienaidSap = Math.max(1, enemy.getUzbrukumDz() - player.getAizsardziba());
		        player.setDziviba(player.getDziviba() - ienaidSap);

		    
		        JOptionPane.showMessageDialog(null,
		                "Tu uzbruki pretiniekam un izdarīji " + spelUzbrukums + " bojājumus!\n" +
		                "Pretinieks uzbruka tev un izdarīja " + ienaidSap + " bojājumus!");

		        if (player.getDziviba() <= 0) {
		            JOptionPane.showMessageDialog(null,
		                    "Tavs pokemons tika sakauts!\n" +
		                    "Pretinieks nodarīja: " + ienaidSap + " bojājumus."
		            );
		            return;
		        }
		    }
		}
	}