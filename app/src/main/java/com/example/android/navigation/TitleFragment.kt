package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Select TitleFragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false
        )

        // Anonymous function
        // ==================
        // Navigate on clicking playButton()
        binding.playButton.setOnClickListener(
                Navigation.createNavigateOnClickListener((R.id.action_titleFragment_to_gameFragment))
        )

        // Standard Function
        // =================
        // binding.playButton.setOnClickListener { view: View ->
        //    Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
        // }

        return binding.root

    }


}