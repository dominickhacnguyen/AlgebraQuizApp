package com.example.dom.algebraapp;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.algebraapp;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    /**
     * Method to create toast based on answers
     * @param q1 boolean value for question 1.
     * @param q2 boolean value for question 2.
     * @param q3 boolean value for question 3.
     * @param q4 boolean value for question 4.
     * @param q5 boolean value for question 5.
     * @return resultMessage
     */
    public String createToast(boolean q1, boolean q2, boolean q3, boolean q4, boolean q5) {
        boolean[] questionList = {q1, q2, q3, q4, q5};
        int count = 0;
        String resultMessage = "";
        for (boolean i : questionList) {
            count ++;
            if (i){
                resultMessage += "Question " + count + ": \u2713\n";
            } else {
                resultMessage += "Question " + count + ": x\n";
            }
        }
        return resultMessage;
    }

    /**
     * Method to check if answers are correct and display toast.
     * @param view
     */
    public void displayToast(View view) {

        // Questions 1 - 3 Multiple  Choice
        RadioButton q1cRadio = (RadioButton) findViewById(R.id.q1c);
        boolean q1cChecked = q1cRadio.isChecked();

        RadioButton q2bRadio = (RadioButton) findViewById(R.id.q2b);
        boolean q2bChecked = q2bRadio.isChecked();

        RadioButton q3aRadio = (RadioButton) findViewById(R.id.q3a);
        boolean q3aChecked = q3aRadio.isChecked();

        // Question 4 Multiple Choice w/ Multiple Answers
        CheckBox q4aMC = (CheckBox) findViewById(R.id.q4a);
        boolean q4aChecked = q4aMC.isChecked();

        CheckBox q4bMC = (CheckBox) findViewById(R.id.q4b);
        boolean q4bChecked = q4bMC.isChecked();

        CheckBox q4cMC = (CheckBox) findViewById(R.id.q4c);
        boolean q4cChecked = q4cMC.isChecked();

        boolean q4Correct = false;
        if (q4aChecked && !q4bChecked && q4cChecked) {
            q4Correct = true;
        }

        // Question 5 Free Response
        EditText q5FR = (EditText) findViewById(R.id.q5);
        String q5Answer = q5FR.getText().toString();
        boolean q5Correct = false;
        if (q5Answer.equals("15") || q5Answer.equals("fifteen") || q5Answer.equals("Fifteen")) {
            q5Correct = true;
        }

        // Display Result Toast
        String message = createToast(q1cChecked, q2bChecked, q3aChecked, q4Correct, q5Correct);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

