package ua.training;

public class Main {

    public static void main(String[] args) {

        //Initialize
	    Model model = new Model();
	    View view = new View();
	    Controller controller = new Controller(model, view);

	    //Start program
	    controller.doIt();
    }
}
