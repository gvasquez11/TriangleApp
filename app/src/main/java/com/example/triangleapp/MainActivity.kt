package com.example.triangleapp;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val inputValue = findViewById(R.id.UserInput) as EditText;

        val answer = findViewById(R.id.Result) as TextView;
        val analyzeAnswer = findViewById(R.id.AnalyzeButton) as Button;

        analyzeAnswer.setOnClickListener{

            //val num1_1 = num1.text.toString();
            //val num2_2 = num2.text.toString().toInt();
            //val num3_3 = num3.text.toString().toInt();

            val UserInputString = inputValue.text.toString();
            val UserInputArray = UserInputString.split(',').toTypedArray();


            val num1_1 = UserInputArray[0].toDouble();
            val num2_2 = UserInputArray[1].toDouble();
            val num3_3 = UserInputArray[2].toDouble();



            if(num1_1 != num2_2 && num1_1 != num3_3 && num2_2 != num3_3)
            {
                answer.setText("[" + UserInputString + "] = scalene")
            }
            else if(((num1_1 == num2_2) || (num1_1 == num3_3) || (num2_2 == num3_3)) &&
                ((num1_1 != num2_2) || (num1_1 != num3_3) || (num2_2 != num3_3)))
            {
                answer.setText("[" + UserInputString + "] = isosceles")
            }
            else if ((num3_3 == num1_1) && (num3_3 == num2_2))
            {
                answer.setText("[" + UserInputString + "] = equilateral")
            }
            else
            {
                answer.setText("This Triangle is NOT Scalene, Isosceles, or Equilateral!")
            }

        }


    }
}