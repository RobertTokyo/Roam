package com.hunter.roam

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.MotionEvent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TextView Controls
        this.txt_EmergencyContact.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_emergencyContactFragment3)
        }
        this.txt_Itinerary.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_itineraryFragment)
        }
        this.txt_MyGroup.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_myGroupFragment)
        }
        this.txt_WhereAmI.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_wheremFragment)
        }
        this.txt_Translator.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_translatorFragment)
        }
        view.setOnTouchListener { view, motionEvent ->
            val SWIPE_DISTANCE_THRESHOLD = 50
            val SWIPE_VELOCITY_THRESHOLD = 50
            val action: Int = motionEvent.getAction()
            var x1 = 0.0f
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    x1 = motionEvent.getX()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    val distanceX = x1 - motionEvent.x
                    if (distanceX < 0)
                        gotoSetUp()
                    true
                }

                else ->
                    false
            }
        }
    }

    fun gotoSetUp() {
        try {
            findNavController().navigate(R.id.action_FirstFragment_to_setUpTripFragment)
        } catch (e: Exception) {
            Toast.makeText(getContext(), "Failed to goto set up screen", Toast.LENGTH_LONG).show()
        }
    }
}

