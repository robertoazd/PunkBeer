package com.robertoazeredo.punkbeer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.robertoazeredo.punkbeer.R
import com.robertoazeredo.punkbeer.databinding.ActivityMainBinding
import com.robertoazeredo.punkbeer.ui.viewmodel.BeersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        
    }
}