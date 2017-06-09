package probabilities;

/**
 * Created by Semen on 09-Jun-17.
 */
public class MartingaleStrategy {

    public static double init_coef = 2.5;

    public MartingaleStrategy() {
    }

    public static double getInit_coef() {
        return init_coef;
    }

    public static void setInit_coef(double init_coef) {
        MartingaleStrategy.init_coef = init_coef;
    }
}
