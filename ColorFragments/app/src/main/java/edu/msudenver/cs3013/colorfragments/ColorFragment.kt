package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {

    companion object {
        private var fragmentCount = 0

        fun newInstance(choice: Int): ColorFragment {
            return ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt("COLOR_CHOICE", choice)
                }
            }
        }
    }

    private var myIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val choiceID = arguments?.getInt("COLOR_CHOICE", 0) ?: 0
        val colorTextView = view.findViewById<TextView>(R.id.mycolor)

        when (choiceID) {
            1 -> {
                colorTextView.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                colorTextView.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                colorTextView.text = "GENERIC RED FRAGMENT - UID $myIndex"
                colorTextView.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }
}
