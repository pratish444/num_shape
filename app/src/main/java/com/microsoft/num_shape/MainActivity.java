package com.microsoft.num_shape;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class TriangularNumber {
        int number;

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            return triangularNumber == number;
        }
    }

    class SquareNumber {
        int number;

        public boolean isSquare() {
            int sqrt = (int) Math.sqrt(number);
            return (sqrt * sqrt == number);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNumber(View view) {

        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message;
        if (editText.getText().toString().isEmpty()) {
            message = "please enter the number";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        } else {
            int number = Integer.parseInt(editText.getText().toString());

            TriangularNumber myTriangularNumber = new TriangularNumber();
            SquareNumber mySquareNumber = new SquareNumber();


            myTriangularNumber.number = number;
            mySquareNumber.number = number;

            message = editText.getText().toString();

            if (mySquareNumber.isSquare() && myTriangularNumber.isTriangular()) {
                message += " is both square and triangular.";
            } else if (mySquareNumber.isSquare()) {
                message += " is square but not triangular.";
            } else if (myTriangularNumber.isTriangular()) {
                message += " is triangular but not square.";
            } else {
                message += " is neither square nor triangular.";
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}
