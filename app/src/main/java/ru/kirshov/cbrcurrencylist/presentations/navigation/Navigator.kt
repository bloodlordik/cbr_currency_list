package ru.kirshov.cbrcurrencylist.presentations.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.kirshov.cbrcurrencylist.R
import ru.kirshov.cbrcurrencylist.domain.story.AppEvents
import ru.kirshov.cbrcurrencylist.domain.story.Done
import ru.kirshov.cbrcurrencylist.domain.story.Error
import ru.kirshov.cbrcurrencylist.domain.story.Loading
import ru.kirshov.cbrcurrencylist.presentations.fragments.ErrorFragment
import ru.kirshov.cbrcurrencylist.presentations.fragments.LoadingFragment
import ru.kirshov.cbrcurrencylist.presentations.fragments.RootFragment


class Navigator(private val fragmentManager: FragmentManager){
    fun navigateTo(events:AppEvents){
        when(events){
            is Loading -> {
                fragmentManager.commit {
                    replace<LoadingFragment>(R.id.fragmentContainerView)
                }
            }
            is Done -> {
                fragmentManager.commit {
                    replace<RootFragment>(R.id.fragmentContainerView)
                }
            }
            is Error -> {
                fragmentManager.commit {
                    replace<ErrorFragment>(R.id.fragmentContainerView)
                }
            }
        }
    }
}