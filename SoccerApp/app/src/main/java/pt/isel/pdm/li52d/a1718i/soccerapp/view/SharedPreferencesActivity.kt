package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

import pt.isel.pdm.li52d.a1718i.soccerapp.R

class SharedPreferencesActivity : Activity() {

    val PREFS_PRIVATE = "PREFS_PRIVATE"
    val KEY = "key";
    lateinit var  sp: SharedPreferences;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        sp = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE)

        showPreferenceValue();

        savePreferences.setOnClickListener {
            val spEdit = sp.edit();

            spEdit.putString(KEY, preference.text.toString());
            spEdit.commit();
            showPreferenceValue();
        }
    }

    fun showPreferenceValue() {
        preferenceView.text = sp.getString(KEY, "N/A");
    }

}
