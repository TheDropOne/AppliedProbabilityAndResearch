package probabilities;

import model.State;

/**
 Created by Semen on 31-May-17 */
public class MartingaleStrategy {

    public static double init_coef = 2.5;

    public MartingaleStrategy() {
    }

    public static double getInit_coef() {
        return init_coef;
    }

    //TODO
    public static float calculateRateAmount(State currentState){
        return 1.0f;
    }
}
