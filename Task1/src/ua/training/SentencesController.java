/*
 *  Controller
 *  30.10.2017
 */

package ua.training;

import java.util.Scanner;

/**
 * This class provides data into the model and updates the view whenever
 * data changes. This class also checks data for correctness.
 */
public class SentencesController {
    private Sentences theModel;
    private SentencesView theView;

    /**
     * Buffer for words
     */
    private StringBuilder sentences;

    /**
     * Constructor initializes pattern. Also it initializes buffer for words.
     * @param theModel the model, business logic.
     * @param theView the view, model's visualization.
     */
    public SentencesController(Sentences theModel, SentencesView theView) {
        this.theModel = theModel;
        this.theView = theView;
        sentences = new StringBuilder();
    }

    // User process
    public void userProcess() {
        final Scanner sc = new Scanner(System.in);

        checkInput(sc, SentencesView.RULE.split(" "));

        theModel.setSentences(sentences.toString());
        theView.display(theModel.getSentences());

        sc.close();

    }

    /**
     * Checks data for correctness. This method compares each input word
     * with word rule. If input is correct then word append to buffer,
     * otherwise will print a warning. When all words were checked,
     * method exists.
     * @param sc the scanner input stream
     * @param rule the sentence that is separated into words with a space
     *        and is compared to the input string in the order of the queue.
     */
    private void checkInput(Scanner sc, String[] rule) {
        int wordIndex = 0;
        String input;
        while (wordIndex < rule.length){
            if ((input = sc.next()).equals(rule[wordIndex])) {
                sentences.append(input).append(" ");
                ++wordIndex;
            } else {
                theView.display(SentencesView.INCORRECT_INPUT + " '" + input + "', "
                                + SentencesView.PROMPT + " '" + rule[wordIndex] + "'");
            }
        }
    }
}
