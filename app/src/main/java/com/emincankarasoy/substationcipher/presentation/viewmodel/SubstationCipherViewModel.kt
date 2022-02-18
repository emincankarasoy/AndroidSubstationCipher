package com.emincankarasoy.substationcipher.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.nio.charset.Charset
import java.util.*

class SubstationCipherViewModel: ViewModel() {

    private val charset: Array<Char> by lazy { arrayOf('A','B','C','Ç','D','E','F','G','Ğ','H','I','İ','J','K','L','M','N','O','Ö','P','R','S','Ş','T','U','Ü','V','Y','Z') }

    private val _encryptedText = MutableLiveData<String>()

    val encryptedText:LiveData<String> = _encryptedText

    private val _decryptedText = MutableLiveData<String>()

    val decryptedText:LiveData<String> = _decryptedText

    fun encryptText(text:String){
        val charArray = text.toCharArray()
        var encryptedText:String = ""
        charArray.forEach { char ->
            val idx = charset.indexOf(char.uppercaseChar())
            encryptedText += when(idx){
                26 -> charset[0]
                27 -> charset[1]
                28 -> charset[2]
                else -> charset[idx+3]
            }
        }
        Log.e("Text",text)
        Log.e("Encrypted Text",encryptedText)
        _encryptedText.postValue(encryptedText.uppercase())
    }

    fun decryptText(text:String){
        val charArray = text.toCharArray()
        var decryptedText:String = ""
        charArray.forEach { char ->
            val idx = charset.indexOf(char.uppercaseChar())
            decryptedText += when(idx){
                2 -> charset[28]
                1 -> charset[27]
                0 -> charset[26]
                else -> charset[idx-3]
            }
        }
        Log.e("Text",text)
        Log.e("Decrypted Text",decryptedText)
        _decryptedText.postValue(decryptedText.uppercase())

    }
}