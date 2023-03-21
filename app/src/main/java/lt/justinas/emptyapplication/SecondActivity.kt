package lt.justinas.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("message_key")
        val secondTextView: TextView = findViewById(R.id.secondTextView)
        val secondButton: Button = findViewById(R.id.secondButton)

        secondTextView.text = getString(R.string.secondActivityText) + "\n" + message
        secondButton.text = getString(R.string.secondButtonText)

        secondButton.setOnClickListener {
            finish()
        }

    }
}