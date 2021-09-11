package com.example.triangleapp;

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        // Creation and initialization of Variables and values
        val inputValue = findViewById(R.id.UserInput) as EditText;
        val answer = findViewById(R.id.Result) as TextView;
        val analyzeAnswer = findViewById(R.id.AnalyzeButton) as Button;
        val exitB = findViewById(R.id.button2) as Button;
        var UserInputString: String = " ";
        var UserInputArray = ArrayList<String>();
        var num1_1: Double = 1.0;
        var num2_2: Double = 1.0;
        var num3_3: Double = 1.0;
        var limits: Boolean = true;
        var OutputStr1: String = " ";
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit Confirmation");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int -> finish()})
        builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })

        exitB.setOnClickListener{
            builder.show()
        }

        analyzeAnswer.setOnClickListener {
            answer.setText("")

            if (inputValue.text.toString() == "0") {
                builder.show()
            } else {
                try {
                    UserInputString = inputValue.text.toString();
                    UserInputArray = UserInputString.split(',') as ArrayList<String>;

                } catch (e: ClassCastException) {
                    Toast.makeText(
                        applicationContext,
                        "Invalid input detected, must enter 3 numbers separated by comma.  Example: 15, 23, 27",
                        Toast.LENGTH_LONG
                    ).show();
                }


                try {
                    if (UserInputArray.size > 3) {
                        Toast.makeText(
                            applicationContext,
                            "More than 3 sides detected.  Must enter 3 numbers separated by comma.  Example: 15, 23, 27",
                            Toast.LENGTH_LONG
                        ).show();
                    } else {
                        num1_1 = UserInputArray[0].toDouble();
                        num2_2 = UserInputArray[1].toDouble();
                        num3_3 = UserInputArray[2].toDouble();
                        limits = inLimits(UserInputArray);
                        OutputStr1 =
                            "[" + UserInputArray[0].trim() + ", " + UserInputArray[1].trim() + ", " + UserInputArray[2].trim() + "] = ";
                        if (limits) {
                            if ((num1_1 + num2_2 < num3_3) ||
                                (num1_1 + num3_3 < num2_2) ||
                                (num2_2 + num3_3 < num1_1)
                            ) {
                                Toast.makeText(
                                    applicationContext,
                                    "The three values entered can't make a triangle due to the Triangle Inequality Theorem",
                                    Toast.LENGTH_LONG
                                ).show();

                            } else if (num1_1 != num2_2 && num1_1 != num3_3 && num2_2 != num3_3) {
                                answer.setText(OutputStr1 + "scalene")
                            } else if (((num1_1 == num2_2) || (num1_1 == num3_3) || (num2_2 == num3_3)) &&
                                ((num1_1 != num2_2) || (num1_1 != num3_3) || (num2_2 != num3_3))
                            ) {
                                answer.setText(OutputStr1 + "isosceles")
                            } else if ((num3_3 == num1_1) && (num3_3 == num2_2)) {
                                answer.setText(OutputStr1 + "equilateral")
                            } else {
                                answer.setText("If our logic is correct, this error is mathematically impossible to occur.")
                            }
                        }
                    }
                } catch (e: IndexOutOfBoundsException) {
                    if (UserInputArray.size == 1 && UserInputArray[0].toInt() == 0)
                        finish()
                    else if (UserInputArray.size < 3) {
                        Toast.makeText(
                            applicationContext,
                            "Less than 3 sides detected.  Must enter 3 numbers separated by comma.  Example: 15, 23, 27",
                            Toast.LENGTH_LONG
                        ).show();
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        applicationContext,
                        "Number Format Exception, multiple points or missing comma",
                        Toast.LENGTH_LONG
                    ).show();
                }
            }
        }
    }


    fun inLimits (values: List<String>): Boolean {

        for (i in values.indices )
        {
            if(values[i].toDouble() < 1.0){
                Toast.makeText(applicationContext, "Value Out of Range, Must be greater or equal to 1.0", Toast.LENGTH_LONG).show();
                return false;
                break;
            }
            else if (values[i].toDouble() > 100.0)
            {
                Toast.makeText(applicationContext, "Value Out of Range, Must be less than or equal to 100.0", Toast.LENGTH_LONG).show();
                return false;
                break;
            }
        }
        return true;
    }
}