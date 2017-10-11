package pt.isel.pdm.li52d.a1718i.activitylauncher.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import pt.isel.pdm.li52d.a1718i.activitylauncher.R
import pt.isel.pdm.li52d.a1718i.activitylauncher.model.Team

/**
 * Created by lfalcao on 11/10/2017.
 */


class TeamAdapter(val teams: Array<Team>, val layoutInflater: LayoutInflater) : BaseAdapter() {
    override fun getItemId(idx: Int): Long = idx.toLong()

    override fun getCount(): Int = teams.size

    override fun getItem(idx: Int): Any = teams[idx];

    // override other abstract methods here

    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.team_view, container, false)
        }

        //textView.text = teams[position].name

        val teamName = convertView?.findViewById<TextView>(R.id.teamName)
        teamName?.text = teams[position].name

        return convertView!!
    }
}
