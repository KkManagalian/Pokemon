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

	    // Pokemona vārds
	    String vards = Pokedatnis.virknesParbaude("Kā nosauksi savu pokemonu?", "Pika");
	    if (vards == null) return;

	    // Statistika
	    int dziviba = 20 + (int)(Math.random() * 10)+1;
	    int limenis = 1;
	    int uzbrukumDz = 5 + (int)(Math.random() * 4)+1;
	    int aizsardziba = 3 + (int)(Math.random() * 4)+1;

	    Pokemons p = null;

	    // Izveido izvēlētā tipa pokemonu
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
		
		int Pokebrucejs = (int)(Math.random()*3)+1;
		
		switch(Pokebrucejs) {
		
		case 1:
			 JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināta žurka!"+"\nVārds:Ratata"+"\nLīmenis:"+((int)(Math.random()*6)+1), "Uzbrukums!", JOptionPane.PLAIN_MESSAGE, Pokedatnis.Bildes("Ratata.png", 200, 200));
			 Cinisanas("Ratata", (int)(Math.random()*12)+6,(int)(Math.random()*8)+4,(int)(Math.random()*8)+8);
			break;
		case 2:
			 JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināts putns!"+"\nVārds:Pidžijs"+"\nLīmenis:"+((int)(Math.random()*6)+1), "Uzbrukums!", JOptionPane.PLAIN_MESSAGE, Pokedatnis.Bildes("Pidgey.png", 200, 200));
			 Cinisanas("Pidžijs", (int)(Math.random()*12)+6,(int)(Math.random()*8)+8,(int)(Math.random()*8)+4);
			break;
		case 3:
			 JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināta kukainis!"+"\nVārds:Vīdls"+"\nLīmenis:"+((int)(Math.random()*6)+1), "Uzbrukums!", JOptionPane.PLAIN_MESSAGE, Pokedatnis.Bildes("Weedle.png", 200, 200));
			 Cinisanas("Vīdls", (int)(Math.random()*12)+6,(int)(Math.random()*8)+6,(int)(Math.random()*8)+6);
			break;
		}
		
	}
	
	static void Cinisanas(String pokemons, int Hp, int Atk, int Def){
		
	}
	
}