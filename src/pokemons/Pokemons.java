package pokemons;

public class Pokemons {

	private String vards;
	private String trenneris;
	private String uzbrukums;
	private int dziviba;
	private int limenis;
	private int uzbrukumDz;
	private int aizsardziba;
	
	Pokemons(String Vards, String Trenneris, String Uzbrukums, int Dziviba, int Limenis, int UzbrukumDz, int Aizsardziba){
		this.vards=(Vards);
		this.trenneris=(Trenneris);
		this.uzbrukums=(Uzbrukums);
		this.dziviba=(Dziviba);
		this.limenis=(Limenis);
		this.uzbrukumDz=(UzbrukumDz);
		this.aizsardziba=(Aizsardziba);
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

}
