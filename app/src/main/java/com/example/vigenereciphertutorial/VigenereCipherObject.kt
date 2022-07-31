package com.example.vigenereciphertutorial

import android.util.Log

object VigenereCipherObject {

    private const val alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun vigenereCipherEncryption(plainText:String , cipherKey : String):String{

        val plainTextUpper = plainText.uppercase()
        val cipherKeyUpper = cipherKey.uppercase()
        var key = 0
        var cipherText = ""

        for(letter in plainTextUpper){
            val indexOfShift = (alphabet.indexOf(letter)+alphabet.indexOf(cipherKeyUpper[key])).mod(alphabet.length)
            Log.d("VigenereCipher" , "This is the shift key $indexOfShift")
            cipherText+= alphabet[indexOfShift]
            key+=1
            if(key>cipherKey.length-1){
                key=0
            }
        }
        return cipherText
    }

    fun vigenereCipherDecryption(cipherText: String ,cipherKey:String ):String{
        val cipherTextUpper = cipherText.uppercase()
        val cipherKeyUpper = cipherKey.uppercase()
        var keyIndex = 0
        var plainText = ""

        for(letter in cipherTextUpper){
            val indexOfShift = (alphabet.indexOf(letter)-alphabet.indexOf(cipherKeyUpper[keyIndex])).mod(alphabet.length)
            Log.d("VigenereCipher" ,"This is decryption key $indexOfShift")
            plainText+= alphabet[indexOfShift]
            keyIndex+=1
            if(keyIndex> cipherKeyUpper.length-1){
                keyIndex=0
            }
        }
        return plainText

    }

}