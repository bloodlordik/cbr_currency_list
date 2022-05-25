package ru.kirshov.cbrcurrencylist.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer

import ru.kirshov.cbrcurrencylist.R

import ru.kirshov.cbrcurrencylist.domain.MainViewModel
import ru.kirshov.cbrcurrencylist.domain.story.AppEvents
import ru.kirshov.cbrcurrencylist.domain.story.Done
import ru.kirshov.cbrcurrencylist.domain.story.Error
import ru.kirshov.cbrcurrencylist.domain.story.Loading
import ru.kirshov.cbrcurrencylist.factory
import ru.kirshov.cbrcurrencylist.presentations.fragments.ErrorFragment
import ru.kirshov.cbrcurrencylist.presentations.fragments.LoadingFragment
import ru.kirshov.cbrcurrencylist.presentations.fragments.RootFragment
import ru.kirshov.cbrcurrencylist.presentations.navigation.Navigator

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels(){
        factory
    }
    private val navigator = Navigator(fragmentManager = supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.status.observe(this, Observer(navigator::navigateTo))
        viewModel.update()

    }
    private fun selectScreen(event:AppEvents){
       when(event){
           is Loading -> {
               supportFragmentManager.commit {
                   replace<LoadingFragment>(R.id.fragmentContainerView)
                   addToBackStack(null)
               }
           }
           is Done ->{
               supportFragmentManager.commit {
                   replace<RootFragment>(R.id.fragmentContainerView)
                   addToBackStack(null)
               }
           }
           is Error -> {
               supportFragmentManager.commit {
                   replace<ErrorFragment>(R.id.fragmentContainerView)
                   addToBackStack(null)
               }
           }
       }
    }

}