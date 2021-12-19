package com.charko.retrofitcoroutineexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.charko.retrofitcoroutineexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewmodel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.userRv.adapter = MainUserAdapter()
    }
}