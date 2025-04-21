package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceFragment.ChoiceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.upperfragment_container, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choiceID: Int) {
        val colorFragment = ColorFragment.newInstance(choiceID)
        supportFragmentManager.beginTransaction()
            .replace(R.id.lowerfragment_container, colorFragment)
            .addToBackStack(null)
            .commit()
    }
}