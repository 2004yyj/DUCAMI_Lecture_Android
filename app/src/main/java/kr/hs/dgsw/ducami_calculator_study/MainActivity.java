package kr.hs.dgsw.ducami_calculator_study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.renderscript.Float2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button number0;
    public Button number1;
    public Button number2;
    public Button number3;
    public Button number4;
    public Button number5;
    public Button number6;
    public Button number7;
    public Button number8;
    public Button number9;
    public Button multiple;
    public Button division;
    public Button addition;
    public Button subtract;
    public Button expressionClearButton;
    public Button expressionResultButton;
    public TextView expressionTextView;
    public TextView expressionResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 에 만든 뷰들을 android:id에 맞춰서 하나하나씩 연결시키는 과정

        expressionTextView = findViewById(R.id.main_expression);

        expressionResultTextView = findViewById(R.id.main_expression_result);

        expressionClearButton = findViewById(R.id.main_expression_clear_button);

        expressionResultButton = findViewById(R.id.expression_result);

        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        multiple = findViewById(R.id.expression_mul);
        division = findViewById(R.id.expression_div);
        addition = findViewById(R.id.expression_add);
        subtract = findViewById(R.id.expression_sub);

        number0.setOnClickListener(v -> onButtonClicked((Button) v));
        number1.setOnClickListener(v -> onButtonClicked((Button) v));
        number2.setOnClickListener(v -> onButtonClicked((Button) v));
        number3.setOnClickListener(v -> onButtonClicked((Button) v));
        number4.setOnClickListener(v -> onButtonClicked((Button) v));
        number5.setOnClickListener(v -> onButtonClicked((Button) v));
        number6.setOnClickListener(v -> onButtonClicked((Button) v));
        number7.setOnClickListener(v -> onButtonClicked((Button) v));
        number8.setOnClickListener(v -> onButtonClicked((Button) v));
        number9.setOnClickListener(v -> onButtonClicked((Button) v));
        multiple.setOnClickListener(v -> onButtonClicked((Button) v));
        division.setOnClickListener(v -> onButtonClicked((Button) v));
        addition.setOnClickListener(v -> onButtonClicked((Button) v));
        subtract.setOnClickListener(v -> onButtonClicked((Button) v));
        expressionClearButton.setOnClickListener(v -> {
            expressionTextView.setText("");
            expressionResultTextView.setText("");
        });

        expressionResultButton.setOnClickListener(v -> {
            expressionTextView.setText(expressionResultTextView.getText().toString());
            expressionResultTextView.setText("");
        });
    }

    private void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.number0:
                setExpressionTextView("0");
                break;
            case R.id.number1:
                setExpressionTextView("1");
                break;
            case R.id.number2:
                setExpressionTextView("2");
                break;
            case R.id.number3:
                setExpressionTextView("3");
                break;
            case R.id.number4:
                setExpressionTextView("4");
                break;
            case R.id.number5:
                setExpressionTextView("5");
                break;
            case R.id.number6:
                setExpressionTextView("6");
                break;
            case R.id.number7:
                setExpressionTextView("7");
                break;
            case R.id.number8:
                setExpressionTextView("8");
                break;
            case R.id.number9:
                setExpressionTextView("9");
                break;
            case R.id.expression_mul:
                setExpressionTextView("*");
                break;
            case R.id.expression_div:
                setExpressionTextView("/");
                break;
            case R.id.expression_add:
                setExpressionTextView("+");
                break;
            case R.id.expression_sub:
                setExpressionTextView("-");
                break;
        }
    }

    private void setExpressionTextView(String character) {

        String addText = expressionTextView.getText().toString();

        switch (character) {
            case "0":
                addText += "0";
                break;
            case "1":
                addText += "1";
                break;
            case "2":
                addText += "2";
                break;
            case "3":
                addText += "3";
                break;
            case "4":
                addText += "4";
                break;
            case "5":
                addText += "5";
                break;
            case "6":
                addText += "6";
                break;
            case "7":
                addText += "7";
                break;
            case "8":
                addText += "8";
                break;
            case "9":
                addText += "9";
                break;
            case "*":
                addText += " * ";
                break;
            case "/":
                addText += " / ";
                break;
            case "+":
                addText += " + ";
                break;
            case "-":
                addText += " - ";
                break;
        }

        if (addText.split("\\s").length > 3) {
            Toast.makeText(getApplicationContext(), "연산자는 하나만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
        } else {
            expressionTextView.setText(addText);
        }

        if (addText.split("\\s").length == 3) {

            int first = Integer.parseInt(addText.split("\\s")[0]);
            int last = Integer.parseInt(addText.split("\\s")[2]);

            switch (addText.split("\\s")[1]) {
                case "*":
                    expressionResultTextView.setText(Integer.toString(first * last));
                    break;
                case "/":
                    expressionResultTextView.setText(Integer.toString(first / last));
                    break;
                case "+":
                    expressionResultTextView.setText(Integer.toString(first + last));
                    break;
                case "-":
                    expressionResultTextView.setText(Integer.toString(first - last));
                    break;
            }
        }
    }


}