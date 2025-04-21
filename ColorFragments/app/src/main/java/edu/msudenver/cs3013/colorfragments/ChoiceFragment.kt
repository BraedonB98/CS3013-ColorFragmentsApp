package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {

    interface ChoiceListener {
        fun onSelected(id: Int)
    }

    private var choiceListener: ChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val redText = view.findViewById<TextView>(R.id.redText)
        val blueText = view.findViewById<TextView>(R.id.blueText)

        redText.setOnClickListener {
            choiceListener?.onSelected(2) // Red
        }

        blueText.setOnClickListener {
            choiceListener?.onSelected(1) // Blue
        }
    }
}