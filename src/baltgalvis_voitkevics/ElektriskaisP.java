package baltgalvis_voitkevics;

import javax.swing.JOptionPane;
import java.util.Random;

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
        int dzivibaPazemina = stiprums;
        setDziviba(getDziviba() - dzivibaPazemina);
        JOptionPane.showMessageDialog(null,
                getVards() + " saņēma " + dzivibaPazemina + " sāpju!\nDzīvība tagad: " + getDziviba());
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