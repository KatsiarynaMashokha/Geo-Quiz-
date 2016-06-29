package com.example.android.testtry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mName;
    int numberOfRightAnswers = 0;
    String toastMessage = "";
    boolean isAnswerCorrectQ3;
    boolean isAnswerCorrectQ6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Begin the quiz
    public void startQuiz(View view) {
        EditText playerName = (EditText) findViewById(R.id.player_name);
        String size = playerName.getText().toString();
        if (size.length() == 0) {
            showToast("Your name must be at least one character long.");
        } else {
            mName = playerName.getText().toString();
            setContentView(R.layout.question_one);
        }
    }

    //Method to show a toast message
    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    //Question 1
    public void checkQ1A1(View view) {
        showToast("Wrong answer! It is San Francisco!");
        setContentView(R.layout.question_two);

    }

    public void checkQ1A2(View view) {
        showToast("Wrong answer! It is San Francisco!");
        setContentView(R.layout.question_two);

    }

    public void checkQ1A3(View view) {
        showToast("You got it!");
        numberOfRightAnswers = numberOfRightAnswers + 1;
        setContentView(R.layout.question_two);

    }

    //Question 2
    public void checkQ2(View view) {
        CheckBox checkBoxQ2A1 = (CheckBox) findViewById(R.id.checkQ2A1);
        boolean isCheckedQ2A1 = checkBoxQ2A1.isChecked();

        CheckBox checkBoxQ2A2 = (CheckBox) findViewById(R.id.checkQ2A2);
        boolean isCheckedQ2A2 = checkBoxQ2A2.isChecked();

        CheckBox checkBoxQ2A3 = (CheckBox) findViewById(R.id.checkQ2A3);
        boolean isCheckedQ2A3 = checkBoxQ2A3.isChecked();

        CheckBox checkBoxQ2A4 = (CheckBox) findViewById(R.id.checkQ2A4);
        boolean isCheckedQ2A4 = checkBoxQ2A4.isChecked();

        CheckBox checkBoxQ2A5 = (CheckBox) findViewById(R.id.checkQ2A5);
        boolean isCheckedQ2A5 = checkBoxQ2A5.isChecked();
        if (isCheckedQ2A1 || isCheckedQ2A2 || isCheckedQ2A3 || isCheckedQ2A4 || isCheckedQ2A5) {

            if (isCheckedQ2A2 && isCheckedQ2A3 && isCheckedQ2A5) {
                numberOfRightAnswers = numberOfRightAnswers + 1;
                showToast("Good job! Correct answer!");
            } else {
                showToast("Wrong answer! NOT CAPITALS are Barcelona, Sydney, and Toronto!");
            }
            setContentView(R.layout.question_three);
        }
        else {
            showToast("You must check at least one answer!");
        }
    }

    //Question 3
    public void onRadioButtonClickedQ3(View view) {

        // Is the button now checked?
        boolean checkedQ3 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q3A1_radio_button:
                if (checkedQ3)
                    toastMessage = "Looser!";
                isAnswerCorrectQ3 = false;
                break;
            case R.id.q3A2_radio_button:
                if (checkedQ3)
                    toastMessage = "You rock! Correct answer!";
                isAnswerCorrectQ3 = true;
                break;
            case R.id.q3A3_radio_button:
                if (checkedQ3)
                    toastMessage = "Looser!";
                isAnswerCorrectQ3 = false;
                break;
        }
    }

    public void onClickQ3Submit(View view) {
        if (isAnswerCorrectQ3 == true) {
            numberOfRightAnswers = numberOfRightAnswers + 1;
        }
        if (toastMessage.length() == 0) {
            showToast("You have to choose at least one answer!");
        }
        else {
            showToast(toastMessage);
            toastMessage = "";
            setContentView(R.layout.question_four);
        }
    }

    //Question 4
    public void checkQ4(View view) {
        EditText answerFour = (EditText) findViewById(R.id.question_four);
        String rightFourAnswer = answerFour.getText().toString();
        rightFourAnswer = rightFourAnswer.trim();
        if (rightFourAnswer.length() == 6) {
            if (rightFourAnswer.equalsIgnoreCase("France")) {
                numberOfRightAnswers = numberOfRightAnswers + 1;
                showToast("Yeahh! That is France indeed!");
            } else {
                showToast("No! It is France!");
            }
            setContentView(R.layout.question_five);
        } else {
            showToast("The answer should 6 characters! Try again");
        }
    }

    //Question 5
    public void checkQ5(View view) {
        CheckBox checkBoxQ5A1 = (CheckBox) findViewById(R.id.checkQ5A1);
        boolean isCheckedQ5A1 = checkBoxQ5A1.isChecked();

        CheckBox checkBoxQ5A2 = (CheckBox) findViewById(R.id.checkQ5A2);
        boolean isCheckedQ5A2 = checkBoxQ5A2.isChecked();

        CheckBox checkBoxQ5A3 = (CheckBox) findViewById(R.id.checkQ5A3);
        boolean isCheckedQ5A3 = checkBoxQ5A3.isChecked();

        CheckBox checkBoxQ5A4 = (CheckBox) findViewById(R.id.checkQ5A4);
        boolean isCheckedQ5A4 = checkBoxQ5A4.isChecked();

        if (isCheckedQ5A1 || isCheckedQ5A2 || isCheckedQ5A3 || isCheckedQ5A4) {

            if (isCheckedQ5A2 && isCheckedQ5A4) {
                numberOfRightAnswers = numberOfRightAnswers + 1;
                showToast("Awesome job!!!");
            } else {
                showToast("Wrong(.The answer is Comoros and Guinea Bissau!");
            }
            setContentView(R.layout.question_six);
        }
        else {
            showToast("You must check at least one answer!");
        }
    }

    //Question 6
    public void onRadioButtonClickedQ6(View view) {
        boolean checkedQ6 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q6A1_radio_button:
                if (checkedQ6)
                    toastMessage = "Looser! The correct answer is Netherlands!";
                isAnswerCorrectQ6 = false;
                break;
            case R.id.q6A2_radio_button:
                if (checkedQ6)
                    toastMessage = "You rock! Correct answer!";
                isAnswerCorrectQ6 = true;
                break;
            case R.id.q6A3_radio_button:
                showToast("Looser! The correct answer is Netherlands!");
                setContentView(R.layout.question_seven);
                break;
            case R.id.q6A4_radio_button:
                toastMessage = "Looser! The correct answer is Netherlands!";
                isAnswerCorrectQ6 = false;
                break;
        }
    }

    public void onClickQ6Submit(View view) {
        if (isAnswerCorrectQ6) {
            numberOfRightAnswers = numberOfRightAnswers + 1;
        }
        if (toastMessage.length() == 0) {
            showToast("Choose one answer!");
        } else {
            showToast(toastMessage);
            toastMessage = "";
            setContentView(R.layout.question_seven);
        }
    }

    //Question 7
    public void checkQ7(View view) {
        EditText answerSeven = (EditText) findViewById(R.id.question_seven);
        String rightSevenAnswer = answerSeven.getText().toString();
        rightSevenAnswer = rightSevenAnswer.trim();
        if (rightSevenAnswer.length() == 6) {
            if (rightSevenAnswer.equalsIgnoreCase("Mexico")) {
                numberOfRightAnswers = numberOfRightAnswers + 1;
                showToast("Correct answer!");
            } else {
                showToast("No! It is Mexico!");
            }
            setContentView(R.layout.last_page);
        } else {
            showToast("The answer should be 6 characters! Try again");
        }

    }

    //Get Geo Quiz results
    public void checkResult(View view) {
        Button resultsButton = (Button) findViewById(R.id.results_button_view);
        resultsButton.setVisibility(View.INVISIBLE);
        TextView winnerTextViewTwo = (TextView) findViewById(R.id.final_message_two_text_view);
        winnerTextViewTwo.setText("");
        ImageView imageResults = (ImageView) findViewById(R.id.results_image_view);
        if (numberOfRightAnswers >= 5) {
            imageResults.setImageResource(R.drawable.happyface);
            String finalMessageGood = mName + ", amazing job! You scored " + numberOfRightAnswers + " points out of possible 7!";
            displayMessage(finalMessageGood);
        } else {
            imageResults.setImageResource(R.drawable.sadface);
            String finalMessageBad = mName + ", you did not do that well! You scored " + numberOfRightAnswers + " points out of possible 7!";
            displayMessage(finalMessageBad);
        }

    }

    private void displayMessage(String messageFinal) {
        TextView finalTextView = (TextView) findViewById(R.id.final_message_text_view);
        finalTextView.setText(messageFinal);
    }
}




