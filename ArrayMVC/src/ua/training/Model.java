/*
 *  Model
 *  30.10.2017
 */

package ua.training;

/**
 * This class contains business logic of project.
 */
public class Model {

    /**
     * The array buffer into which stores the elements.
     */
    private long array[];

    public long[] getArray() {
        return array;
    }

    public void setArray(long[] array) {
        this.array = array;
    }

    /**
     * Returns string of indexes whose values matches with a random number.
     * @param value random long number
     * @return a string of indexes
     */
    public String find(long value) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                buffer.append(i).append(" ");
            }
        }
        return buffer.toString();
    }

}
