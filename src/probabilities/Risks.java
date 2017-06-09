package probabilities;

/**
 * Created by Semen on 09-Jun-17.
 */
public class Risks {

    private static volatile float MARTINGALE_COEF;

    public Risks() {

        MARTINGALE_COEF = (float) MartingaleStrategy.getInit_coef();

    }
}
