package com.example.tweeklabs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tweeklabs.AthleteSession
import com.example.tweeklabs.R


// Adapter for recycler view
class AthleteSessionsAdapter (private val allSessions: List<AthleteSession>):
    RecyclerView.Adapter<AthleteSessionsAdapter.SessionInformationViewHolder>() {

    class SessionInformationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sessionId: TextView = itemView.findViewById(R.id.tv_session_number)
        var sessionBallsCount: TextView = itemView.findViewById(R.id.tv_value_balls_count)
        var sessionAverageSpeed: TextView = itemView.findViewById(R.id.tv_value_av_speed)
        var sessionTime: TextView = itemView.findViewById(R.id.tv_value_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionInformationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sessions_cardview, parent, false)
        return SessionInformationViewHolder(view)
    }

    override fun onBindViewHolder(holder: SessionInformationViewHolder, position: Int) {
        val item = allSessions[position]
        holder.sessionId.text = "Session " + item.sessionId.toString()
        holder.sessionBallsCount.text = item.ballsBowled.toString()
        holder.sessionAverageSpeed.text = item.averageSpeed.toString() + " KMPH"
        holder.sessionTime.text = item.time
    }

    override fun getItemCount(): Int = allSessions.size
}