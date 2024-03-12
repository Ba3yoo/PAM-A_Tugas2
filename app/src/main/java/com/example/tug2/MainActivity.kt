package com.example.tug2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tug2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var radioButton : RadioButton
    lateinit var dropValue : String
    lateinit var checked : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ArrayAdapter.createFromResource(
            this,
            R.array.age_ranges,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.ageDrop.adapter = adapter
        }

        val items= resources.getStringArray(R.array.age_ranges)

        binding.ageDrop.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                dropValue = parent!!.getItemAtPosition(position).toString()
                if(dropValue == items[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        val nameString = binding.nameInput.text.toString()
//        radioButton = findViewById(checked)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedID ->
            if (checkedID == R.id.radioM)
                checked = "Male"
            if (checkedID == R.id.radioF)
                checked = "Feale"
            if (checkedID == R.id.radioN)
                checked = "Unspecified"
        }

        binding.nextButton.setOnClickListener {
            val intnt = Intent(this, SecondActivity::class.java)
            val bund = Bundle()
            bund.putString("NAME", nameString)
            bund.putString("RADIO", checked)
            bund.putString("DROP", dropValue)
            intnt.putExtras(bund)
            startActivity(intnt)
        }
    }
}