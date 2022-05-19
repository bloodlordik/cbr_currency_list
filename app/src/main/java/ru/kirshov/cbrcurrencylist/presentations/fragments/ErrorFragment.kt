package ru.kirshov.cbrcurrencylist.presentations.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.kirshov.cbrcurrencylist.R
import ru.kirshov.cbrcurrencylist.databinding.FragmentErrorBinding
import ru.kirshov.cbrcurrencylist.domain.ApplicationViewModelFactory
import ru.kirshov.cbrcurrencylist.domain.ErrorViewModel
import ru.kirshov.cbrcurrencylist.factory

class ErrorFragment:Fragment(R.layout.fragment_error) {
    private var _binding:FragmentErrorBinding? = null
    private val binding:FragmentErrorBinding get() = _binding!!
    private val viewModel:ErrorViewModel by viewModels(){
        requireContext().factory
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentErrorBinding.bind(view)
        viewModel.errorTitle.observe(viewLifecycleOwner){
            binding.title.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}