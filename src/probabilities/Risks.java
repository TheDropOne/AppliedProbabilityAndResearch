package probabilities;

import model.State;

/**
 Created by Semen on 28-May-17 */
public class Risks {

    private static volatile float MARTINGALE_COEF;
    private static volatile double BASIC_SPEED = 3.0;

    private static volatile int COUNT_SUCCESSFULL_STEPS = 5;

    public Risks() {

        MARTINGALE_COEF = (float) MartingaleStrategy.getInit_coef();

    }

    public static boolean isItGoodToStart(State currentState) {
        boolean isHistoryFilled = true;
        State prevState = currentState.getPreviousState();
        for (int i = 0; i < COUNT_SUCCESSFULL_STEPS; i++) {
            if (prevState != null) {
                if (prevState.getFirstDerivative() > 0) {
                    isHistoryFilled = false;
                    break;
                }
                prevState = prevState.getPreviousState();
            }
        }
        return isHistoryFilled;
    }
}
