package com.eren.kdvcalculate

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eren.kdvcalculate.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { calculateKDV() }
    }


    @SuppressLint("SetTextI18n")
    fun calculateKDV() {
        val amount = binding.amount.text.toString()
        val result = amount.toDoubleOrNull()
        val selectedButton = binding.radioGroup.checkedRadioButtonId
        if (amount.isEmpty()) {
            Toast.makeText(this, "Tutar Boş Bırakılamaz!", Toast.LENGTH_SHORT).show()
            return
        }
        val kdvPercentage = when (selectedButton) {
            R.id.one_percent_radio_button -> 0.01
            R.id.eight_percent_radio_button -> 0.08
            else -> 0.18
        }
        val result2 = kdvPercentage * result!!
        if(binding.button.isClickable){
            binding.textView6.text = ""
        }
        binding.textView6.text = "${binding.textView6.text}" + " $result2"


    }
}
