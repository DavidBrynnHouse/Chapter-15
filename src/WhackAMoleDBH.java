import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by David on 9/28/2015.
 */
public class WhackAMoleDBH extends Application{
    int x = 600;
    int y = 200;
    @Override
    public void start(Stage primaryStage){

        showCircle(primaryStage);
    }
    public void showCircle(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle(Math.random() * x, Math.random() * y, 15);

        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
