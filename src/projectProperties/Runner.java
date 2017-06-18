package projectProperties;

import model.Point;
import model.State;
import probabilities.MartingaleStrategy;
import probabilities.Risks;
import reverseEngineering.BinaryCom;

/**
 Created by Semen on 28-May-17
 */
public class Runner {

    private static State lastSavedState;

    private static State currentState;

    private static int median;

    private static volatile boolean interrupted;

    public static void main(String[] args) {
        lastSavedState = State.readStateFromStorage();

        currentState = new State(new Point(System.nanoTime(), median), lastSavedState);
        Thread dataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!interrupted) {
                    // Processor-hard operation, needed to be replaced with async-await model
                    currentState = new State(BinaryCom.getCurrentPointFromPlot(new Object()), currentState);
                    System.out.println(currentState);
                    try {
                        Thread.sleep(Settings.ITERATION_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        interrupted = true;
                    }
                }
            }
        });
        dataThread.start();


        Thread analysisThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!interrupted) {
                    boolean isItGoodToStart = Risks.isItGoodToStart(currentState);
                    System.out.println("Is it good to start = " + isItGoodToStart);
                    if (isItGoodToStart) {
                        System.out.println("______ALERT________STARTING BROKERING!!!!_______");
                        MartingaleStrategy.calculateRateAmount(currentState);
                        System.err.println(currentState);
                    }
                    try {
                        Thread.sleep(Settings.ITERATION_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        interrupted = true;
                    }
                }
            }
        });
        analysisThread.start();


    }
}
