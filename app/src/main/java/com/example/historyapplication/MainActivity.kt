import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.historyapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var ageEditText: EditText
    private lateinit var matchButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageEditText = findViewById(R.id.ageEditText)
        matchButton = findViewById(R.id.matchButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)

        matchButton.setOnClickListener {
            handleMatchButtonClick()
        }


        }
    }

    private fun handleMatchButtonClick() {
        val ageInput = ageEditText.text.toString()
        if (ageInput.isEmpty()) {
            resultTextView.text = "Please enter your age."
            return
        }

        val age = ageInput.toIntOrNull()
        if (age == null) {
            resultTextView.text = "The age is an invalid format. Please enter a valid whole number."
            return
        }

        if (age < 20 || age > 100) {
            resultTextView.text = "The age is out of range. Please enter an age between 20 and 100."
            return
        }

        val matchedPerson = matchAgeToHistoricalFigure(age)
        resultTextView.text = matchedPerson
    }

    private fun matchAgeToHistoricalFigure(age: Int): String {
        val historicalFigures = mapOf(
            "Jeanne Calment" to 122,
            "Leonardo da Vinci" to 67,
            "Mozart" to 35,
            "Anne Frank" to 5,
            "Lady Jane Grey" to 16,
            "Joan of Arc" to 19,
            "Buddy Holly" to 22,
            "River Pheonix" to 23,
            "James Dean" to 24,
            "Janis Joplin" to 27,
            " Heath Ledger" to 28,
            " Bruce Lee " to 32,
            " Wolfgang Amadeus Mozart" to 35,
            " Marilyn Monroe" to 36,
            " Robert Burns" to 37,
            "Dylan Thomas " to 39,
            "John Lennon" to 40,
            "Elvis Presley" to 42,
            "Oscar Wilde" to 46,
            "Horatio Nelson" to 47,
            "Whitney Houston" to 48,
            "Michael Jackson" to 51,
            "William Shakespeare" to 52,
            "King Henry VIII" to 55,
            "Adolf Hitler" to 56,
            "Charles Dickens " to 58,
            "Diego Maradona" to 60,
            "Queen Elizabeth I " to 69,
            "John Wayne" to 72,
            "Queen Elizabeth II" to 96

            // Add more historical figures and their ages here
        )

        for ((person, personAge) in historicalFigures) {
            if (age == personAge) {
                return "You share the same age with $person when they passed away."
            }
        }

        return "No historical figure found with the same age at death."
    }

    private fun handleClearButtonClick() {
        ageEditText.text.clear()
        resultTextView.text = ""
    }
}
