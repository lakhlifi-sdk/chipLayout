package com.lakhlifi.chiplayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.libaml.android.view.chip.ChipLayout

class MainActivity : AppCompatActivity() {
    lateinit var chip: ChipLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ChipLayout.MAX_CHARACTER_COUNT = 20
        this.chip = (findViewById<View>(R.id.chipText) as? ChipLayout)!!




        this.chip.setOnClickListener(View.OnClickListener {
            Log.d(
                "---------------",
                chip.getText().toString()
            )
        })
        chip.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Log.d(
                "---------------",
                "" + i
            )
        })
        chip.addLayoutTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                // Log.d("---------------",editable.toString());
            }
        })
        chip.setOnFocusChangeListener(View.OnFocusChangeListener { view, b ->
            Log.d(
                "----",
                b.toString()
            )
        })
        chip.setOnChipItemChangeListener(object : ChipLayout.ChipItemChangeListener {
            override fun onChipAdded(pos: Int, txt: String) {
                Log.d(txt, pos.toString())
            }

            override fun onChipRemoved(pos: Int, txt: String) {
                Log.d(txt, pos.toString())
            }
        })


        val countries =
            arrayOf("india", "australia", "austria", "indonesia", "canada")
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        chip.setAdapter(adapter)


    }

    fun click(v: View?) {
        Log.d("---------------", chip.text.toString())
    }



}
