package com.example.intent

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        buttonSend.setOnClickListener {
            sendMessage()
        }

        buttonCall.setOnClickListener {
            dialPhone()
        }


    }

    private fun dialPhone() {
        val intent = Intent(Intent.ACTION_VIEW)
        val phone: String = "tel:0123456789"

        intent.setData(Uri.parse(phone))
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    private fun sendMessage() {
        //explicit
        val intent = Intent(this,SecondActivity::class.java)
        val message = editTextMessage.text.toString()
        val number = editTextLuckyNumber.text.toString().toInt()
        intent.putExtra(KEY,message)
        intent.putExtra(NUM,number)
        startActivityForResult(intent,REQUEST_CODE)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val reply = data?.getStringExtra(REPLY).toString()
                textViewRepy.text = String.format("%s %s",getString(R.string.reply),reply)
            }
        }
    }

    companion object {
        const val KEY = "com.example.intent.KEY"
        const val NUM = "com.example.intent.NUM"
        const val REPLY = "com.example.intent.REPLY"
        const val REQUEST_CODE = 1
    }

}
