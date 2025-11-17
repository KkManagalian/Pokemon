package pokemons;

import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pokedatnis {
	
	public static Icon Bildes(String fails, int Izm1, int Izm2) {
	ImageIcon bilde = new ImageIcon(new ImageIcon("Bildes"+File.separator+fails).getImage().
				getScaledInstance(Izm1, Izm2, Image.SCALE_SMOOTH));
	return bilde;
	}
	
	public static void main(String[] args) {
		
		String izvele="";
		String[] gulta= {"Pamodies","Turpini gulēt"};
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Aija žužu", "Gulta", JOptionPane.QUESTION_MESSAGE, null, gulta, gulta[0]);
			if(izvele == null) {
				izvele="Turpini gulēt";
			}
			switch(izvele) {
			case "Pamodies":
				do {
				String[] Maja= {"Apskati sevi spogulī", "Apskaties datoru", "Runāt ar mammu", "Pamest māju"};
				izvele = (String)JOptionPane.showInputDialog(null, "Ko darīsi", "Istaba", JOptionPane.PLAIN_MESSAGE, Bildes("Istaba.jpg", 200, 170), Maja, Maja[0]);
				boolean pamet=false;
				String dzimte="";
				
				if(izvele==null) {
					izvele="Akuu";
				}
				switch(izvele) {
				
				case"Apskati sevi spogulī":
					String[] Dzimte= {"Puisis","Meitene"};
					dzimte = (String)JOptionPane.showInputDialog(null, "Vai es biju puisis vai meitene?", "Spogulis", JOptionPane.PLAIN_MESSAGE, Bildes("Dzimte.jpg", 200, 200), Dzimte, Dzimte[0]);
					break;
				
				case"Apskaties datoru":
					System.out.println(dzimte);
					break;
				case"Runāt ar mammu":
					JOptionPane.showMessageDialog(null, "Aij bērniņ, tev šodien paliek 10 gadi!"
							+ "\nSkrien nu pie profesora un dabūni savu pirmo pokemonu!","Mutere",JOptionPane.PLAIN_MESSAGE, Bildes("Mamma.png", 150, 150));
					break;
				case"Pamest māju":
	
					break;
					
				case"Akuu":
					JOptionPane.showMessageDialog(null, "Tu aizgāji atpakaļ gulēt");
				}
				}while(izvele!="Akuu");
				
			case "Turpini gulēt":
				JOptionPane.showMessageDialog(null, "Tu iemigi uz visu mūžu", "Labs sapnis", JOptionPane.PLAIN_MESSAGE, Bildes("Gulet.png",150,150));
				System. exit(0);
				break;
			}
		}while(izvele!="Turpini gulēt");

	}
	
}
