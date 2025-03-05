package dev.yudha.kabaddiprojek

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scoreTeamA: TextView = findViewById(R.id.scoreTeamA)
        val scoreTeamB: TextView = findViewById(R.id.scoreTeamB)

        val btnAdd1TeamA: Button = findViewById(R.id.btnAdd1TeamA)
        val btnAdd2TeamA: Button = findViewById(R.id.btnAdd2TeamA)
        val btnAdd1TeamB: Button = findViewById(R.id.btnAdd1TeamB)
        val btnAdd2TeamB: Button = findViewById(R.id.btnAdd2TeamB)
        val btnReset: Button = findViewById(R.id.btnReset)

        btnAdd1TeamA.setOnClickListener {
            scoreA += 1
            scoreTeamA.text = scoreA.toString()
        }

        btnAdd2TeamA.setOnClickListener {
            scoreA += 2
            scoreTeamA.text = scoreA.toString()
        }

        btnAdd1TeamB.setOnClickListener {
            scoreB += 1
            scoreTeamB.text = scoreB.toString()
        }

        btnAdd2TeamB.setOnClickListener {
            scoreB += 2
            scoreTeamB.text = scoreB.toString()
        }

        btnReset.setOnClickListener {
            scoreA = 0
            scoreB = 0
            scoreTeamA.text = scoreA.toString()
            scoreTeamB.text = scoreB.toString()
        }
    }
}
