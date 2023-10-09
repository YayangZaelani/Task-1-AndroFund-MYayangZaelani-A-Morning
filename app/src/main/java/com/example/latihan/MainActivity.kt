package com.example.latihan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    private lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $username dan Password: $password"

        val btnImplicit: Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)

        val btnLogout: Button = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_implicit -> {
//                val massage = "Hallo"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, massage)
//                intent.type = "text/plain"
//                startActivities(arrayOf(intent))

                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent)
                finish()
            }
        }

        when(v.id){
            R.id.btn_logout -> {

                val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivities(arrayOf(intent))
            }

        }
    }

}