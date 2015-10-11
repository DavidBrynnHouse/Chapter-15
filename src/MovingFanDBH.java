import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by David House on 9/19/2015.
 * IS 413
 * This program creates 4 fans and places them into a
 * Grid pane.
 */
public class MovingFanDBH extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox hBox = new HBox(5);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(pause, resume, reverse);
        pane.setBottom(hBox);

        Fan fan = new Fan();
        pane.setCenter(fan);

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pause.setOnAction(e -> animation.pause());
        resume.setOnAction(e -> animation.play());
        reverse.setOnAction(e -> fan.reverse());

        Scene scene = new Scene(pane, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
    class Fan extends Pane {
        private double w = 400;
        private double h = 400;
        private double radius = w * .45;

        private Arc arc[] = new Arc[4];
        private double startAngle = 30;
        private Circle circle = new Circle(w / 2, h / 2, radius);

        public Fan() {
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.WHITE);
            getChildren().add(circle);

            for (int j = 0; j < 4; j++) {
                arc[j] = new Arc(w / 2, h / 2, radius * .9, radius * .9, startAngle + j * 90, 35);
                arc[j].setFill(Color.BLUE);
                arc[j].setType(ArcType.ROUND);
                getChildren().addAll(arc[j]);
            }
        }

        public void setValues() {
            radius = w * .45;
            circle.setRadius(radius);
            circle.setCenterX(w / 2);
            circle.setCenterY(h / 2);

            for (int j = 0; j < 4; j++) {
                arc[j].setRadiusX(radius * .9);
                arc[j].setRadiusY(radius * .9);
                arc[j].setCenterX(w / 2);
                arc[j].setCenterY(h / 2);
                arc[j].setStartAngle(startAngle + j * 90);

            }
        }

        private double increment = 5;

        public void move() {
            setStartAngle(startAngle + increment);
        }

        public void reverse() {
            increment = -increment;
        }

        public double getW() {
            return w;
        }

        public void setW(double w) {
            this.w = w;
        }

        public double getH() {
            return h;
        }

        public void setH(double h) {
            this.h = h;
        }

        public void setStartAngle(double angle) {
            this.startAngle = angle;
            setValues();
        }
    }

