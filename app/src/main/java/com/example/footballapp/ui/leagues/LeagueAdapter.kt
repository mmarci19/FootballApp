package com.example.footballapp.ui.leagues

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.R
import com.example.footballapp.model.league.League
import com.example.footballapp.ui.teams.TeamsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.league_row.view.*

class LeagueAdapter(private val leagues: List<League>) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueAdapter.LeagueHolder {
        val inflatedView = parent.inflate(R.layout.league_row, false)

        return LeagueHolder(inflatedView)
    }


    override fun onBindViewHolder(holder: LeagueAdapter.LeagueHolder, position: Int) {
        Log.d("ADAPTER",position.toString())
        Log.d("ADAPTER",leagues[position].toString())
        val itemLeague = leagues[position]
        holder.bindLeague(itemLeague)
    }


    override fun getItemCount() = leagues.size


    class LeagueHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var league: League? = null


        //3
        init {
            v.setOnClickListener(this)


        }

        //4
        override fun onClick(v: View) {
            val context = itemView.context


            val intent = Intent(context, TeamsActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("league_id", this.league?.id.toString())
            Log.d("INTENT",intent.getStringExtra("league_id").toString())
            // start your next activity
            context.startActivity(intent)
        }
        fun bindLeague(league: League) {
            Log.d("HOLDER",league.name.toString())
            view.itemName.text = league?.name
            Picasso.get().load(league?.logo).into(view.itemImage)
            this.league = league

        }


    }
}
