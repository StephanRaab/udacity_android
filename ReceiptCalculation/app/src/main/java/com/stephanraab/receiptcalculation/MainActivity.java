package com.stephanraab.receiptcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    static EditText getSubTotal;
    static EditText getTipPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSubTotal = (EditText) findViewById(R.id.receipt_subtotal);
        getTipPercentage = (EditText) findViewById(R.id.tip_amount);
    }

    public void getTipAndTotal(View view) {
        double subTotal = Double.parseDouble(getSubTotal.getText().toString());
        double tipPercentage = Double.parseDouble(getTipPercentage.getText().toString());

//        double double_subTotal = Double.parseDouble(subTotal);
//        double double_tipPercentage = Double.parseDouble(tipPercentage);

        displayTipCost(tipPercentage, subTotal);
        displayTotalPrice(tipPercentage, subTotal);
    }

    private void displayTipCost(double tip, double subTotal) {
        double tipAmount = subTotal * (tip/100);

        TextView tipCostTextView = (TextView) findViewById(R.id.tip_amount_textView);
        tipCostTextView.setText(NumberFormat.getCurrencyInstance().format(tipAmount));
    }

    private void displayTotalPrice(double tip, double subTotal) {
        double tipAmount = subTotal * (tip/100);
        double totalAmount = subTotal + tipAmount;

        TextView totalAmountTextView = (TextView) findViewById(R.id.total_amount_textView);
        totalAmountTextView.setText(NumberFormat.getCurrencyInstance().format(totalAmount));
    }


}
