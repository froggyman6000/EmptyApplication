package lt.justinas.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView: TextView = findViewById(R.id.myTextView)
        val openButton: Button = findViewById(R.id.buttonOpen)
        Log.i("myTag", "onCreate: ${myTextView.text}")
        openButton.isVisible = false // instead of this we can use openButton.visibility = View.INVISIBLE

        lifecycleScope.launch{
            myTextView.text = getString(R.string.sayHello)
            Log.i("myTag", "onCreate: Changed text to ${myTextView.text}")

            delay(5000)

            myTextView.text = getString(R.string.secondMessage)
            openButton.isVisible = true
            Log.i("myTag", "onCreate: Waited 5 seconds and changed text to ${myTextView.text}, also made the button visible")

        }

    }

}