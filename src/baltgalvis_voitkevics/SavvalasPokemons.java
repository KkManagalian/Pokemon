package baltgalvis_voitkevics;

import javax.swing.JOptionPane;

public class SavvalasPokemons extends Pokemons {

    public SavvalasPokemons(String vards, int dziviba, int limenis, int uzbrukumDz, int aizsardziba) {
        super(vards, "Savvaļas", "Triec", dziviba, limenis, uzbrukumDz, aizsardziba);
    }
    
    @Override
    public void sanemtSapes(int stiprums) {
        int sapes = (int)(stiprums * 0.5 + (stiprums * 0.5 * (1 - getAizsardziba() / 100.0)));
        sapes = Math.max(sapes, 1); 
        setDziviba(getDziviba() - sapes);
        	JOptionPane.showMessageDialog(null, 
                getVards() + " saņēma " + sapes + " bojājumus!\nDzīvība tagad: " + getDziviba());
        }
    @Override
    public void uzbrukt(Pokemons pretinieks) {
        pretinieks.sanemtSapes(getUzbrukumDz());
    }


	@Override
	public void sakiVardu() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void trenins() {
		// TODO Auto-generated method stub
		
	}
}
