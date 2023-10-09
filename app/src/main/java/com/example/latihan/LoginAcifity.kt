package com.example.latihan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginAcifity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var history:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("History")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_acifity)

        history = findViewById(R.id.history)
        etUsername = findViewById(R.id.edit_username)
        etPassword = findViewById(R.id.edit_password)

        val btnLoginAcifity: Button = findViewById(R.id.btn_login)

        btnLoginAcifity.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {

                val intent = Intent(this@LoginAcifity, MainActivity::class.java)
                intent.putExtra("User", User(etUsername.text.toString(),etPassword.text.toString()))
                resultLauncher.launch(intent)
            }

        }        }
    }


