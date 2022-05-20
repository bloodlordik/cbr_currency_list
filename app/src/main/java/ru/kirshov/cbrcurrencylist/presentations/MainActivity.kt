package ru.kirshov.cbrcurrencylist.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import ru.kirshov.cbrcurrencylist.R

import ru.kirshov.cbrcurrencylist.domain.MainViewModel
import ru.kirshov.cbrcurrencylist.factory
import ru.kirshov.cbrcurrencylist.presentations.fragments.RootFragment

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels(){
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}