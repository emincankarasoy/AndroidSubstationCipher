package com.emincankarasoy.substationcipher.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.emincankarasoy.substationcipher.R
import com.emincankarasoy.substationcipher.databinding.ActivityMainBinding
import com.emincankarasoy.substationcipher.presentation.viewmodel.SubstationCipherViewModel

class MainActivity:AppCompatActivity(){

    private lateinit var binding:ActivityMainBinding

    private val viewModel by lazy{
        ViewModelProviders.of(this).get(SubstationCipherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setClickForView()
    }

    private fun setClickForView(){
        binding.encryptTextButton.setOnClickListener {
            if (binding.encryptTextView.text.isNotEmpty())
                viewModel.encryptText(binding.encryptTextView.text.toString())
            else
                Toast.makeText(applicationContext,"Lütfen Metni Giriniz!",Toast.LENGTH_LONG).show()
        }
        binding.decryptTextButton.setOnClickListener {
            if (binding.decryptTextView.text.isNotEmpty())
                viewModel.decryptText(binding.decryptTextView.text.toString())
            else
                Toast.makeText(applicationContext,"Lütfen Metni Giriniz!",Toast.LENGTH_LONG).show()
        }
    }

}