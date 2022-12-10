package com.example.assessment2creativecalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pop_window.*
import kotlinx.android.synthetic.main.pop_window.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //list for spinners
    val elemList1 = arrayOf("Sodium","Oxygen","Carbon")
    val elemList2 = arrayOf("Chloride","Hydrogen","Helium")

    //adapter grp
    val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, elemList1)
    val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, elemList2)
    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)
    //btn grp
    var combine_btn = findViewById<Button>(R.id.combine_btn)

    //spinner grp
    //first
    element1.adapter=adapter1
    element1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(element1.selectedItemPosition==0){
                textview1.text = " "+ element1.selectedItem
            }
            if(element1.selectedItemPosition==1){
                textview1.text = " "+element1.selectedItem
            }
        }
    }
    //second
        element2.adapter=adapter2
        element2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(element2.selectedItemPosition==0){
                    textview2.text = " "+ element2.selectedItem
                }
                if(element2.selectedItemPosition==1){
                    textview2.text = " "+element2.selectedItem
                }
            }
        }
        /*Note
        * Element1.... 0 == Sodium, 1 == Oxygen, 2 == Carbon
        * Element2.... 0 == Chloride, 1 == Hydrogen, 2 == Helium*/
    combine_btn.setOnClickListener{
        if(element1.selectedItemPosition==0 && element2.selectedItemPosition ==0){
            textview3.text="Sodium Chloride "
        }
        else if(element1.selectedItemPosition==0 && element2.selectedItemPosition ==1){
            textview3.text="Sodium Sodium Hydride "
        }
        else if(element1.selectedItemPosition==0 && element2.selectedItemPosition == 2){
            textview3.text = "Sodium Carbonate"
        }
        else if(element1.selectedItemPosition==1 && element2.selectedItemPosition == 0){
            textview3.text = "Oxygen dichloride"
        }
        else if(element1.selectedItemPosition==1 && element2.selectedItemPosition == 1){
            textview3.text = "Dihydrogen monoxide"
        }
        else if(element1.selectedItemPosition==1 && element2.selectedItemPosition == 2){
            textview3.text = "Heliox"
        }
        else if(element1.selectedItemPosition==2 && element2.selectedItemPosition == 0){
            textview3.text = "Carbon tetrachloride"
        }
        else if(element1.selectedItemPosition==2 && element2.selectedItemPosition == 1){
            textview3.text = "Hydrocarbon"
        }
        else if(element1.selectedItemPosition==2 && element2.selectedItemPosition == 2){
            textview3.text = "Oxygen"
        }
    }
    }

    //Menu bar grp
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
                //popup window
            R.id.About_Us -> {
                //inflate the dialog
                val mDialogView = LayoutInflater.from(this).inflate(R.layout.pop_window,null)
                //alert dialog builder
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                //show popup window or dialog
                val mAlertDialog = mBuilder.show()
                //close btn
                mDialogView.close_btn.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}