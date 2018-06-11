package com.stephanraab.receiptcalculation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        displayTipCost(tipPercentage, subTotal);
        displayTotalPrice(tipPercentage, subTotal);

        LinearLayout outputView = findViewById(R.id.receipt_output);
        outputView.setVisibility(View.VISIBLE);

        // Check if no view has focus and then close/hide keyboard:
        View currentView = this.getCurrentFocus();
        if (currentView != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(currentView.getWindowToken(), 0);
        }
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
