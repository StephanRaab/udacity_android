/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int coffeeQuantity = 0;
    double coffeeCost = 3.5;

    double houseBlendCost = 2.5;
    double elDiableCost = 2.5;
    double americanoDecafCost = 2.5;

    double latteCost = 3.5;
    double cappuccinoCost = 3.00;
    double macchiatoCost = 2.75;
    double americanoCost = 2.50;
    double mochaCost = 3.75;
    double doubleEspressoCost = 2.25;
    double addShotCost = 1.00;

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayOrderTotal(double number){
        TextView orderTotal = (TextView) findViewById(R.id.orderTotal);
        orderTotal.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void incrementCoffeeAmount(View view){
        coffeeQuantity++;
        display(coffeeQuantity);
        displayOrderTotal(coffeeQuantity * coffeeCost);
    }

    public void decrementCoffeeAmount(View view){
        if (coffeeQuantity > 0){
            coffeeQuantity--;
        }
        display(coffeeQuantity);
        displayOrderTotal(coffeeQuantity * coffeeCost);
    }
}
