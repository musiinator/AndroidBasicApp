package com.example.test2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test2.databinding.FragmentSecondBinding
import java.util.Arrays

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun getMovies() : List<Movie> {
        val movies: List<Movie> = Arrays.asList(Movie("Backup", R.drawable.baseline_backup_24), Movie("Battery", R.drawable.baseline_battery_charging_full_24),
        Movie("Beach", R.drawable.baseline_beach_access_24), Movie("Car crash", R.drawable.baseline_car_crash_24), Movie("Skiing", R.drawable.baseline_downhill_skiing_24),
        Movie("Taxi", R.drawable.baseline_local_taxi_24), Movie("Sad face", R.drawable.baseline_sentiment_neutral_24), Movie("Wifi", R.drawable.baseline_wifi_24),
        Movie("Green", R.drawable.ic_launcher_background), Movie("Android logo", R.drawable.ic_launcher_foreground))

        return movies
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = Adapter(getMovies())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}