package com.learnoset.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  String [] BODMAS_RULE = {"÷", "×", "\\+", "-"};

    private int CURRENT_RULE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView expression = findViewById(R.id.expression);
        final TextView resultHOlder = findViewById(R.id.resultHolder);

        // Числа
        final Button OneBtn = findViewById(R.id.OneBtn);
        final Button TwoBtn = findViewById(R.id.TwoBtn);
        final Button ThreeBtn = findViewById(R.id.ThreeBtn);
        final Button FourBtn = findViewById(R.id.FourBtn);
        final Button FiveBtn = findViewById(R.id.FiveBtn);
        final Button SixBtn = findViewById(R.id.SixBtn);
        final Button SevenBtn = findViewById(R.id.SevenBtn);
        final Button EightBtn = findViewById(R.id.EightBtn);
        final Button NineBtn = findViewById(R.id.NineBtn);
        final Button ZeroBtn = findViewById(R.id.ZeroBtn);
        // Действия
        final Button DivisionBtn = findViewById(R.id.DivisionBtn);
        final Button MultiplicationBtn = findViewById(R.id.MultiplicationBtn);
        final Button SubtractionBtn = findViewById(R.id.SubtractionBtn);
        final Button AdditionBtn = findViewById(R.id.AdditionBtn);


        final Button AddSubBtn = findViewById(R.id.AddSubBtn);
        final Button ModulusBtn = findViewById(R.id.ModulusBtn);


        // Ответ
        final Button EqualsBtn = (findViewById(R.id.EqualsBtn));
        // Пустая кнопка
        final Button DotBtn = findViewById(R.id.DotBtn);

        // Кнопки очищения
        final Button DelBtn = findViewById(R.id.DelBtn);
        final Button CBtn = findViewById(R.id.CBtn);


        CBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression.setText(""); // Пустое выражение
                resultHOlder.setText("");
            }
        });

        DelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();

                if(!expressionText.isEmpty()){
                    expression.setText(expressionText.substring(0, expressionText.length() -1));
                }
            }
        });



        AddSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        EqualsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final  String expressionText = expression.getText().toString();

                if(expressionText.contains("+") || expressionText.contains("-") || expressionText.contains("÷") || expressionText.contains("×")){

                    final char getLastCharacter = expressionText.charAt(expressionText.length() -1);

                    if(getLastCharacter !='+' || getLastCharacter !='-' || getLastCharacter !='×' || getLastCharacter !='÷'){

                        calculateResult(expression, resultHOlder, expressionText);
                    }
                }
            }
        });

        SubtractionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();

                if(expressionText.isEmpty()) {
                    expression.setText("0-");

                }
                else{
                    final char getLastCharacter = expressionText.charAt(expressionText.length() -1);

                    if(getLastCharacter == '+'  || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '÷'){
                        expression.setText(expressionText.substring(0,expressionText.length() -1)+ "-");
                    }
                    else{
                        expression.setText(expressionText+"-");
                    }
                }
            }
        });

        AdditionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();

                if(expressionText.isEmpty()) {
                    expression.setText("0+");

                }
                else{
                    final char getLastCharacter = expressionText.charAt(expressionText.length() -1);

                    if(getLastCharacter == '+'  || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '÷'){
                        expression.setText(expressionText.substring(0,expressionText.length() -1)+ "+");
                    }
                    else{
                        expression.setText(expressionText+"+");
                    }
                }
            }
        });

        MultiplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();

                if(expressionText.isEmpty()) {
                    expression.setText("0×");

                }
                else{
                    final char getLastCharacter = expressionText.charAt(expressionText.length() -1);

                    if(getLastCharacter == '+'  || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '÷'){
                        expression.setText(expressionText.substring(0,expressionText.length() -1)+ "×");
                    }
                    else{
                        expression.setText(expressionText+"×");
                    }
                }
            }
        });

        ModulusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        DivisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();

                if(expressionText.isEmpty()) {
                    expression.setText("0÷");

                }
                else{
                    final char getLastCharacter = expressionText.charAt(expressionText.length() -1);

                    if(getLastCharacter == '+'  || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '÷'){
                        expression.setText(expressionText.substring(0,expressionText.length() -1)+ "÷");
                    }
                    else{
                        expression.setText(expressionText+"÷");
                    }
                }
            }
        });

        OneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '1');
            }
        });

        TwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '2');
            }

        });

        ThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '3');
            }
        });

        FourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '4');
            }
        });

        FiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '5');
            }
        });

        SixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '6');
            }
        });

        SevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '7');
            }
        });

        EightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '8');
            }
        });

        NineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '9');
            }
        });

        ZeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '0');

            }
        });

        DotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String expressionText = expression.getText().toString();
                expression.setText(expressionText + '.');
            }
        });



    }
private void  calculateResult(TextView expression,  TextView resultHOlder, String expressionText) {

        String expressionText2 = expressionText;

        while (true){

            if(CURRENT_RULE == 2 && !expressionText2.contains("+")){
                CURRENT_RULE++;
                continue;
            }
            else if(CURRENT_RULE != 2 && !expressionText2.contains(BODMAS_RULE[CURRENT_RULE])){
                if(CURRENT_RULE == 3){
                    break;
                }
                else {
                    CURRENT_RULE ++;
                    continue;
                }
            }
            String[] expressionArray = expressionText2.split(BODMAS_RULE[CURRENT_RULE]);

            if(expressionArray.length == 1 || expressionArray[0].isEmpty()){
                break;
            }
            StringBuilder firstValue = new StringBuilder();
            StringBuilder secondValue = new StringBuilder();

            for(int i= expressionArray[0].length() -1 ;  i>=0 ; i--) {
                if(expressionArray[0].charAt(i) == '+' || expressionArray[0].charAt(i) =='-' || expressionArray[0].charAt(i) == '÷' || expressionArray[0].charAt(i) == '×'){
                    break;
                }
                else{
                    firstValue.insert(0, expressionArray[0].charAt(i));
                }
            }
            for(int i = 0;i<expressionArray[1].length();i++) {
                if (expressionArray[1].charAt(i) == '+' || expressionArray[1].charAt(i) == '-' || expressionArray[1].charAt(i) == '÷' || expressionArray[1].charAt(i) == '×') {
                    break;
                } else {
                    secondValue.append(expressionArray[1].charAt(i));
                }
            }
            double results;

            switch (BODMAS_RULE[CURRENT_RULE]) {
                case"÷" :
                    results = Double.parseDouble(firstValue.toString())/ Double.parseDouble(secondValue.toString());
                    break;

                case "×" :
                    results = Double.parseDouble(firstValue.toString())* Double.parseDouble(secondValue.toString());

                case"+" :
                case"\\+":
                    results = Double.parseDouble(firstValue.toString()) + Double.parseDouble(secondValue.toString());
                    break;

                case"-" :
                    results = Double.parseDouble(firstValue.toString()) - Double.parseDouble(secondValue.toString());
                    break;

                default:
                    results = 0;
            }

            expressionText2 = expressionText2.replaceFirst(firstValue + BODMAS_RULE[CURRENT_RULE] + secondValue, String.valueOf(results));
        }
        CURRENT_RULE = 0;

        resultHOlder.setText(expressionText);

        String [] finalResultArray = expressionText2.split("\\.");

        if(finalResultArray[1].length() == 1 && finalResultArray[1].equals("0")) {
            expression.setText(finalResultArray[0]);
        } else {
            expression.setText(expressionText2);

        }
    }
}