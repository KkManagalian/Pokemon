package pokemons;

import javax.swing.JOptionPane;

public class Pokedatnis {

	bilde = new ImageIcon(new ImageIcon("Atteli"+File.separator+cels).getImage().
			getScaledInstance(120, 120, Image.SCALE_SMOOTH))
	
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
				String[] Maja= {"Apskaties datoru","Runāt ar mammu","Pamest māju"};
				izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, Maja, Maja[0]);
				switch(izvele) {
				case"Apskaties datoru":
					
					break;
				case"Runāt ar mammu":
					JOptionPane.showMessageDialog(null, "Aij bērniņ, tev šodien paliek 10 gadi!"
							+ "Skrien nu pie profesora un dabūni savu pirmo pokemonu!",JOptionPane.PLAIN_MESSAGE, bilde);
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
