package com.robertoazeredo.punkbeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.robertoazeredo.punkbeer.ui.viewmodel.BeersViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: BeersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getBeers()
    }
}