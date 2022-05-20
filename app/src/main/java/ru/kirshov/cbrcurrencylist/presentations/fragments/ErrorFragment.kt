package ru.kirshov.cbrcurrencylist.presentations.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kirshov.cbrcurrencylist.R
import ru.kirshov.cbrcurrencylist.databinding.FragmentErrorBinding
import ru.kirshov.cbrcurrencylist.domain.ErrorViewModel
import ru.kirshov.cbrcurrencylist.factory
import ru.kirshov.cbrcurrencylist.presentations.binding.ViewBindingDelegate

class ErrorFragment:Fragment(R.layout.fragment_error) {
    private val binding by ViewBindingDelegate(FragmentErrorBinding::bind)
    private val viewModel:ErrorViewModel by viewModels(){
        requireContext().factory
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}