package by.maxluxs.feature_currency_list.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.common_component_interfaces.Activity.CanShowProgress
import by.maxluxs.feature_currency_list.R
import by.maxluxs.feature_currency_list.databinding.CurrencyListFragmentBinding
import by.maxluxs.feature_currency_list.model.CurrencyModel
import by.maxluxs.feature_currency_list.presentation.CurrencyListViewModel
import by.maxluxs.feature_currency_list.ui.adapter.CurrencyAdapter
import by.maxluxs.feature_currency_list.ui.adapter.CurrencyCallback
import by.maxluxs.feature_currency_list.ui.adapter.SpacesItemDecoration
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyListFragment : Fragment(R.layout.currency_list_fragment), CurrencyCallback {

    private val viewModel: CurrencyListViewModel by viewModels()

    private var _binding: CurrencyListFragmentBinding? = null
    private val binding: CurrencyListFragmentBinding get() = _binding!!

    private val currencyAdapter get() = binding.currencyList.adapter as? CurrencyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CurrencyListFragmentBinding.bind(view)
        setAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            it?.let { list -> currencyAdapter?.submitList(list) }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it.localizedMessage ?: "")
        }
        viewModel.progress.observe(viewLifecycleOwner) {
            if (it) (requireActivity() as? CanShowProgress)?.showProgress()
            else (requireActivity() as? CanShowProgress)?.hideProgress()
        }
    }

    private fun setAdapter() {
        binding.currencyList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CurrencyAdapter().apply {
                clickCallback = this@CurrencyListFragment::onClickCurrencyItem
            }
            addItemDecoration(SpacesItemDecoration(28))
        }
    }

    override fun onClickCurrencyItem(model: CurrencyModel) {
        val bundle = bundleOf("name" to model.name, "price" to model.name)
        findNavController().navigate(R.id.action_to_currency_details, bundle)
    }

    private fun showError(message: String) =
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_SHORT)
            .show()

}
