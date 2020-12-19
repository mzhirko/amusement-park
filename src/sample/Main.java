package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.view.StartWindow;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        AdministratorWindow administrator = new AdministratorWindow ();
//        administrator.show();
        Injector injector = new Injector();
        injector.create_park_management();
        injector.createUI();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
