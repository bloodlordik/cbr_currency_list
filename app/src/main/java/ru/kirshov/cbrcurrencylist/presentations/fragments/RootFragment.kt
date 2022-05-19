package ru.kirshov.cbrcurrencylist.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.kirshov.cbrcurrencylist.R
import ru.kirshov.cbrcurrencylist.databinding.FragmentRootBinding

class RootFragment:Fragment() {
    private var _binding:FragmentRootBinding? = null
    private val binding:FragmentRootBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRootBinding.inflate(inflater,container,false)
        checkNotNull(_binding)
        return binding.root
    }
}