package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("GameUI.fxml"));
        Scene scean = new Scene(root);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scean);
        primaryStage.setMaxHeight(440);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(440);
        primaryStage.setMinWidth(600);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);

    }
}