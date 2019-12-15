package com.ofird.movieguidekt.fragments


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible

import com.ofird.movieguidekt.R

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    private val text: String="This is a fav frag"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val root=inflater.inflate(R.layout.fragment_favorites, container, false)
        val txtView:TextView=root.findViewById(R.id.textFav)
        txtView.setText(text)


        return root
    }


}
