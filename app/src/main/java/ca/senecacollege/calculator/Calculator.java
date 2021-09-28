/* ***************************
* MAP524 NSA - Assignment 1
* Name : Anas Zakariyah Bemat
* ID: 165239187
* Date: 2021-09-28
 ************************** */

package ca.senecacollege.calculator;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<String> userInput = new ArrayList<String>();

    void push (String value){

        userInput.add(value);  // push values

    }

    int calculate(){

        List<String> tempList = userInput;
        int result;
        int length;

        length = tempList.size();

        result = applyOperator(tempList.get(0), tempList.get(1), tempList.get(2));   // num1, operator, num2

        for(int i = 3; i < length; i+=1){
            result = applyOperator(String.valueOf(result), tempList.get(i), tempList.get(i+=1));  // result, operator, nextNum...
        }

        return result;

    }

    int applyOperator(String firstOperand, String operator, String secondOperand){
        int result = 0;
        switch (operator) {
            case "+":
                result = Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
                break;
            case "-":
                result = Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand);
                break;
            case "*":
                result = Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand);
                break;
            case "/":
                result = Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand);
                break;
        }

        return result;
    }

    void checkVersion(String btnValue, Button btn, TextView historyScreen){
        if(btnValue.equals("ADVANCE - WITH HISTORY")){

            // Change Button style
            btn.setBackgroundColor(Color.rgb(153, 153, 186));
            btn.setText(R.string.s_btn_text_Standard);

        }else if(btnValue.equals("STANDARD - NO HISTORY")){

            // clear history
            historyScreen.setText("");

            // Change Button style
            btn.setBackgroundColor(Color.rgb(137, 121, 234));
            btn.setText(R.string.s_btn_text_Advance);
        }
    }

    void printHistory(Button btn_version, TextView historyScreen, TextView resultScreen){
        if(btn_version.getText().toString().equals("STANDARD - NO HISTORY")){
            historyScreen.append(resultScreen.getText() + "\n");
        }
    }

}
