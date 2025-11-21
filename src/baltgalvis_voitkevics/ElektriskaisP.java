package baltgalvis_voitkevics;

import java.util.Random;

import javax.swing.JOptionPane;

public class ElektriskaisP extends Pokemons {

    private Random rand = new Random();

    public ElektriskaisP(String vards, String trenneris, String uzbrukums, int dziviba, int limenis, int uzbrukumDz, int aizsardziba) {
        super(vards, trenneris, uzbrukums, dziviba, limenis, uzbrukumDz, aizsardziba);
    }

    @Override
    public void sakiVardu() {
        JOptionPane.showMessageDialog(null, "Es esmu " + getVards() + "!");
    }

    @Override
    public void trenins() {
        setDziviba(getDziviba() + rand.nextInt(6));
        setUzbrukumDz(getUzbrukumDz() + rand.nextInt(6));
        setAizsardziba(getAizsardziba() + rand.nextInt(6));
        setLimenis(getLimenis() + 1);

        JOptionPane.showMessageDialog(null,
                getVards() + " trenējās!\nDzīvība: " + getDziviba() +
                        "\nUzbrukums: " + getUzbrukumDz() +
                        "\nAizsardzība: " + getAizsardziba() +
                        "\nLīmenis: " + getLimenis());
    }

    @Override
    public void sanemtSapes(int stiprums) {
    
        int sapes = (int)(stiprums * 0.5 + (stiprums * 0.5 * (1 - getAizsardziba() / 100.0)));
        sapes = Math.max(sapes, 1); 
        setDziviba(getDziviba() - sapes);
        JOptionPane.showMessageDialog(null,getVards() + " saņēma " + sapes + " bojājumus!\nDzīvība tagad: " + getDziviba());
    }

    @Override
    public void uzbrukt(Pokemons pretinieks) {
        int stiprums = getUzbrukumDz();
        pretinieks.sanemtSapes(stiprums);

        // 30% iespēja paralizēt pretinieku
        if (rand.nextInt(100) < 30) {
        	pretinieks.setParalizets(true);
            JOptionPane.showMessageDialog(null, pretinieks.getVards() + " ir paralizēts! \nNākamajā kārtā nevarēs kustēties!");
        }
    }
}