/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false
        )

        // Button: Next Match
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }

        // var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }

        // Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()

        // Declaring that our Fragment has a Menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // Inflate our menu & safeguard
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        // Override onCreateOptionsMenu and begin by inflating the winner_menu
        inflater.inflate(R.menu.winner_menu, menu)

        // Safeguard: Check if the activity resolves, otherwise hide the share icon
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {

            // hide the share icon | menu if it does't resolve
            menu?.findItem(R.id.share)?.setVisible(false)

        }
    }

    // Method: shareIntent()
    private fun getShareIntent(): Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())

        /***
         * Standard Intent
         */

        // val shareIntent = Intent(Intent.ACTION_SEND)

        // shareIntent
        //        .setType("text/plain")
        //        .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))

        // return shareIntent

        /**
         * ShareCompat() - Special intent type
         */
        return ShareCompat.IntentBuilder.from(activity!!)
                .setType("text/plain")
                .setText(getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
                .intent

    }

    // Method: shareSuccess() Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    // When the menuitem id matches R.id.share, call the shareSuccess method.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }

}
