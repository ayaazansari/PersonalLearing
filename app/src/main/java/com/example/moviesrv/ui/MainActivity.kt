package com.example.moviesrv.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesrv.adapters.MovieAdapter
import com.example.moviesrv.api.RetrofitInstance
import com.example.moviesrv.databinding.ActivityMainBinding
import com.example.moviesrv.models.Movie
import com.example.moviesrv.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        getAllMovies()
    }
    init {
        getAllMovies()
    }

    private fun getAllMovies() = CoroutineScope(Dispatchers.IO).launch {
        val response = RetrofitInstance.api.getMovies()
        if(response.isSuccessful){
            response.body()?.let {
                withContext(Dispatchers.Main) {
                    binding.rvList.adapter = MovieAdapter(it)
                    binding.rvList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }


}