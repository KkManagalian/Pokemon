package baltgalvis_voitkevics;

public class SavvalasPokemons extends Pokemons {

    public SavvalasPokemons(String vards, int dziviba, int limenis, int uzbrukumDz, int aizsardziba) {
        super(vards, "Savvaļas", "Triec", dziviba, limenis, uzbrukumDz, aizsardziba);
    }

    @Override
    public void sanemtSapes(int dmg) {
        int real = Math.max(1, dmg - getAizsardziba());
        setDziviba(getDziviba() - real);
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
