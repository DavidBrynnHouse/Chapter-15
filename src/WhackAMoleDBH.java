import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by David on 9/28/2015.
 */
public class WhackAMoleDBH extends Application{
    int x = 600;
    int y = 200;
    int count = 1;
    @Override
    public void start(Stage primaryStage){
            showCircle(primaryStage);
    }
    public void showCircle(Stage primaryStage) {
        Pane pane = new Pane();
        long startTime = System.currentTimeMillis();
        Circle newCircle = new Circle(Math.random() * x, Math.random() * y, 15);
            pane.setOnMouseClicked((MouseEvent e) -> {
                if (e.getX() <= newCircle.getCenterX() + newCircle.getRadius() &&
                        e.getX() >= newCircle.getCenterX() - newCircle.getRadius() &&
                        e.getY() <= newCircle.getCenterY() + newCircle.getRadius() &&
                        e.getY() >= newCircle.getCenterY() - newCircle.getRadius() &&
                        count < 5) {
                    newCircle.setCenterX(Math.random() * x);
                    newCircle.setCenterY(Math.random() * y);
                    count++;
                }
                else if(count == 5){
                    long endTime = System.currentTimeMillis();
                    pane.getChildren().clear();
                    Label test = new Label(String.valueOf("it took you " +
                            (endTime - startTime)/1000.0) + " seconds to hit them all");
                    pane.getChildren().add(test);
                }
            });

        pane.getChildren().add(newCircle);
        Scene scene = new Scene(pane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
