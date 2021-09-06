package com.example.triangleapp;
//class EditText(val mEditText1: String, val EditText2: String, val EditText3: String)
//class TextView(val mTextViewResult: String)

//val mEditText1 = "string"
//val mEditText2 = "string"
//val mEditText3 = "string"

//val TextView = "string"
//val mTextViewResult = "string"
//val num1_int = "string"
//val num2_int = "string"
//val num3_int = "string"

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //class EditText(val mEditText1: String, val EditText2: String, val EditText3: String)
    private var mEditText1 = (EditText(findViewById(R.id.num1)));
    private var mEditText2 = (EditText(findViewById(R.id.num2)));
    private var mEditText3 = (EditText(findViewById(R.id.num3)));
    private var num1_int = 1;
    private var num2_int = 1;
    private var num3_int = 1;
    private var mTextViewResult = TextView(findViewById(R.id.Result))




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        //mEditText1 = (EditText(findViewById(R.id.num1)));
        //mEditText2 = (EditText)findViewById (R.id.num2)
        //mEditText3 = (EditText)findViewById(R.id.num3)

        num1_int = Integer.parseInt(mEditText1.getText().toString());
        num2_int = Integer.parseInt(mEditText2.getText().toString());
        num3_int = Integer.parseInt(mEditText3.getText().toString());

        if (((num1_int == num2_int) || (num1_int == num3_int) || (num2_int == num3_int)) &&
            ((num1_int != num2_int) || (num1_int != num3_int) || (num2_int != num3_int))){
                    mTextViewResult.text = "This triangle is isosceles."
        } else {
            mTextViewResult.text = "This triangle is NOT isosceles."
        }


    }
}