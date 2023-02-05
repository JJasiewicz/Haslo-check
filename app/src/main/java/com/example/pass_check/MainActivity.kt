package com.example.pass_check

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputA = findViewById<TextInputEditText>(R.id.pass)
        val inputB = findViewById<TextInputEditText>(R.id.pass_chk)
        val button = findViewById<Button>(R.id.button)
        val passchk = findViewById<CheckedTextView>(R.id.passwordcheck)
        val capital = findViewById<CheckedTextView>(R.id.capitalcheck)
        val small = findViewById<CheckedTextView>(R.id.smallcheck)
        val number = findViewById<CheckedTextView>(R.id.numbercheck)
        val special = findViewById<CheckedTextView>(R.id.specialcheck)

        button.setOnClickListener {
            val a = inputA.text.toString()
            val b = inputB.text.toString()

            if (a.isEmpty() || b.isEmpty()) {
                inputA.error = "Pole nie może być puste"
                inputB.error = "Pole nie może być puste"
                return@setOnClickListener
            }

            if(a == b && a.any { it.isUpperCase() } && a.any { it.isLowerCase() } && a.any { it.isDigit() } && a.any { !it.isLetterOrDigit() }){
                passchk.setCheckMarkDrawable(R.drawable.checked)
                capital.setCheckMarkDrawable(R.drawable.checked)
                small.setCheckMarkDrawable(R.drawable.checked)
                number.setCheckMarkDrawable(R.drawable.checked)
                special.setCheckMarkDrawable(R.drawable.checked)

                val builder = android.app.AlertDialog.Builder(this)
                builder.setTitle("Wszystko jest prawidłowo")
                builder.setPositiveButton("OK", null)
                builder.show()
            }  else {
            val builder = android.app.AlertDialog.Builder(this)
            builder.setTitle("Nie spełniono wymagań")
            builder.setPositiveButton("OK", null)
            builder.show()
            }
        }
    }
}