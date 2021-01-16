package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        // Menu: we need to tell Android that our TitleFragment has a menu
        setHasOptionsMenu(true)

        return binding.root

    }

    // Inflate Menu
    // we need to override onCreateOptionsMenu and inflate our new menu resource
    // using the provided menu inflater and menu structure.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // we need to override onOptionsItemSelected to connect it to our NavigationUI.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}