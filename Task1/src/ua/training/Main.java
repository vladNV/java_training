package ua.training;

public class Main {

    public static void main(String[] args) {

        Sentences model = new Sentences();
        SentencesView view = new SentencesView();
        SentencesController controller = new SentencesController(model, view);
        // start program
        controller.userProcess();

    }
}
