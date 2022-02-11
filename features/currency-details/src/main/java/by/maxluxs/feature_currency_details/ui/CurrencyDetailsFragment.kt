package by.maxluxs.feature_currency_details.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.maxluxs.feature_currency_details.R
import by.maxluxs.feature_currency_details.databinding.CurrencyDetailsFragmentBinding
import by.maxluxs.feature_currency_details.presentation.DefaultCurrencyDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyDetailsFragment : Fragment(R.layout.currency_details_fragment) {

    companion object {
        const val MODEL_KEY = "CURRENCY_MODEL"
    }

    private val viewModel: DefaultCurrencyDetailsViewModel by viewModels()

    private var _binding: CurrencyDetailsFragmentBinding? = null
    private val binding: CurrencyDetailsFragmentBinding get() = _binding!!

    private fun observeModel() = viewModel.model.observe(viewLifecycleOwner) {
        binding.name.text = it.name
        (requireActivity() as AppCompatActivity).supportActionBar?.title = it.name
        binding.symbol.text = it.symbol
        binding.price.text = it.price
        binding.lastUpdated.text = it.lastUpdated
        binding.dateAdded.text = it.dateAdded
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CurrencyDetailsFragmentBinding.bind(view)
        observeModel()
        arguments?.getInt(MODEL_KEY)?.let { viewModel.setModel(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}