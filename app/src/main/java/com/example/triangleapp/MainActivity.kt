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
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //class EditText(val mEditText1: String, val EditText2: String, val EditText3: String)

    /*
      mEditText1 = (EditText(findViewById(R.id.num1)));

    var mEditText2 = (EditText(findViewById(R.id.num2)));
     var mEditText3 = (EditText(findViewById(R.id.num3)));
    var num1_int = 1;
     var num2_int = 1;
     var num3_int = 1;
    var mTextViewResult = TextView(findViewById(R.id.Result))

*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        val num1 = findViewById(R.id.num1) as EditText;
        val num2 = findViewById(R.id.num2) as EditText;
        val num3 = findViewById(R.id.num3) as EditText;
        val answer = findViewById(R.id.Result) as TextView;
        val analyzeAnswer = findViewById(R.id.AnalyzeButton) as Button;

        analyzeAnswer.setOnClickListener{

            val num1_1 = num1.text.toString().toInt();
            val num2_2 = num2.text.toString().toInt();
            val num3_3 = num3.text.toString().toInt();

            val resultScaling = "string";

            if(num1_1 != num2_2 && num1_1 != num3_3 && num2_2 != num3_3)
            {
                answer.setText("This Triangle is Scaling!")
            }
            else
            {
                answer.setText("This Triangle is NOT Scaling!")
            }

        }

        //mEditText1 = (EditText(findViewById(R.id.num1)));
        //mEditText2 = (EditText)findViewById (R.id.num2)
        //mEditText3 = (EditText)findViewById(R.id.num3)

        /*
        num1_int = Integer.parseInt(mEditText1.getText().toString());
        num2_int = Integer.parseInt(mEditText2.getText().toString());
        num3_int = Integer.parseInt(mEditText3.getText().toString());

        if (((num1_int == num2_int) || (num1_int == num3_int) || (num2_int == num3_int)) &&
            ((num1_int != num2_int) || (num1_int != num3_int) || (num2_int != num3_int))){
                    mTextViewResult.text = "This triangle is isosceles."
        } else {
            mTextViewResult.text = "This triangle is NOT isosceles."
        }
        */

    }
}