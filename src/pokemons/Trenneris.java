package pokemons;

public class Trenneris {

	private String vards;
	private String dzimums;
	private int pokeNauda;
	private int pokemoni;
	private int pokemoniRedzeti;
	private int uzvaras;
	
	Trenneris(String Vards, String Dzimums,int PokeNauda, int Pokemoni,int PokemoniRedzeti, int Uzvaras){
	this.vards=(Vards);
	this.dzimums=(Dzimums);
	this.setPokeNauda(PokeNauda);
	this.setPokemoni(Pokemoni);
	this.setPokemoniRedzeti(PokemoniRedzeti);
	this.setUzvaras(Uzvaras);
	}

	public String getVards() {
		return vards;
	}

	public String getDzimums() {
		return dzimums;
	}

	public int getPokeNauda() {
		return pokeNauda;
	}

	public void setPokeNauda(int pokeNauda) {
		this.pokeNauda = pokeNauda;
	}
	
	public int getPokemoni() {
		return pokemoni;
	}

	public void setPokemoni(int pokemoni) {
		this.pokemoni = pokemoni;
	}

	public int getPokemoniRedzeti() {
		return pokemoniRedzeti;
	}

	public void setPokemoniRedzeti(int pokemoniRedzeti) {
		this.pokemoniRedzeti = pokemoniRedzeti;
	}
	
	public int getUzvaras() {
		return uzvaras;
	}

	public void setUzvaras(int uzvaras) {
		this.uzvaras = uzvaras;
	}
	
	public String Info() {
		return "Trennera vārds: "+getVards()+
				"\nTrennera dzimums: "+getDzimums()+
				"\nPokeNaudas daudzums: $"+getPokeNauda()+
				"\nPokemoni noķerti: "+getPokemoni()+
				"\nPokemoni redzēti: "+getPokemoniRedzeti()+
				"\nUzvaras: "+getUzvaras();
	}
	
}
