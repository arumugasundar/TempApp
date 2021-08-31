package com.example.tempapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun convertTemp(v: View){

        val resultTextView = findViewById<TextView>(R.id.result)
        resultTextView.text = ""

        val fahrenheitEditText = findViewById<EditText>(R.id.fahrenheit)
        fahrenheitEditText.onEditorAction(EditorInfo.IME_ACTION_DONE)
        val inputFahrenheitString = fahrenheitEditText.text.toString()

        val celsiusEditText = findViewById<EditText>(R.id.celsius)
        celsiusEditText.onEditorAction(EditorInfo.IME_ACTION_DONE)
        val inputCelsiusString = celsiusEditText.text.toString()

        if(inputFahrenheitString.trim() != ""){
            val inputFahrenheitFloat = inputFahrenheitString.toFloat()
            var result = (inputFahrenheitFloat-32)*(5/9.0)
            result = String.format("%.2f", result).toDouble()
            Toast(this).showCustomToast (
                "Celsius Equivalent of  $inputFahrenheitFloat F is : $result",
                this
            )
            //val messageText = Toast.makeText(applicationContext, "Celsius Equivalent of  $inputFahrenheitFloat F is : $result",Toast.LENGTH_LONG)
            //messageText.show()
            resultTextView.append("\nCelsius Equivalent of $inputFahrenheitFloat F is : $result")
        }

        if(inputCelsiusString.trim() != ""){
            val inputCelsiusFloat = inputCelsiusString.toFloat()
            var result = inputCelsiusFloat*(9/5.0) + 32
            result = String.format("%.2f", result).toDouble()
            Toast(this).showCustomToast (
                "Fahrenheit Equivalent of $inputCelsiusFloat C is : $result",
                this
            )
            //val messageText = Toast.makeText(applicationContext, "Fahrenheit Equivalent of $inputCelsiusFloat C is : $result",Toast.LENGTH_LONG)
            //messageText.show()
            resultTextView.append("\nFahrenheit Equivalent of $inputCelsiusFloat C is : $result")
        }
    }
}