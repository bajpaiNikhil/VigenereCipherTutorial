package com.example.vigenereciphertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var cipherText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plaintext = findViewById<EditText>(R.id.plainText)
        val secretKey = findViewById<EditText>(R.id.secretKeyEt)
        val generateButton  = findViewById<Button>(R.id.generat_button)
        val cipherTv = findViewById<TextView>(R.id.cipherTextTV)

        generateButton.setOnClickListener {
            cipherText = VigenereCipherObject.vigenereCipherEncryption(plaintext.text.toString(),secretKey.text.toString())
            cipherTv.text = cipherText

            Log.d("MainActivity" , "This is the result of vigenereEncryption $cipherText")
        }


        val plainText = VigenereCipherObject.vigenereCipherDecryption(cipherText , "Secret")
        Log.d("MainActivity" , "This is the result of vigenereDecryption $plainText")

    }
}