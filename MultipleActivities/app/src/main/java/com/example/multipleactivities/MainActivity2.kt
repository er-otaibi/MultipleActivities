package com.example.multipleactivities

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView

    lateinit var button: Button
    var name = ""
    var location = ""
    var phone = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        title = "Activity 2"

        textView=findViewById(R.id.textView)
        textView2=findViewById(R.id.textView2)
        textView3=findViewById(R.id.textView3)

        button=findViewById(R.id.button)

        val intent = intent
        name = intent.getStringExtra("myName").toString()
        location = intent.getStringExtra("myLocation").toString()
        phone = intent.getStringExtra("myPhone").toString()
        textView.text = name
        textView2.text = location
        textView3.text = phone

        button.setOnClickListener {  funAlert() }
    }

    private fun funAlert() {
        val builder = AlertDialog.Builder(this)

        val view = layoutInflater.inflate(R.layout.alert_dialog, null)

        builder.setView(view)


        val confirm = view.findViewById<Button>(R.id.confirm)
        val tv1 = view.findViewById<TextView>(R.id.tvDialog1)
        val tv2= view.findViewById<TextView>(R.id.tvDialog2)
        val tv3 = view.findViewById<TextView>(R.id.tvDialog3)

        tv1.text = name
        tv2.text = location
        tv3.text = phone


        builder.create().show()

        confirm.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("name", tv1.text.toString())
            intent.putExtra("location", tv2.text.toString())
            intent.putExtra("phone",tv3.text.toString())
            startActivity(intent)
        })


        builder.setNegativeButton("Close"){_, _ ->}
    }
}