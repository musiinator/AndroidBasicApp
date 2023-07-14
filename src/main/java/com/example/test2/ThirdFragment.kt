package com.example.test2

import Gallery
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.databinding.FragmentThirdBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ThirdFragment : Fragment(){
    private var _binding: FragmentThirdBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = RetrofitSerialized().retrofit.create(ApiService::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val images = apiService.getImages()
                withContext(Dispatchers.Main)
                {
                    binding.recyclerViewImages.layoutManager = GridLayoutManager(context, 3)
                    binding.recyclerViewImages.setHasFixedSize(true)

                    val enlargeItem: (String, String) -> Unit = { title, url ->
                        var bundle = Bundle()
                        bundle.putString("title", title)
                        bundle.putString("imageUrl", url)
                        findNavController().navigate(R.id.action_ThirdFragment_to_FourthFragment, bundle)
                    }

                    binding.recyclerViewImages.adapter = AdapterGallery(images, enlargeItem)
                }
            } catch (e: Exception) {
                e.message?.let { Log.e("Error", it) }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}