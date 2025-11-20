package pokemons;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pokedatnis {
	
public static ArrayList<Pokemons> pokemoni = new ArrayList<>();
	
	public static Icon Bildes(String fails, int Izm1, int Izm2) {
	ImageIcon bilde = new ImageIcon(new ImageIcon("Bildes"+File.separator+fails).getImage().
				getScaledInstance(Izm1, Izm2, Image.SCALE_SMOOTH));
	return bilde;
	}
	
	public static void Skana(String skana) throws MalformedURLException, UnsupportedAudioFileException, IOException,LineUnavailableException{
			File f = new File ("Audijo"+File.separator+skana);
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip c = AudioSystem.getClip();
			c.open(ais);
			c.start();
		}
	
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		return virkne;
	}
	
	public static void main(String[] args) {
		
		String izvele="";
		String[] gulta= {"Pamodies","Turpini gulēt"};
		Trenneris trenners = null;
		
		do {
			
			try {
				Skana("Skana.wav");
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
			
			izvele = (String)JOptionPane.showInputDialog(null, "Aija žužu", "Gulta", JOptionPane.INFORMATION_MESSAGE, Bildes("Gulet.png", 200, 170), gulta, gulta[0]);
			if(izvele == null) {
				izvele="Turpini gulēt";
			}
			switch(izvele) {
			case "Pamodies":
				do {
					
					try {
						Skana("Majas.wav");
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						
						e.printStackTrace();
					}
					
				String[] Maja= {"Apskati sevi spogulī", "Apskaties datoru", "Runāt ar mammu", "Pokemoni", "Pamest māju"};
				izvele = (String)JOptionPane.showInputDialog(null, "Ko darīsi", "Istaba", JOptionPane.PLAIN_MESSAGE, Bildes("Istaba.jpg", 200, 170), Maja, Maja[0]);
				
				if(izvele==null) {
					izvele="Akuu";
				}
				switch(izvele) {
				
				case"Apskati sevi spogulī":
					String[] Dzimte= {"Puisis","Meitene"};
					String vards="VietuŅēmējs", dzimte="";
					dzimte = (String)JOptionPane.showInputDialog(null, "Vai es biju puisis vai meitene?", "Spogulis", JOptionPane.PLAIN_MESSAGE, Bildes("Dzimte.jpg", 235, 275), Dzimte, Dzimte[0]);
					if(dzimte==null) {
						break;
					}
					
					do {
					vards = (String)JOptionPane.showInputDialog(null, "Kāds bija mans vārds?", "Spogulis", JOptionPane.QUESTION_MESSAGE, null, null, "Pelni");
					if(vards == null) {
						break;
					}
					else if(vards.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Tev neeksistē vārds?!"+
								"\nMūsu māte taču mūs mīl...","Spogulis",JOptionPane.ERROR_MESSAGE);
					}
					else if(vards.length()>12) {
						JOptionPane.showMessageDialog(null, "Vārds ir pārāk garš!"+
															"\nMūsu māte taču mūs mīl...","Spogulis",JOptionPane.ERROR_MESSAGE);
					}
					}while(vards == null || vards.trim().equals("") || vards.length()>12);
					
					trenners = new Trenneris(vards, dzimte, 0, 0,0,0);
					break;
				
				case"Apskaties datoru":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					if(trenners.getDzimums()=="Puisis") {
					JOptionPane.showMessageDialog(null, trenners.Info(), "apskats", JOptionPane.PLAIN_MESSAGE, Bildes("Puika.png", 250, 250));
					}else {
					JOptionPane.showMessageDialog(null, trenners.Info(), "apskats", JOptionPane.PLAIN_MESSAGE, Bildes("Meitene.png", 250, 250));
					}
					
					break;
				case"Runāt ar mammu":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					try {
						Skana("Mamma.wav");
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Aij bērniņ, tev šodien paliek 10 gadi!"
							+ "\nSkrien nu pie profesora un dabūni savu pirmo pokemonu!","Mutere",JOptionPane.PLAIN_MESSAGE, Bildes("Mamma.png", 150, 150));
					break;
					
				case "Pokemoni":
					if (pokemoni.isEmpty()) {
				        JOptionPane.showMessageDialog(null,"Tev taču nav neviena pokemona!","Pokemoni",JOptionPane.WARNING_MESSAGE);
				        break;
				    }
					
					 String[] pokemonuVardi = new String[pokemoni.size()];
					    for (int i = 0; i < pokemoni.size(); i++) {
					        pokemonuVardi[i] = pokemoni.get(i).getVards();
					    }

					    // Ļauj izvēlēties pokemonu
					    String izveletsVards = (String) JOptionPane.showInputDialog( null,"Izvēlies savu pokemonu:","Pokemoni",JOptionPane.PLAIN_MESSAGE,null,
					            pokemonuVardi,
					            pokemonuVardi[0]
					    );

					    if (izveletsVards == null) {
					        break; 
					    }
					    // Atrodam izvēlēto pokemonu
					    Pokemons sobridejais = null;
					    for (Pokemons p : pokemoni) {
					        if (p.getVards().equals(izveletsVards)) {
					        	sobridejais = p;
					            break;
					        }
					    }

					    if (sobridejais == null) {
					        JOptionPane.showMessageDialog(null, "Pokemons nav atrasts.");
					        break;
					    }

					    // Papildus darbības ar pokemonu
					    String[] darbibas = {"Apskatīt info", "Trenēt", "Pasaki vārdu", "Atcelt"};
					    String darbiba = (String) JOptionPane.showInputDialog(null, "Ko vēlies darīt ar " + sobridejais.getVards() + "?","Pokemoni",JOptionPane.PLAIN_MESSAGE,null,darbibas,darbibas[0]
					    );

					    if (darbiba == null || darbiba.equals("Atcelt")) break;

					    switch (darbiba) {
					        case "Apskatīt info":
					            JOptionPane.showMessageDialog(null,
					                "Vārds: " + sobridejais.getVards() +
					                "\nTips: " + sobridejais.getClass().getSimpleName() +
					                "\nDzīvība: " + sobridejais.getDziviba() +
					                "\nLīmenis: " + sobridejais.getLimenis() +
					                "\nUzbrukums: " + sobridejais.getUzbrukumDz() +
					                "\nAizsardzība: " + sobridejais.getAizsardziba(),
					                "Pokemona informācija",
					                JOptionPane.PLAIN_MESSAGE
					            );
					            break;

					        case "Trenēt":
					        	sobridejais.trenins();
					            break;

					        case "Pasaki vārdu":
					        	sobridejais.sakiVardu();
					            break;
					    }
					    break;
					    
				case"Pamest māju":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}

					try {
						Skana("Map-music.wav");
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						
						e.printStackTrace();
					}
					
					Lauks.CelsUzOzolu();
					

					break;
					
				case"Akuu":
					JOptionPane.showMessageDialog(null, "Tu aizgāji atpakaļ gulēt");
				}
				}while(izvele!="Akuu");
				
			case "Turpini gulēt":
				try {
					Skana("Sapnis.wav");
				} catch (MalformedURLException e) {
					
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Tu iemigi uz visu mūžu", "Labs sapnis", JOptionPane.PLAIN_MESSAGE, Bildes("Gulet.jpg",250,250));
				System. exit(0);
				break;
			}
		}while(izvele!="Turpini gulēt");
	
	}
}
