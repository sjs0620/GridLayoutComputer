package com.sjs.edu.gridlayoutcomputer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;
    String num1, num2; Integer result; Double result1;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.btnNUM0,R.id.btnNUM1,R.id.btnNUM2,R.id.btnNUM3,R.id.
            btnNUM4,R.id.btnNUM5,R.id.btnNUM6,R.id.btnNUM7,R.id.btnNUM8,R.id.btnNUM9};
    int i = 0;
    InputMethodManager imm ;

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("그리드 레이아웃 계산기");
        imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        txtResult = (TextView)findViewById(R.id.txtResult);
        for(i=0;  i<numBtnIDs.length; i++)
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);

        for(i=0;  i<numBtnIDs.length; i++) {
            final int index ;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()){
                        imm.hideSoftInputFromWindow(edit1.getWindowToken(),0);

                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused()){
                        imm.hideSoftInputFromWindow(edit1.getWindowToken(),0);
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                    else Toast.makeText(getApplicationContext(),"먼저 입력텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                }
            });
        }
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result1 = Double.parseDouble(num1) / Double.parseDouble(num2);
                txtResult.setText("계산결과: " + result1.toString());
                return false;
            }
        });

    }
}
