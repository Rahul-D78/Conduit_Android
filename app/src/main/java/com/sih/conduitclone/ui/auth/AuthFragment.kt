package com.sih.conduitclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.sih.conduitclone.R
import com.sih.conduitclone.databinding.FragmentAuthBinding
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)


        _binding?.authTabLayout?.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        //memory leak
        _binding = null
    }
}