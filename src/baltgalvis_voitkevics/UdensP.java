package baltgalvis_voitkevics;

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
        int sapes = (int)(stiprums * 0.5 + (stiprums * 0.5 * (1 - getAizsardziba() / 100.0)));
        sapes = Math.max(sapes, 1); 
        setDziviba(getDziviba() - sapes);
        JOptionPane.showMessageDialog(null,getVards() + " saņēma " + sapes + " bojājumus!\nDzīvība tagad: " + getDziviba());
    }
    @Override
    public void uzbrukt(Pokemons pretinieks) {
        int stiprums = getUzbrukumDz();
        pretinieks.sanemtSapes(stiprums);

        // 20% iespēja pielietot viļņu uzbrukumu
        if (rand.nextInt(100) < 20) {
            JOptionPane.showMessageDialog(null, 
                    getVards() + " uzmeta ūdens vilni! Aizsardzība pretiniekam samazinās!");
            pretinieks.setAizsardziba(Math.max(0, pretinieks.getAizsardziba() - 5));
        }
    }
}

