package pokemons;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pokedatnis {
	
	public static void main(String[] args) {
		
		boolean pamet=false;
		String izvele="";
		String[] gulta= {"Pamodies","Turpini gulēt"};
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, gulta, gulta[0]);
			if(izvele == null) {
				izvele="Turpini gulēt";
			}
			switch(izvele) {
			case "Pamodies":
				String[] Maja= {"Apskati sevi spoguli", "Apskaties datoru", "Runāt ar mammu", "Pamest māju"};
				izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, Maja, Maja[0]);
				switch(izvele) {
				case"Apskaties datoru":
					
					break;
				case"Runāt ar mammu":
					JOptionPane.showMessageDialog(null, "Aij bērniņ, tev šodien paliek 10 gadi!"
							+ "Skrien nu pie profesora un dabūni savu pirmo pokemonu!","Mutere",JOptionPane.PLAIN_MESSAGE, new ImageIcon(new ImageIcon("Atteli"+File.separator+"Mamma.png").getImage().
									getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
					break;
				case"Pamest māju":
	
					break;
				}
				break;
			case "Turpini gulēt":
				JOptionPane.showMessageDialog(null, "Tu iemigi uz visu mūžu", "Labs sapnis", JOptionPane.INFORMATION_MESSAGE);
				pamet=true;
				break;
			}
		}while(pamet!=true);

	}
	
}
