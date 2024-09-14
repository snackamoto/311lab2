package com.example.lb2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public void start(Stage primaryStage) {
        Label loanAmountLabel = new Label("Loan Amount: ");  //Labels for amount
        TextField loanAmountField = new TextField();
        Label annualInterestRateLabel = new Label("Annual Interest Rate: "); //Field for amount
        TextField annualInterestRateField = new TextField();
        Label numberOfYearsLabel = new Label("Number of Years: "); //Label for years
        TextField numberOfYearsField = new TextField();
        Button calculateButton = new Button("Calculate Payment"); //Button
        Label monthlyPaymentLabel = new Label("Monthly Payment: "); //Label for monthyl payment
        Label totalPaymentLabel = new Label("Total Payment: "); //label for total payment

        GridPane grid = new GridPane(); //Gridplane layout
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.add(loanAmountLabel, 0, 0); //text and placement of label and field
        grid.add(loanAmountField, 2, 0);
        grid.add(annualInterestRateLabel, 0, 1); //text and placement
        grid.add(annualInterestRateField, 2, 1);
        grid.add(numberOfYearsLabel, 0, 2); //text and placement
        grid.add(numberOfYearsField, 2, 2);
        grid.add(calculateButton, 2, 3); // button placement
        grid.add(monthlyPaymentLabel, 1, 4); //labels
        grid.add(totalPaymentLabel, 1, 5);

        calculateButton.setOnAction(e -> { // button paramters and function
            try {
                double loanAmount = Double.parseDouble(loanAmountField.getText()); // get input for loanamount
                double annualInterestRate = Double.parseDouble(annualInterestRateField.getText()); //get input for interest rate
                int numberOfYears = Integer.parseInt(numberOfYearsField.getText()); //get input for # of years
                double monthlyInterestRate = annualInterestRate / (12 * 100); //calculation for Monthly Payents
                int numberOfPayments = numberOfYears * 12; //calc monthly payments
                double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
                double totalPayment = monthlyPayment * numberOfPayments; //total payment calc

                monthlyPaymentLabel.setText("Monthly Payment: $" + String.format("%.2f", monthlyPayment)); //output monthyl payment calculated in float
                totalPaymentLabel.setText("Total Payment: $" + String.format("%.2f", totalPayment)); //output montly payment total in float
            } catch (NumberFormatException ex) { //if user enters invalid characters
                monthlyPaymentLabel.setText("Invalid Input!");
                totalPaymentLabel.setText("Invalid Input!");
            }
        });

        Scene scene = new Scene(grid, 500, 500); //Set scene parameters
        primaryStage.setTitle("Loan Calculator"); //title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}