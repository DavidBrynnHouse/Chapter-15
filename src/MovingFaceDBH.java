import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by David on 9/24/2015.
 * IS413
 * Move a picture around with buttons
 */
public class MovingFaceDBH extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 1000;
        int height = 1000;

        BorderPane pane = new BorderPane();
        Button upBT = new Button("Up");
        Button downBT = new Button("Down");
        Button leftBT = new Button("Left");
        Button rightBT = new Button("Right");

        HBox hbox = new HBox(15);
        hbox.getChildren().addAll(upBT, downBT, leftBT, rightBT);
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        Image pikachu = new Image("Pikachu.png");
        ImageView viewPikachu = new ImageView(pikachu);
        viewPikachu.setX(500);
        viewPikachu.setY(500);

        upBT.setOnAction((ActionEvent e) -> {
            viewPikachu.setY((viewPikachu.getY() <= 0) ? viewPikachu.getY() : decrement(viewPikachu.getY()));
        });
        leftBT.setOnAction(e -> {
            viewPikachu.setX((viewPikachu.getX() <= 0 ) ? viewPikachu.getX() : decrement(viewPikachu.getX()));
        });
        rightBT.setOnAction(e -> {
            viewPikachu.setX((viewPikachu.getX() >= 1000) ? viewPikachu.getX() : increment(viewPikachu.getX()));
        });
        downBT.setOnAction(e -> {
            viewPikachu.setY((viewPikachu.getY() >= 1000 ) ? viewPikachu.getY() : increment(viewPikachu.getY()));
        });

        pane.setBottom(hbox);
        pane.getChildren().addAll(viewPikachu);
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Moving image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public double increment(double imgPos) {
        return imgPos += 10;
    }
    public double decrement(double Pos) {
        return Pos -= 10;
    }

}
