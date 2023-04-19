package com.example.tweeklabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class AthleteSession(
    val sessionId: Int,
    val ballsBowled: Int,
    val averageSpeed: Double,
    val time: String
)
class PlayerInformation(
    val name: String,
    val bowlerType: String,
    val totalBallsBowled: Int,
    val totalSessions: Int,
    val allSessions: List<AthleteSession>
)


class AthletePageActivity : AppCompatActivity() {

    private lateinit var bowlerName: TextView
    private lateinit var bowlerType: TextView
    private lateinit var totalBallsBowled: TextView
    private lateinit var countSessions: TextView
    private lateinit var sessionBallsCount: TextView
    private lateinit var sessionAverageSpeed: TextView
    private lateinit var sessionTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athlete_page)

        bowlerName = findViewById(R.id.tv_bowler_name)
        bowlerType = findViewById(R.id.tv_bowler_type)
        totalBallsBowled = findViewById(R.id.tv_count_balls)
        countSessions = findViewById(R.id.tv_count_sessions)
        sessionBallsCount = findViewById(R.id.tv_value_balls_count)
        sessionAverageSpeed = findViewById(R.id.tv_value_av_speed)
        sessionTime = findViewById(R.id.tv_value_date)

        // Dummy Data Created
        val session1 = AthleteSession(1, 65, 124.04, "13/03/2023, 10:24AM")
        val listOfSessions = listOf(session1)
        val personData = PlayerInformation("Atif Quamar", "Medium-Fast", 650, 14, listOfSessions)

        bowlerName.text = personData.name
        bowlerType.text = personData.bowlerType
        totalBallsBowled.text = personData.totalBallsBowled.toString()
        countSessions.text = personData.totalSessions.toString()


    }
}