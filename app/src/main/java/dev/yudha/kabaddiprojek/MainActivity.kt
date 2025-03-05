package dev.yudha.kabaddiprojek

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var scoreA: TextView
    private lateinit var scoreB: TextView

    val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inisialisasi variabel
        scoreA = findViewById(R.id.scoreTeamA)
        scoreB = findViewById(R.id.scoreTeamB)


        val scoreTeamA: TextView = findViewById(R.id.scoreTeamA)
        scoreTeamA.text=viewModel.scoreA.toString()
        val scoreTeamB: TextView = findViewById(R.id.scoreTeamB)
        scoreTeamB.text=viewModel.scoreB.toString()

        val btnAdd1TeamA: Button = findViewById(R.id.btnAdd1TeamA)
        val btnAdd2TeamA: Button = findViewById(R.id.btnAdd2TeamA)
        val btnAdd1TeamB: Button = findViewById(R.id.btnAdd1TeamB)
        val btnAdd2TeamB: Button = findViewById(R.id.btnAdd2TeamB)
        val btnReset: Button = findViewById(R.id.btnReset)



        btnAdd1TeamA.setOnClickListener {
//            scoreA += 1
//            scoreTeamA.text = scoreA.toString()
            incrementscoreTeamA()
        }

        btnAdd2TeamA.setOnClickListener {
//            scoreA += 2
//            scoreTeamA.text = scoreA.toString()
            incrementscoreTeamA()
            incrementscoreTeamA()
        }

        btnAdd1TeamB.setOnClickListener {
//            scoreB += 1
//            scoreTeamB.text = scoreB.toString()
            incrementscoreTeamB()
        }

        btnAdd2TeamB.setOnClickListener {
//            scoreB += 2
//            scoreTeamB.text = scoreB.toString()
            incrementscoreTeamB()
            incrementscoreTeamB()
        }

        btnReset.setOnClickListener {
//            scoreA = 0
//            scoreB = 0
//            scoreTeamA.text = scoreA.toString()
//            scoreTeamB.text = scoreB.toString()
            resetscore()
        }
    }

    fun incrementscoreTeamA(){
        viewModel.incrementScoreA()
        scoreA.text=viewModel.scoreA.toString()
    }

    fun incrementscoreTeamB(){
        viewModel.incrementScoreB()
        scoreB.text=viewModel.scoreB.toString()
    }

    fun resetscore(){
        viewModel.resetScore()
        scoreA.text=viewModel.scoreA.toString()
        scoreB.text=viewModel.scoreB.toString()
    }
}
