package by.maxluxs.feature_converter.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.maxluxs.feature_converter.R
import by.maxluxs.feature_converter.databinding.ConverterFragmentBinding
import by.maxluxs.feature_converter.presentation.ConverterViewModel
import by.maxluxs.feature_converter.ui.dialog.SelectorDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment(R.layout.converter_fragment) {

    private val viewModel: ConverterViewModel by viewModels()

    private var _binding: ConverterFragmentBinding? = null
    private val binding: ConverterFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ConverterFragmentBinding.bind(view)
        setListeners()
    }

    private fun setListeners(){
        binding.mainValue.setOnClickListener {
            SelectorDialog(listOf("BTC", "ETH"))
                .show(childFragmentManager, SelectorDialog.TAG)
        }
        binding.resultValue.setOnClickListener {
            SelectorDialog(listOf("BTC", "ETH"))
                .show(childFragmentManager, SelectorDialog.TAG)
        }
        binding.transfer.setOnClickListener {

        }
    }

}