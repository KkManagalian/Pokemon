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
		this.setVards(Vards);
		this.setTrenneris(Trenneris);
		this.setUzbrukums(Uzbrukums);
		this.setDziviba(Dziviba);
		this.setLimenis(Limenis);
		this.setUzbrukumDz(UzbrukumDz);
		this.setAizsardziba(Aizsardziba);
	}
	
	

	public String getTrenneris() {
		return trenneris;
	}

	public void setTrenneris(String trenneris) {
		this.trenneris = trenneris;
	}



	public String getVards() {
		return vards;
	}

	public void setVards(String vards) {
		this.vards = vards;
	}



	public int getDziviba() {
		return dziviba;
	}



	public void setDziviba(int dziviba) {
		this.dziviba = dziviba;
	}



	public String getUzbrukums() {
		return uzbrukums;
	}



	public void setUzbrukums(String uzbrukums) {
		this.uzbrukums = uzbrukums;
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
