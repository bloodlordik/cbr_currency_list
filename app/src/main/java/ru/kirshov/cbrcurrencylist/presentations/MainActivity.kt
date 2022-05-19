package ru.kirshov.cbrcurrencylist.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.kirshov.cbrcurrencylist.R
import ru.kirshov.cbrcurrencylist.dependencies
import ru.kirshov.cbrcurrencylist.domain.MainViewModel

class MainActivity : AppCompatActivity() {
  //  private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}