package com.williamjin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvOutput;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot,
            btnPlus, btnMinus, btnMultiple, btnDivide, btnClear, btnResult;
    Button btnPower, btnLog, btnRoot;
    Double preNumber = null;
    Double currentNumber = null;
    Character operator = null;
    boolean cleanText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutPut);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);

        btnPower = findViewById(R.id.btnPower);
        btnRoot = findViewById(R.id.btnRoot);
        btnLog = findViewById(R.id.btnLog);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiple = findViewById(R.id.btnMultiple);
        btnDivide = findViewById(R.id.btnDivide);
        btnResult = findViewById(R.id.btnResult);
        btnClear = findViewById(R.id.btnClear);


        // calculate
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        operator = '+';
                        preNumber = Double.parseDouble(value);
                        cleanText = true;
                        Log.e("plus output", preNumber.toString());
                    } else {
                        operator = '+';
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        tvOutput.setText(Double.toString(preNumber));
                        cleanText = true;
                        currentNumber = null;
                    }
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        operator = '-';
                        preNumber = Double.parseDouble(value);
                        cleanText = true;
                    } else {
                        operator = '-';
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        tvOutput.setText(Double.toString(preNumber));
                        currentNumber = null;
                        cleanText = true;
                    }
                }
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        operator = '*';
                        preNumber = Double.parseDouble(value);
                        cleanText = true;
                    } else {
                        operator = '*';
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        tvOutput.setText(Double.toString(preNumber));
                        cleanText = true;
                    }
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        operator = '%';
                        preNumber = Double.parseDouble(value);
                        cleanText = true;
                    } else {
                        operator = '%';
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        tvOutput.setText(Double.toString(preNumber));
                        cleanText = true;
                    }
                }
            }
        });

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        operator = 'p';
                        preNumber = Double.parseDouble(value);
                        cleanText = true;
                    } else {
                        operator = 'p';
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        tvOutput.setText(Double.toString(preNumber));
                        cleanText = true;
                    }
                }
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    operator = 'l';
                    currentNumber = Double.parseDouble(value);
                    preNumber = calculate(preNumber, currentNumber, operator);
                    tvOutput.setText(Double.toString(preNumber));
                    cleanText = true;
                }
            }
        });

        btnRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    operator = 'r';
                    currentNumber = Double.parseDouble(value);
                    preNumber = calculate(preNumber, currentNumber, operator);
                    tvOutput.setText(Double.toString(preNumber));
                    cleanText = true;
                }
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = tvOutput.getText().toString();
                if (value.length() == 1 && value.equals(".")) {
                    tvOutput.setText("0");
                    preNumber = null;
                    currentNumber = null;
                } else {
                    if (preNumber == null) {
                        return;
                    } else if (operator != null) {
                        currentNumber = Double.parseDouble(value);
                        preNumber = calculate(preNumber, currentNumber, operator);
                        operator = null;
                        currentNumber = null;
                        tvOutput.setText(Double.toString(preNumber));
                        cleanText = true;
                    } else {
                        tvOutput.setText("");
                    }
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOutput.setText("");
                preNumber = null;
                currentNumber = null;
                operator = null;
            }
        });

        //enter number
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("0");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "0");
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("1");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "1");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("2");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "2");
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("3");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "3");
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("4");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "4");
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("5");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "5");
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("6");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "6");
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("7");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "7");
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("8");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "8");
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText("9");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + "9");
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textValue = tvOutput.getText().toString();
                if (cleanText) {
                    tvOutput.setText(".");
                    cleanText = false;
                } else {
                    tvOutput.setText(textValue + ".");
                }
            }
        });
    }

    private Double calculate(Double num1, Double num2, Character operator) {
        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else if (operator == '%') {
            return num1 / num2;
        } else if (operator == 'p') {
            return Math.pow(num1, num2);
        } else if (operator == 'r') {
            return Math.sqrt(num2);
        } else if (operator == 'l') {
            return Math.log(num2);
        } else {
            return 0.0;
        }
    }
}
