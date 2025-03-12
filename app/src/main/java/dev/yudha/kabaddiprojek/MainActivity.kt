package dev.yudha.kabaddiprojek

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dev.yudha.kabaddiprojek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var scoreA: TextView
//    private lateinit var scoreB: TextView
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.scoreViewModel = viewModel

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val binding:ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Inisialisasi variabel
//        scoreA = findViewById(R.id.scoreTeamA)
//        scoreB = findViewById(R.id.scoreTeamB)

        viewModel.scoreA.observe(this, Observer { score ->
            binding.scoreTeamA.text = score.toString()
        })

        viewModel.scoreB.observe(this, Observer { score ->
            binding.scoreTeamB.text = score.toString()
        })
//
//        val scoreTeamA: TextView = findViewById(R.id.scoreTeamA)
//        scoreTeamA.text=viewModel.scoreA.toString()
//        val scoreTeamB: TextView = findViewById(R.id.scoreTeamB)
//        scoreTeamB.text=viewModel.scoreB.toString()

//        val btnAdd1TeamA: Button = findViewById(R.id.btnAdd1TeamA)
//        val btnAdd2TeamA: Button = findViewById(R.id.btnAdd2TeamA)
//        val btnAdd1TeamB: Button = findViewById(R.id.btnAdd1TeamB)
//        val btnAdd2TeamB: Button = findViewById(R.id.btnAdd2TeamB)
//        val btnReset: Button = findViewById(R.id.btnReset)

        binding.btnAdd1TeamA.setOnClickListener {
//            scoreA += 1
//            scoreTeamA.text = scoreA.toString()
            viewModel.incrementScoreA()
        }

        binding.btnAdd2TeamA.setOnClickListener {
//            scoreA += 2
//            scoreTeamA.text = scoreA.toString()
            viewModel.incrementScoreA()
            viewModel.incrementScoreA()
        }

        binding.btnAdd1TeamB.setOnClickListener {
//            scoreB += 1
//            scoreTeamB.text = scoreB.toString()
            viewModel.incrementScoreB()
        }

        binding.btnAdd2TeamB.setOnClickListener {
//            scoreB += 2
//            scoreTeamB.text = scoreB.toString()
            viewModel.incrementScoreB()
            viewModel.incrementScoreB()
        }

        binding.btnReset.setOnClickListener {
//            scoreA = 0
//            scoreB = 0
//            scoreTeamA.text = scoreA.toString()
//            scoreTeamB.text = scoreB.toString()
            viewModel.resetScore()
        }
    }
//    fun incrementscoreTeamA(){
//        viewModel.incrementScoreA()
//        scoreA.text=viewModel.scoreA.toString()
//    }
//    fun incrementscoreTeamB(){
//        viewModel.incrementScoreB()
//        scoreB.text=viewModel.scoreB.toString()
//    }
//    fun resetscore(){
//        viewModel.resetScore()
//        scoreA.text=viewModel.scoreA.toString()
//        scoreB.text=viewModel.scoreB.toString()
//    }
}
