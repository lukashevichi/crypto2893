package by.maxluxs.feature_currency_list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.feature_currency_list.adapter.CurrencyAdapter
import by.maxluxs.feature_currency_list.adapter.CurrencyCallback
import by.maxluxs.feature_currency_list.databinding.CurrencyListFragmentBinding
import by.maxluxs.feature_currency_list.model.CurrencyModel
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment

class CurrencyListFragment : DaggerFragment(R.layout.currency_list_fragment), CurrencyCallback {

    private val viewModel: CurrencyListViewModel by viewModels({ viewModelFactory })

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
    }

    private fun setAdapter() {
        binding.currencyList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CurrencyAdapter().apply {
                clickCallback = this@CurrencyListFragment::onClickCurrencyItem
            }
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
