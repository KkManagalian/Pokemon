package baltgalvis_voitkevics;

public abstract class Pokemons {

	private String vards;
	private String trenneris;
	private String uzbrukums;
	private int dziviba;
	private int limenis;
	private int uzbrukumDz;
	private int aizsardziba;
	private boolean irParalizets;
	
	public Pokemons(String Vards, String Trenneris, String Uzbrukums, int Dziviba, int Limenis, int UzbrukumDz, int Aizsardziba){
		this.vards=(Vards);
		this.trenneris=(Trenneris);
		this.uzbrukums=(Uzbrukums);
		this.dziviba=(Dziviba);
		this.limenis=(Limenis);
		this.uzbrukumDz=(UzbrukumDz);
		this.aizsardziba=(Aizsardziba);
		this.irParalizets = false;
	}
	
	public String getTrenneris() {
		return trenneris;
	}

	public String getVards() {
		return vards;
	}

	public int getDziviba() {
		return dziviba;
	}

	public String getUzbrukums() {
		return uzbrukums;
	}

	public int getUzbrukumDz() {
		return uzbrukumDz;
	}

	public void setUzbrukumDz(int uzbrukumDz) {
		this.uzbrukumDz = uzbrukumDz;
	}

	public void setDziviba(int dziviba) {
		this.dziviba = dziviba;
	}

	public int getLimenis() {
		return limenis;
	}

	public void setLimenis(int limenis) {
		this.limenis = limenis;
	}

	public int getAizsardziba() {
		return aizsardziba;
	}

	public void setAizsardziba(int aizsardziba) {
		this.aizsardziba = aizsardziba;
	}
	
	public boolean irParalizets() {
		return irParalizets;
	}

	public void setParalizets(boolean paralizets) {
		this.irParalizets = paralizets;
	}
	
	public abstract void sakiVardu();
	public abstract void trenins();
	public abstract void sanemtSapes(int stiprums);
	public abstract void uzbrukt(Pokemons pretinieks);

	}
