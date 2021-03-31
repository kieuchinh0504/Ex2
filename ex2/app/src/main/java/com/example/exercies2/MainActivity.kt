package com.example.exercies2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var listAdd = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEventSeekBar()
        showPopMenu()
        setEventButton()
    }

    private fun setEventButton() {
        buttonClear.setOnClickListener {
            seekBarOne.setProgress(0)
            seekBarTwo.setProgress(0)
            seekBarThree.setProgress(0)
            Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show()
        }

        buttonFull.setOnClickListener {
            seekBarOne.setProgress(100)
            seekBarTwo.setProgress(100)
            seekBarThree.setProgress(100)
            Toast.makeText(this, "Full", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.show_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                seekBarOne.setProgress(50)
                seekBarTwo.setProgress(50)
                seekBarThree.setProgress(50)
                Toast.makeText(this, "Half", Toast.LENGTH_SHORT).show()
            }
            R.id.item2 -> {
                seekBarOne.setProgress(100)
                seekBarTwo.setProgress(100)
                seekBarThree.setProgress(100)
                Toast.makeText(this, "Max", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showPopMenu() {
        val popup = PopupWindow(this)
        val listView = ListView(this)
        listAdd()
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listAdd)

        listView.setOnItemClickListener { _, _: View, i, _ ->
            when (i) {
                0 -> Toast.makeText(this, "Say Hello", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this, "Hide other buttons", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Show other buttons", Toast.LENGTH_SHORT).show()
            }
            popup.dismiss()
        }
        popup.width = 500
        popup.height = 400
        popup.contentView = listView
        buttonShow.setOnClickListener {
            popup.showAsDropDown(it)
        }
    }

    private fun listAdd() {
        listAdd.add("Say Hello")
        listAdd.add("Hide other buttons")
        listAdd.add("Show other buttons")
    }

    private fun setEventSeekBar() {
        seekBarOne.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewOne.text = "$progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        seekBarTwo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewTwo.text = "$progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarThree.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewThree.text = "$progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

}
