package com.example.tweeklabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tweeklabs.adapters.AthleteSessionsAdapter


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
    private lateinit var totalSessions: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athlete_page)

        bowlerName = findViewById(R.id.tv_bowler_name)
        bowlerType = findViewById(R.id.tv_bowler_type)
        totalBallsBowled = findViewById(R.id.tv_count_balls)
        totalSessions = findViewById(R.id.tv_count_sessions)

        // Dummy Data Created
        val session1 = AthleteSession(1, 65, 124.04, "13/03/2023, 10:24AM")
        val session2 = AthleteSession(2, 98, 135.20, "14/03/2023, 05:35PM")
        val session3 = AthleteSession(3, 65, 124.04, "17/03/2023, 07:44PM")
        val session4 = AthleteSession(4, 165, 100.56, "18/03/2023, 12:23PM")
        val session5 = AthleteSession(5, 158, 111.56, "19/03/2023, 08:55PM")
        val session6 = AthleteSession(6, 33, 125.39, "20/03/2023, 01:05PM")
        val listOfSessions = listOf(session1, session2, session3, session4, session5, session6)

        var totalBalls = 0
        for(session in listOfSessions){
            totalBalls += session.ballsBowled
        }
        val noOfSessions = listOfSessions.size

        val personData = PlayerInformation("Atif Quamar", "Medium-Fast", totalBalls, noOfSessions, listOfSessions)

        bowlerName.text = personData.name
        bowlerType.text = personData.bowlerType
        totalBallsBowled.text = personData.totalBallsBowled.toString()
        totalSessions.text = personData.totalSessions.toString()

        val recyclerView = findViewById<RecyclerView>(R.id.sessions_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AthleteSessionsAdapter(listOfSessions)
        recyclerView.adapter = adapter


    }
}