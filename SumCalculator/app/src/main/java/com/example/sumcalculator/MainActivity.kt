package com.example.sumcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    // clicked number, like 55
    private var expression : String = ""

    fun numberInput(view: View) {
        expression += (view as Button).text.toString()

        // append a new string to textView
        resultTextView.text = expression
    }

    fun results(view: View) {
        val e = Expression(expression)
        resultTextView.text = e.expressionString + '=' + e.calculate()
    }

    fun clear(view: View) {
        expression = ""
        resultTextView.text = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView.text = expression
    }
}
