package model;

/**
 * Created by Semen on 16-Jun-17.
 */
public class Point {
    /**
     * Time in nanoseconds for current state
     */
    private long time;
    /**
     * Value of function on plot
     */
    private int functionValue;

    /**
     * @param time
     * @param functionValue
     */
    public Point(long time, int functionValue) {
        this.time = time;
        this.functionValue = functionValue;
    }

    public long getTime() {
        return time;
    }

    public int getFunctionValue() {
        return functionValue;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point");
        stringBuilder.append(" : ");
        stringBuilder.append("time = ").append(String.valueOf(time / 1e9).substring(0,5));
        stringBuilder.append(" ; ");
        stringBuilder.append("value = ").append(String.valueOf(functionValue).substring(0,10));
        return stringBuilder.toString();
    }
}