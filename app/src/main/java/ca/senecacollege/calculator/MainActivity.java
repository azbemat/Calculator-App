/* ***************************
 * MAP524 NSA - Assignment 1
 * Name : Anas Zakariyah Bemat
 * ID: 165239187
 * Date: 2021-09-28
 ************************** */

package ca.senecacollege.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultScreen, historyScreen;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_op_plus, btn_op_minus, btn_op_multiply, btn_op_divide, btn_op_equal;
    Button btn_clear;
    Button btn_version;

    // Calculator Object
    private Calculator myCalculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // **** Creating References **** //

        resultScreen = (TextView) findViewById(R.id.resultView);
        historyScreen = (TextView) findViewById(R.id.historyView);

        btn_1 = (Button) findViewById(R.id.button_1);
        btn_2 = (Button) findViewById(R.id.button_2);
        btn_3 = (Button) findViewById(R.id.button_3);
        btn_4 = (Button) findViewById(R.id.button_4);
        btn_5 = (Button) findViewById(R.id.button_5);
        btn_6 = (Button) findViewById(R.id.button_6);
        btn_7 = (Button) findViewById(R.id.button_7);
        btn_8 = (Button) findViewById(R.id.button_8);
        btn_9 = (Button) findViewById(R.id.button_9);
        btn_0 = (Button) findViewById(R.id.button_0);

        btn_op_plus = (Button) findViewById(R.id.button_plus);
        btn_op_minus = (Button) findViewById(R.id.button_minus);
        btn_op_multiply = (Button) findViewById(R.id.button_multiply);
        btn_op_divide = (Button) findViewById(R.id.button_divide);
        btn_op_equal = (Button) findViewById(R.id.button_equal);

        btn_clear = (Button) findViewById(R.id.button_clear);

        btn_version = (Button) findViewById(R.id.button_version);

        // **** Adding Click Listener **** //

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);

        btn_op_plus.setOnClickListener(this);
        btn_op_minus.setOnClickListener(this);
        btn_op_multiply.setOnClickListener(this);
        btn_op_divide.setOnClickListener(this);
        btn_op_equal.setOnClickListener(this);

        btn_clear.setOnClickListener(this);

        btn_version.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String btn_value = ((Button)view).getText().toString(); // capture button text
        int total; // for expression total

        // Check Calculator Version
        myCalculator.checkVersion(btn_value, btn_version, historyScreen);

        switch (btn_value){
            case "c":
                resultScreen.setText("");
                this.myCalculator.userInput.clear();
                break;

            case "=":
                total = this.myCalculator.calculate(); // calculate total

                resultScreen.append(btn_value + total); // "=" + total

                // if ADVANCE version -> Add expression to history view
                myCalculator.printHistory(btn_version, historyScreen, resultScreen);
                break;

            case "ADVANCE - WITH HISTORY" :
            case "STANDARD - NO HISTORY" :
                resultScreen.append("");
                break;

            default: //  Numbers and 4 operators
                resultScreen.append(btn_value);
                this.myCalculator.push(btn_value);
                break;
        }
    }

}