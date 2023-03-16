package lt.justinas.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView: TextView = findViewById(R.id.myTextView)
        Log.i("myTag", "onCreate: ${myTextView.text}")

        lifecycleScope.launch{
            myTextView.text = getString(R.string.sayHello)
            Log.i("myTag", "onCreate: Changed text to ${myTextView.text}")

            delay(5000)
            myTextView.text = getString(R.string.secondMessage)
            Log.i("myTag", "onCreate: Waited 5 seconds and changed text to ${myTextView.text}")

        }

    }

}