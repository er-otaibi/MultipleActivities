package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        title = "Activity 3"

        val intent = intent
        var name = intent.getStringExtra("name").toString()
        var location = intent.getStringExtra("location").toString()
        var phone = intent.getStringExtra("phone").toString()
        var list = arrayListOf<Contact>()

        list.add(Contact(name,location,phone))

        var rvMain =findViewById<RecyclerView>(R.id.rvMain)
        rvMain.adapter = RVAdapter(list)
        rvMain.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.home -> { val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.exit-> {
                finishAffinity()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }

}
data class Contact(val name: String, val location: String,val phone: String)