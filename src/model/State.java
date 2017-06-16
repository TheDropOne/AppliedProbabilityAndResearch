package model;

import projectProperties.Settings;

import java.io.File;

/**
 * Created by Semen on 16-Jun-17.
 */
public class State {

    private Point currentPoint;
    private State previousState;

    private long currentTime;

    /**
     * Dynamics of plot
     */
    private float firstDerivative;
    /**
     * Acceleration of process;
     */
    private float secondDerivative;

    public State(Point currentPoint, State previousState) {
        this.currentPoint = currentPoint;
        this.previousState = previousState;
        this.currentTime = currentPoint.getTime();
        this.firstDerivative = calculateDerivative(
                currentPoint.getFunctionValue(), currentPoint.getTime(),
                previousState.getCurrentPoint().getFunctionValue(), previousState.getCurrentPoint().getTime());
        this.secondDerivative = calculateDerivative(
                firstDerivative, previousState.getFirstDerivative(),
                currentTime, previousState.getCurrentTime());
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public float getFirstDerivative() {
        return firstDerivative;
    }

    public float getSecondDerivative() {
        return secondDerivative;
    }

    /**
     * Calculating derivative using formula from mathematical analysis
     *
     * @param pivotX1
     * @param pivotY1
     * @param pivotX2
     * @param pivotY2
     * @return Increment of function divided by increment of argument
     */
    private float calculateDerivative(float pivotX1, float pivotY1, float pivotX2, float pivotY2) {
        float functionIncrement = pivotX1 - pivotX2;
        float argumentIncrement = pivotY1 - pivotY2;
        return functionIncrement / argumentIncrement;
    }


    /**
     * @return state if success, null otherwise
     * @see Settings class
     */
    // TODO
    public static State readStateFromStorage() {
        String filename = Settings.STATE_STORAGE_FILE;
        File file = new File(filename);
        // FIX -> reading from file using projectProperties.Settings fileType field

        //Пожалуйста, не стирай комменты кроме этого
    }


    /**
     * Call this method after the session or when back-up is needed
     *
     * @see Settings class
     */
    // TODO
    public static void writeProjectState() {
        String filename = Settings.STATE_STORAGE_FILE;
        File file = new File(filename);
        // FIX -> writing to file using projectProperties.Settings fileType field
    }


    /**
     * @see Settings class
     */
    // TODO
    public static void logState() {
        // writing to the end of file with logs

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("State # ").append(currentTime);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t Point = ").append(currentPoint);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("value = ").append(String.valueOf(functionValue).substring(0,10));
        return stringBuilder.toString();
    }
}
