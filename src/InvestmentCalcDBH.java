import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by David on 9/26/2015.
 */
public class InvestmentCalcDBH extends Application {
    Button calculateBt = new Button("Calculate");

    private Label invAmt = new Label("Investment Amount:");
    private Label numYears = new Label("Number of Years:");
    private Label intRate = new Label("Annual Interest Rate:");
    private Label futVal = new Label("Future Value:");

    private TextField invText = new TextField();
    private TextField numText = new TextField();
    private TextField intText = new TextField();
    private TextField futText = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);

        calculateBt.setOnAction((ActionEvent e) -> {
             calculateInterest();
        });

        pane.add(invAmt, 0, 0);
        pane.add(invText, 1, 0);
        pane.add(numYears, 0, 1);
        pane.add(numText, 1, 1);
        pane.add(intRate, 0, 2);
        pane.add(intText, 1, 2);
        pane.add(futVal, 0, 3);
        pane.add(futText, 1, 3);
        pane.add(calculateBt, 1, 4);

        Scene scene = new Scene(pane, 750, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void calculateInterest(){
        double investment = Double.parseDouble(invText.getText());
        int years = Integer.parseInt(numText.getText());
        double rate = Double.parseDouble(intText.getText());
        double finalAmount = investment * Math.pow((1 + (rate / 1200)), (years * 12));
        futText.setText(String.format("$%.2f", finalAmount));
    }
}
