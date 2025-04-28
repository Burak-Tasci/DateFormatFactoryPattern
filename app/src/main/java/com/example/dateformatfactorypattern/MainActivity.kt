package com.example.dateformatfactorypattern

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dateformatfactorypattern.databinding.ActivityMainBinding
import com.example.dateformatfactorypattern.dateformatter.DateFormatType
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.dateFormatResult.observe(this) {
            binding.textViewDateFormatResult.text = it
        }
    }

    private fun initListeners() {
        binding.buttonDateFormatBasic.setOnClickListener {
            viewModel.format(date = Date(), type = DateFormatType.BASIC)
        }
        binding.buttonDateFormatDetail.setOnClickListener {
            viewModel.format(date = Date(), type = DateFormatType.DETAIL)
        }
    }

}