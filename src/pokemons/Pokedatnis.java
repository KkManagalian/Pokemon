package pokemons;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
			izvele = (String)JOptionPane.showInputDialog(null, "Aija žužu", "Gulta", JOptionPane.INFORMATION_MESSAGE, null, gulta, gulta[0]);
			if(izvele == null) {
				izvele="Turpini gulēt";
			}
			switch(izvele) {
			case "Pamodies":
				do {
				String[] Maja= {"Apskati sevi spogulī", "Apskaties datoru", "Runāt ar mammu", "Pamest māju"};
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
					vards = (String)JOptionPane.showInputDialog(null, "Kāds bija mans vārds?");
					if(vards==null) {
						break;
					}
					if(vards.length()>12) {
						JOptionPane.showMessageDialog(null, "Vārds ir pārāk garš!"+
															"\nMūsu māte taču mūs mīl..","Spogulis",JOptionPane.ERROR_MESSAGE);
					}
					}while(vards.length()>12);
					trenners = new Trenneris(vards, dzimte, 0, 0,0,0);
					break;
				
				case"Apskaties datoru":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}
					if(trenners.getDzimums()=="Puisis") {
					JOptionPane.showMessageDialog(null, trenners.Info(), "apskats", JOptionPane.PLAIN_MESSAGE, Bildes("Puisis.png", 250, 250));
					}else {
					JOptionPane.showMessageDialog(null, trenners.Info(), "apskats", JOptionPane.PLAIN_MESSAGE, Bildes("Meitene.png", 250, 250));
					}
					break;
				case"Runāt ar mammu":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}
					JOptionPane.showMessageDialog(null, "Aij bērniņ, tev šodien paliek 10 gadi!"
							+ "\nSkrien nu pie profesora un dabūni savu pirmo pokemonu!","Mutere",JOptionPane.PLAIN_MESSAGE, Bildes("Mamma.png", 150, 150));
					break;
				case"Pamest māju":
					if(trenners==null) {
						JOptionPane.showMessageDialog(null, "Es vēl nēesmu sakārtojis savu izskatu!", "Ak jē!", JOptionPane.WARNING_MESSAGE);
						break;
					}
	
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
