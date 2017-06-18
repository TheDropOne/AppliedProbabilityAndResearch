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

    /**
     * This method used to calculate optional coef on current state
     * @param currentState state of system at the moment of call
     * @return optional coef for betting, -1.0f on error
     */
    public static float calculateRateAmount(State currentState){
        return 1.0f;
    }
}
