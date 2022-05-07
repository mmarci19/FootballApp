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
import com.example.footballapp.model.team.Team
import com.example.footballapp.ui.details.DetailsActivity
import com.example.footballapp.ui.teams.TeamsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.league_row.view.*
import kotlinx.android.synthetic.main.league_row.view.itemImage
import kotlinx.android.synthetic.main.league_row.view.itemName
import kotlinx.android.synthetic.main.team_row.view.*

class TeamAdapter(private val teams: List<Team>) : RecyclerView.Adapter<TeamAdapter.TeamHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.TeamHolder {
        val inflatedView = parent.inflate(R.layout.league_row, false)

        return TeamHolder(inflatedView)
    }


    override fun onBindViewHolder(holder: TeamAdapter.TeamHolder, position: Int) {
        Log.d("ADAPTER",position.toString())
        Log.d("ADAPTER",teams[position].toString())
        val itemTeam = teams[position]
        holder.bindTeam(itemTeam)
    }


    override fun getItemCount() = teams.size


    class TeamHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var team: Team? = null


        //3
        init {
            v.setOnClickListener(this)


        }

        //4
        override fun onClick(v: View) {
            val context = itemView.context


            val intent = Intent(context, DetailsActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("team_id", this.team?.id.toString())
            Log.d("DETAILINTENT",intent.getStringExtra("team_id").toString())
            intent.putExtra("league_id", this.team?.league_id.toString())
            Log.d("DETAILINTENT",intent.getStringExtra("league_id").toString())
            context.startActivity(intent)
        }
        fun bindTeam(team: Team) {
            Log.d("DETAIL",team.name.toString())
            view.itemName.text = team?.name
            //view.leagueIdentifier.text = this.team?.league_id.toString()
            Picasso.get().load(team?.logo).into(view.itemImage)
            this.team = team

        }


    }
}
