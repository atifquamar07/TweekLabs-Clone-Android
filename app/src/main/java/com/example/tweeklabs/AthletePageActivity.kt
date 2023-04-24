package com.example.tweeklabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tweeklabs.adapters.AthleteSessionsAdapter

// Class to store date and time variables
class Time(
    val hour: Int,
    val minutes: Int,
    val meridian: String,
    val date: Int,
    val month: Int,
    val year: Int
)

// Class to store information for each of the sessions
class AthleteSession(
    val sessionId: Int,
    val ballsBowled: Int,
    val averageSpeed: Double,
    val time: String
)

// Complete player information
class PlayerInformation(
    val name: String,
    val bowlerType: String,
    val totalBallsBowled: Int,
    val totalSessions: Int,
    // List of athlete sessions, this information is displayed using recycler view
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
        val time1 = Time(5, 35, "PM", 2, 2, 2023)
        val session1 = AthleteSession(1, 65, 124.04, timeBuilder(time1))

        val time2 = Time(6, 8, "PM", 16, 2, 2023)
        val session2 = AthleteSession(2, 98, 135.20, timeBuilder(time2))

        val time3 = Time(8, 24, "AM", 24, 2, 2023)
        val session3 = AthleteSession(3, 65, 124.04, timeBuilder(time3))

        val time4 = Time(7, 5, "AM", 2, 3, 2023)
        val session4 = AthleteSession(4, 165, 100.56, timeBuilder(time4))

        val time5 = Time(8, 55, "PM", 8, 3, 2023)
        val session5 = AthleteSession(5, 158, 111.56, timeBuilder(time5))

        val time6 = Time(10, 35, "AM", 14, 3, 2023)
        val session6 = AthleteSession(6, 33, 125.39, timeBuilder(time6))

        val listOfSessions = listOf(session1, session2, session3, session4, session5, session6)

        // Number of sessions
        val noOfSessions = listOfSessions.size

        // Counting total balls bowled
        var totalBalls = 0
        for(session in listOfSessions){
            totalBalls += session.ballsBowled
        }

        // Player Information Object
        val personData = PlayerInformation("Atif Quamar", "Medium-Fast", totalBalls, noOfSessions, listOfSessions)

        // Setting the text for player information
        bowlerName.text = personData.name
        bowlerType.text = personData.bowlerType
        totalBallsBowled.text = personData.totalBallsBowled.toString()
        totalSessions.text = personData.totalSessions.toString()

        // Recycler View to show list of cards for athlete sessions (Clean UI)
        val recyclerView = findViewById<RecyclerView>(R.id.sessions_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AthleteSessionsAdapter(listOfSessions)
        recyclerView.adapter = adapter

    }

    // Function to build the time string of the form "HH:MM, DD/MM/YYYY"
    private fun timeBuilder(time: Time): String {
        var hourString = time.hour.toString()
        if (time.hour < 10) {
            hourString = "0$hourString"
        }
        var minutesString = time.minutes.toString()
        if (time.minutes < 10) {
            minutesString = "0$minutesString"
        }
        var dateString = time.date.toString()
        if (time.date < 10) {
            dateString = "0$dateString"
        }
        var monthString = time.month.toString()
        if (time.month < 10) {
            monthString = "0$monthString"
        }
        var yearString = time.year.toString()
        if (time.year < 10) {
            yearString = "000$yearString"
        } else if (time.year < 100) {
            yearString = "00$yearString"
        } else if (time.year < 1000) {
            yearString = "0$yearString"
        }

        return hourString + ":" + minutesString + " " + time.meridian + ", " + dateString + "/" + monthString + "/" + yearString
    }
}
