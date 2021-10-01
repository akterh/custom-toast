package com.example.radiobuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val placeOrder = findViewById<Button>(R.id.btnPlaceOrder)
        val radioOptions = findViewById<RadioGroup>(R.id.radioGroup)
        val cancel = findViewById<Button>(R.id.btnCancel)
        val toast = findViewById<ConstraintLayout>(R.id.cancelToast)


        val outputString = findViewById<TextView>(R.id.tvOutput)

        placeOrder.setOnClickListener {
            val cb01 = findViewById<CheckBox>(R.id.cbOne)
            val cb02 = findViewById<CheckBox>(R.id.cbTwo)
            val cb03 = findViewById<CheckBox>(R.id.cbThree)
            val cb04 = findViewById<CheckBox>(R.id.cbFour)
            val checkedRadioOptions = radioOptions.checkedRadioButtonId
            val option = findViewById<RadioButton>(checkedRadioOptions)
            val cb1 = cb01.isChecked
            val cb2 = cb02.isChecked
            val cb3 = cb03.isChecked
            val cb4 = cb04.isChecked
            ("your selected Options are\n"+
                    "${option.text}"+
                    (if (cb1)"\n${cb01.text}" else "")+
                    (if (cb2)"\n${cb02.text}" else "")+
                    (if (cb3)"\ncb3" else "")+
                    (if (cb4)"\ncb4" else "")).also { outputString.text = it }



        }
        cancel.setOnClickListener {
            Toast(this).apply {
                duration = Toast.LENGTH_SHORT
                view = layoutInflater.inflate(R.layout.custom_toast,toast)
                show()

            }
        }



    }
}