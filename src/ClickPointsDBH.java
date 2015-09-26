import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * Created by David on 9/26/2015.
 */
public class ClickPointsDBH extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setOnMouseClicked((MouseEvent e) -> {
            double color1 = Math.random();
            double color2 = Math.random();
            double color3= Math.random();
            Color color = new Color(color1, color2, color3, color1);
            pane.getChildren().add(new Circle(e.getSceneX(), e.getSceneY(), 15, color));
        });

        Scene scene = new Scene(pane, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
