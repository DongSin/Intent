package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.MainThread
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(MainActivity.KEY)
        textViewMessage.text = String.format("%s %s",getString(R.string.message),message)

        val number = intent.getIntExtra(MainActivity.NUM,0)
        textView2.text = String.format("%s %d",getString(R.string.number),number)

        buttonDone.setOnClickListener {

            if(!editTextReply.text.isEmpty()) {
                val reply = editTextReply.text.toString()
                val intent = getIntent()//return the activity that create intent
                intent.putExtra(MainActivity.REPLY, reply)

                setResult(Activity.RESULT_OK,intent)

            }else{
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}
