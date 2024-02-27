package com.example.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLogOut = findViewById<Button>(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            val message: String = "Вы уверены что хотите выйти из аккаунта?"
            showConfirmDialog(message)
        }

        val spinner: Spinner = findViewById(R.id.spinner)

        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_items,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedItem: String = parentView?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Выбрано: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {

            }
        }
    }

    fun showConfirmDialog(dialog: String?) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_custom)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)

        val yes: Button = dialog.findViewById(R.id.btnYes)
        val no: Button = dialog.findViewById(R.id.btnNo)

        yes.setOnClickListener {
            Toast.makeText(this, "You clicked Yes", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        no.setOnClickListener {
            Toast.makeText(this, "You clicked No", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}




