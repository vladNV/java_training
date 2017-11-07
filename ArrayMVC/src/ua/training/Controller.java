/*
 *  Controller
 *  30.10.2017
 */

package ua.training;

/**
 * This class provides data into the model and updates the view whenever
 * data changes. This class also checks data for correctness.
 */
public class Controller {
    private Model theModel;
    private View theView;

    /**
     * Constructor initializes pattern.
     * @param theModel the model, business logic.
     * @param theView the view, model's visualization.
     */
    public Controller(Model theModel, View theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    // User process
    public void doIt() {
        long number = getRandomNumber();
        theModel.setArray(getRandomArray(50));

        String indexes = theModel.find(number);

        theView.print(View.OUR_ARRAY);
        theView.printArray(theModel.getArray());
        theView.print(View.NUMBER);
        theView.print(String.valueOf(number));
        theView.print(View.INDEXES);
        theView.print(indexes);

    }

    /**
     * Returns random long number.
     * @return random long number.
     */
    private long getRandomNumber() {
        return (long) (Math.random() * 20);
    }

    /**
     * Return random array of long numbers.
     * @param capacity this size of array
     * @return random array of long numbers
     */
    private long[] getRandomArray(int capacity) {
        long[] arr = new long[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long) (Math.random() * 20);
        }
        return arr;
    }

}
