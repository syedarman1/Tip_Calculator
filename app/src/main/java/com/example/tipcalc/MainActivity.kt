package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val billAmountEditText: EditText = findViewById(R.id.username)
        val tipPercentageEditText: EditText = findViewById(R.id.tipPercentageEditText)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val billAmount = billAmountEditText.text.toString().toDoubleOrNull()
        val tipPercentage = tipPercentageEditText.text.toString().toDoubleOrNull()
        if (billAmount != null && tipPercentage != null) {
            val tipAmount = billAmount * (tipPercentage / 100)
            val totalAmount = billAmount + tipAmount
            resultTextView.text = "Tip: $%.2f, Total: $%.2f".format(tipAmount, totalAmount)
        } else {
            resultTextView.text = "Please enter a valid bill amount and tip percentage."
        }
    }
}
