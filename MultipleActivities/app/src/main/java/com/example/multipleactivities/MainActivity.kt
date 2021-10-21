package com.example.multipleactivities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var etlocation: EditText
    lateinit var etphone: EditText
    lateinit var etpassword: EditText
    lateinit var checkBox: CheckBox
    lateinit var submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Activity 1"

        etname = findViewById(R.id.etname)
        etlocation = findViewById(R.id.etlocation)
        etphone = findViewById(R.id.etphone)
        etpassword = findViewById(R.id.etpassword)
        checkBox = findViewById(R.id.checkBox)
        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            if (notEmpty()){
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("myName", etname.text.toString() )
                intent.putExtra("myLocation", etlocation.text.toString() )
                intent.putExtra("myPhone", etphone.text.toString() )
                startActivity(intent)
            }else{
                customAlert()
            }

        }
    }

    private fun notEmpty() : Boolean {

        return (etname.text.isNotEmpty() && etlocation.text.isNotEmpty()
                && etphone.text.isNotEmpty() && etpassword.text.isNotEmpty()
                && checkBox.isChecked)
    }

    private fun customAlert(){

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Please agree on terms and conditions")

            .setPositiveButton("ok", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("Alert")
        alert.show()
    }
}