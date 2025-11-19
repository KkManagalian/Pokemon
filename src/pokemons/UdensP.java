package pokemons;

<<<<<<< HEAD
import javax.swing.JOptionPane;
import java.util.Random;

public class UdensP extends Pokemons {

    private Random rand = new Random();

    public UdensP(String vards, String trenneris, String uzbrukums, int dziviba, int limenis, int uzbrukumDz, int aizsardziba) {
        super(vards, trenneris, uzbrukums, dziviba, limenis, uzbrukumDz, aizsardziba);
    }

    @Override
    public void sakiVardu() {
        JOptionPane.showMessageDialog(null, "Es esmu " + getVards() + "!");
    }

    @Override
    public void trenins() {
        setDziviba(getDziviba() + rand.nextInt(4) + 2);
        setUzbrukumDz(getUzbrukumDz() + rand.nextInt(4) + 2);
        setAizsardziba(getAizsardziba() + rand.nextInt(4) + 1);
        setLimenis(getLimenis() + 1);

        JOptionPane.showMessageDialog(null,
                getVards() + " trenējās!\nDzīvība: " + getDziviba() +
                "\nUzbrukums: " + getUzbrukumDz() +
                "\nAizsardzība: " + getAizsardziba() +
                "\nLīmenis: " + getLimenis());
    }

    @Override
    public void sanemtSapes(int stiprums) {
        int dmg = Math.max(stiprums - getAizsardziba(), 0);
        setDziviba(getDziviba() - dmg);
        JOptionPane.showMessageDialog(null,
                getVards() + " saņēma " + dmg + " sāpju!\nDzīvība tagad: " + getDziviba());
    }

    @Override
    public void uzbrukt(Pokemons mercis) {
        int stiprums = getUzbrukumDz();
        mercis.sanemtSapes(stiprums);

        // 20% iespēja pielietot viļņu uzbrukumu
        if (rand.nextInt(100) < 20) {
            JOptionPane.showMessageDialog(null, 
                    getVards() + " uzmeta ūdens vilni! Aizsardzība pretiniekam samazinās!");
            mercis.setAizsardziba(Math.max(0, mercis.getAizsardziba() - 1));
        }
    }
=======
public class UdensP extends Pokemons{

	UdensP(String Vards, String Trenneris, String Uzbrukums, int Dziviba, int Limenis, int UzbrukumDz,
			int Aizsardziba) {
		super(Vards, Trenneris, Uzbrukums, Dziviba, Limenis, UzbrukumDz, Aizsardziba);
		
	}

>>>>>>> 3499c3e911411ddf6f8d3a1f34ea3462200ec93c
}
