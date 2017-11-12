/*
 *  App
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm;

import kpi.fpm.controller.Controller;
import kpi.fpm.model.Model;
import kpi.fpm.view.View;

public class App 
{
    public static void main( String[] args )
    {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // start
        controller.userProcess();

    }
}
