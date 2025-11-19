package pokemons;

<<<<<<< HEAD
public abstract class Pokemons {
=======
public class Pokemons {
>>>>>>> 3499c3e911411ddf6f8d3a1f34ea3462200ec93c

	private String vards;
	private String trenneris;
	private String uzbrukums;
	private int dziviba;
	private int limenis;
	private int uzbrukumDz;
	private int aizsardziba;
	
<<<<<<< HEAD
	public Pokemons(String Vards, String Trenneris, String Uzbrukums, int Dziviba, int Limenis, int UzbrukumDz, int Aizsardziba){
=======
	Pokemons(String Vards, String Trenneris, String Uzbrukums, int Dziviba, int Limenis, int UzbrukumDz, int Aizsardziba){
>>>>>>> 3499c3e911411ddf6f8d3a1f34ea3462200ec93c
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


<<<<<<< HEAD
	public void setDziviba(int dziviba) {
		this.dziviba = dziviba;
	}
=======
>>>>>>> 3499c3e911411ddf6f8d3a1f34ea3462200ec93c

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
<<<<<<< HEAD
	
	public abstract void sakiVardu();
	
	public abstract void trenins();
	
	public abstract void sanemtSapes(int stiprums);
	public abstract void uzbrukt(Pokemons pretinieks);
=======
>>>>>>> 3499c3e911411ddf6f8d3a1f34ea3462200ec93c

}
