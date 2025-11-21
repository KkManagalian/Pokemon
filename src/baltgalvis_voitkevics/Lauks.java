package baltgalvis_voitkevics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Lauks {
	
	static Trenneris trenneris;
	
	public static void setTrenneris(Trenneris t) { 
		trenneris = t;
	}
	
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


	    String vards = Pokedatnis.virknesParbaude("Kā nosauksi savu pokemonu?", "Jānis");
	    if (vards == null) return;


	    int dziviba = 10 + (int)(Math.random() * 10)+1;
	    int limenis = 1;
	    int uzbrukumDz = 5 + (int)(Math.random() * 4)+1;
	    int aizsardziba = 3 + (int)(Math.random() * 4)+1;

	    Pokemons p = null;

	    try {
			Pokedatnis.Skana("Ieguts.wav");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		}

	    if (tips.equals("Elektriskais")) {

	        p = new ElektriskaisP(vards,"Spēlētājs","Zibens",dziviba,limenis,uzbrukumDz,aizsardziba);
	        
	        try {
				Pokedatnis.Skana("Pikachu.wav");
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
	        
	        Pokedatnis.pokemoni.add(p);
		    JOptionPane.showMessageDialog(null,"Tavs jaunais pokemons ir gatavs!\n" + "Vārds: " +
		    p.getVards() +"\nTips: " + tips +"\nDzīvība: " + dziviba + "\nLimenis: " + limenis +"\nUzbrukums: " + uzbrukumDz +
		                    "\nAizsardzība: " + aizsardziba,
		            "Prof. Ozols",
		            JOptionPane.PLAIN_MESSAGE,
		            Pokedatnis.Bildes("Pikachu.png", 200, 200));
	        
	    } else if (tips.equals("Ūdens")) {
	        p = new UdensP(vards,"Spēlētājs","Burbuļi", dziviba,limenis,uzbrukumDz,aizsardziba);
	        
	        try {
				Pokedatnis.Skana("Squirtle.wav");
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
	        		
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
	    Pokemons pretinieks = null;

	    switch (rand) {

	        case 1:
	        	
	        	 try {
	     			Pokedatnis.Skana("Rattata.wav");
	     		} catch (MalformedURLException e) {
	     			
	     			e.printStackTrace();
	     		} catch (UnsupportedAudioFileException e) {
	     			
	     			e.printStackTrace();
	     		} catch (IOException e) {
	     			
	     			e.printStackTrace();
	     		} catch (LineUnavailableException e) {
	     			
	     			e.printStackTrace();
	     		}
	        	
	            JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināta žurka!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Ratata.png", 200, 200));
     
	            pretinieks = new SavvalasPokemons("Ratata",(int)(Math.random()*12) + 6,
	            		(int)(Math.random()*6) + 1,(int)(Math.random()*8) + 4,(int)(Math.random()*8) + 8);
	            break;

	        case 2:
	        	
	        	 try {
	     			Pokedatnis.Skana("Pidgey.wav");
	     		} catch (MalformedURLException e) {
	     			
	     			e.printStackTrace();
	     		} catch (UnsupportedAudioFileException e) {
	     			
	     			e.printStackTrace();
	     		} catch (IOException e) {
	     			
	     			e.printStackTrace();
	     		} catch (LineUnavailableException e) {
	     			
	     			e.printStackTrace();
	     		}
	        	
	            JOptionPane.showMessageDialog(null,"Tev uzbruka nepieradināts putns!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Pidgey.png", 200, 200)
	            );

	            pretinieks = new SavvalasPokemons("Pidgey",(int)(Math.random()*12) + 6,
	            		(int)(Math.random()*6) + 1,(int)(Math.random()*8) + 8,(int)(Math.random()*8) + 4);
	            break;

	        case 3:
	        	
	        	 try {
	     			Pokedatnis.Skana("Weedle.wav");
	     		} catch (MalformedURLException e) {
	     			
	     			e.printStackTrace();
	     		} catch (UnsupportedAudioFileException e) {
	     			
	     			e.printStackTrace();
	     		} catch (IOException e) {
	     			
	     			e.printStackTrace();
	     		} catch (LineUnavailableException e) {
	     			
	     			e.printStackTrace();
	     		}
	        	
	            JOptionPane.showMessageDialog(null, "Tev uzbruka nepieradināts kukainis!","Uzbrukums!",JOptionPane.PLAIN_MESSAGE,Pokedatnis.Bildes("Weedle.png", 200, 200));

	            pretinieks = new SavvalasPokemons("Weedle",(int)(Math.random()*12) + 6,(int)(Math.random()*6) + 1,
	            		(int)(Math.random()*8) + 6,(int)(Math.random()*8) + 6);
	            break;

	        default:
	            System.out.println("Kā mēs šeit tikām?");
	            break;
	    }

	    Cinisanas(pretinieks);
	}


	static void Cinisanas(Pokemons pretinieks) {

	    Pokemons speletajs = Pokedatnis.pokemoni.get(0);
	    Random rand = new Random();

	    int maxHP = speletajs.getDziviba();

	    while (speletajs.getDziviba() > 0 && pretinieks.getDziviba() > 0) {
	        
	        try {
	            Pokedatnis.Skana("Cina.wav");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        String info =
	                "=== TAVS POKEMONS ===\n" +
	                "Vārds: " + speletajs.getVards() +
	                "\nDzīvība: " + speletajs.getDziviba() + "/" + maxHP +
	                "\nUzbrukums: " + speletajs.getUzbrukumDz() +
	                "\nAizsardzība: " + speletajs.getAizsardziba() +
	                "\n\n=== PRETINIEKS ===\n" +
	                "Vārds: " + pretinieks.getVards() +
	                "\nDzīvība: " + pretinieks.getDziviba() +
	                "\nUzbrukums: " + pretinieks.getUzbrukumDz() +
	                "\nAizsardzība: " + pretinieks.getAizsardziba() +
	                (pretinieks.irParalizets() ? "\n⚡ PARALIZĒTS! ⚡" : "");

	        String[] izveles = {"Uzbrukt", "Dziedēt", "Izvairīties", "Bēgt"};
	        String izvele = (String) JOptionPane.showInputDialog(null, info + "\n\nKo tu vēlies darīt?","Cīņa",JOptionPane.PLAIN_MESSAGE,null,izveles,izveles[0]);

	        if (izvele == null || izvele.equals("Bēgt")) {
	            JOptionPane.showMessageDialog(null, "Tu aizbēgi no cīņas!");
	            return;
	        }

	        
	        
	        
	        
	        if (izvele.equals("Uzbrukt")) {
	            int sakumUzbrukums = speletajs.getUzbrukumDz();
	            int min = (int)(sakumUzbrukums * 0.5);
	            int max = sakumUzbrukums; 
	            int uzbrukums = rand.nextInt(max - min + 1) + min;

	            boolean kritisks = rand.nextInt(100) < 10;
	            if (kritisks) {
	                uzbrukums *= 2;
	                JOptionPane.showMessageDialog(null, "KRITISKS TRĀPIJUMS!");
	            }

	            boolean garam = rand.nextInt(100) < 7;
	            if (garam) {
	                uzbrukums = 0;
	                JOptionPane.showMessageDialog(null, "Tu aizšāvi garām!");
	            }

	            pretinieks.sanemtSapes(uzbrukums);

	            if (pretinieks.getDziviba() <= 0) {
	                JOptionPane.showMessageDialog(null, pretinieks.getVards() + " tika sakauts!");
	                return;
	            }
	        }

	        if (izvele.equals("Dziedēt")) {
	            int dziedet = 3 + rand.nextInt(8); 
	            speletajs.setDziviba(Math.min(maxHP, speletajs.getDziviba() + dziedet));
	            JOptionPane.showMessageDialog(null, "Tu atguvi " + dziedet + " dzīvības punktus!");
	        }

	        if (izvele.equals("Izvairīties")) {
	            boolean veiksmigi = rand.nextInt(100) < 20; 
	            if (veiksmigi) {
	                JOptionPane.showMessageDialog(null, "Tu veiksmīgi izvairījies no uzbrukuma!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Neizdevās izvairīties...");
	            }
	        }

	        if (pretinieks.irParalizets()) {
	            pretinieks.setParalizets(false); 
	        } else {
	            if (!izvele.equals("Izvairīties") || rand.nextInt(100) >= 20) {
	                int pretUzbruk = pretinieks.getUzbrukumDz();
	                pretUzbruk = (int)(pretUzbruk * (0.7 + rand.nextDouble() * 0.6));

	                boolean pretKrit = rand.nextInt(100) < 10;
	                if (pretKrit) {
	                    pretUzbruk *= 2;
	                    JOptionPane.showMessageDialog(null, "Pretinieks izdarīja kritisku triecienu!");
	                }

	                boolean pretIzvairit = rand.nextInt(100) < 7;
	                if (pretIzvairit) {
	                    pretUzbruk = 0;
	                    JOptionPane.showMessageDialog(null, "Pretinieks aizšāva garām!");
	                }

	                speletajs.sanemtSapes(pretUzbruk);
	            }
	        }

	        if (speletajs.getDziviba() <= 0) {
	            JOptionPane.showMessageDialog(null, "Tavs pokemons tika sakauts!");
	            Pokedatnis.pokemoni.remove(speletajs);
	            return;
	        }
	    }
	}
}