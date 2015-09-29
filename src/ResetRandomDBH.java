import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by David on 9/17/2015.
 * IS 413
 * This Program Displays cards Randomly
 * in a window
 */
public class ResetRandomDBH extends Application{
    Button resetBT = new Button("Reset");

    @Override
    public void start(Stage primaryStage) {
        resetBT.setOnAction((ActionEvent e) -> {
            //showBacks(primaryStage);
            randomCards(primaryStage);
        });
        randomCards(primaryStage);
    }

    public void randomCards(Stage primaryStage) {
        Integer[] list = new Integer[52];
        for (int i = 0; i < 54; i++)
            list[i] = i + 1;

        ArrayList<Integer> deck = new ArrayList<>(Arrays.asList(list));
        Collections.shuffle(deck);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.BASELINE_LEFT);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(35);
        gridPane.setVgap(5);

        ImageView viewCard1 = new ImageView("card/" + deck.get(1) + ".png");
        ImageView viewCard2 = new ImageView("card/" + deck.get(2) + ".png");
        ImageView viewCard3 = new ImageView("card/" + deck.get(3) + ".png");
        ImageView viewCard4 = new ImageView("card/" + deck.get(4) + ".png");
        ImageView viewCard5 = new ImageView("card/" + deck.get(5) + ".png");

        gridPane.add(viewCard1, 0, 0);
        gridPane.add(viewCard2, 1, 0);
        gridPane.add(viewCard3, 2, 0);
        gridPane.add(viewCard4, 3, 0);
        gridPane.add(viewCard5, 4, 0);
        gridPane.add(resetBT, 2, 1);

        Scene scene = new Scene(gridPane, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*public void showBacks(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.BASELINE_LEFT);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(35);
        gridPane.setVgap(5);

        ImageView viewCard1 = new ImageView("card/b1fv.png");
        ImageView viewCard2 = new ImageView("card/b2fv.png");

        gridPane.add(viewCard1, 0, 0);
        gridPane.add(viewCard2, 1, 0);
        gridPane.add(viewCard1, 2, 0);
        gridPane.add(viewCard2, 3, 0);
        gridPane.add(viewCard1, 4, 0);
        gridPane.add(resetBT, 2, 1);

        Scene scene = new Scene(gridPane, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

}
