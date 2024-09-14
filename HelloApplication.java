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
        Label annualInterestRateLabel = new Label("Annual Interest Rate: "); //Field for amount
        TextField annualInterestRateField = new TextField();
        Label numberOfYearsLabel = new Label("Number of Years: "); //Label for years
        TextField numberOfYearsField = new TextField();
        Label loanAmountLabel = new Label("Loan Amount: ");  //Labels for amount
        TextField loanAmountField = new TextField();
        Label monthlyPaymentLabel = new Label("Monthly Payment: "); //Label for monthyl payment
        TextField monthlyPaymentField = new TextField();
        Label totalPaymentLabel = new Label("Total Payment: "); //label for total payment
        TextField totalPaymentField = new TextField();
        Button calculateButton = new Button("Calculate"); //Button

        GridPane grid = new GridPane(); //Gridplane layout
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(annualInterestRateLabel, 0, 0); //text and placement of label and field
        grid.add(annualInterestRateField, 1, 0);
        grid.add(numberOfYearsLabel, 0, 1); //text and placement
        grid.add(numberOfYearsField, 1, 1);
        grid.add(loanAmountLabel, 0, 2); //text and placement
        grid.add(loanAmountField, 1, 2);
        grid.add(monthlyPaymentLabel, 0, 3); //labels
        grid.add(monthlyPaymentField, 1, 3);
        grid.add(totalPaymentLabel, 0, 4);
        grid.add(totalPaymentField, 1, 4);
        grid.add(calculateButton, 1, 5); // button placement

        calculateButton.setOnAction(e -> { // button paramters and function
            try {
                double loanAmount = Double.parseDouble(loanAmountField.getText()); // get input for loanamount
                double annualInterestRate = Double.parseDouble(annualInterestRateField.getText()); //get input for interest rate
                int numberOfYears = Integer.parseInt(numberOfYearsField.getText()); //get input for # of years
                double monthlyInterestRate = annualInterestRate / (12 * 100); //calculation for Monthly Payents
                int numberOfPayments = numberOfYears * 12; //calc monthly payments
                double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
                double totalPayment = monthlyPayment * numberOfPayments; //total payment calc

                monthlyPaymentField.setText(String.format("%.2f", monthlyPayment)); //output monthyl payment calculated in float
                totalPaymentField.setText(String.format("%.2f", totalPayment)); //output montly payment total in float
            } catch (NumberFormatException ex) { //if user enters invalid characters
                monthlyPaymentField.setText("Invalid Input!");
                totalPaymentField.setText("Invalid Input!");
            }
        });

        Scene scene = new Scene(grid, 400, 300); //Set scene parameters
        primaryStage.setTitle("LoanCalculator"); //title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}