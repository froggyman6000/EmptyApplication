package lt.justinas.emptyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "myMessages"
        val myTextView: TextView = findViewById(R.id.myTextView)
        val openButton: Button = findViewById(R.id.buttonOpen)
        val mainEditText: EditText = findViewById(R.id.mainEditText)
        Log.i(TAG, "onCreate: ${myTextView.text}")
        openButton.isVisible = false // instead of this we can use openButton.visibility = View.INVISIBLE

        lifecycleScope.launch{
            myTextView.text = getString(R.string.sayHello)
            Log.i(TAG, "onCreate: Changed text to ${myTextView.text}")

            delay(5000)

            myTextView.text = getString(R.string.secondMessage)
            openButton.isVisible = true
            Log.i(TAG, "onCreate: Waited 5 seconds and changed text to ${myTextView.text}, also made the button visible")

        }

        openButton.setOnClickListener {
            Log.i(TAG, "onCreate: openButton was clicked")
            val openIntent: Intent = Intent(this, SecondActivity::class.java)
            startActivity(openIntent)
        }
    }

}