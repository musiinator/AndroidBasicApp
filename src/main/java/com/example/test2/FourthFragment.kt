package com.example.test2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.test2.databinding.FragmentFourthBinding
import com.example.test2.databinding.FragmentThirdBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var title = arguments?.getString("title")
        var imageUrl = arguments?.getString("imageUrl")

        this.context?.let { Glide.with(it).load(imageUrl).into(binding.imageViewFullScreen) }
        binding.textViewFullScreen.text = title
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}