package by.maxluxs.currency_list.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.common.activity.CanShowProgress
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.currency_list.R
import by.maxluxs.currency_list.databinding.CurrencyListFragmentBinding
import by.maxluxs.currency_list.presentation.CurrencyListViewModel
import by.maxluxs.currency_list.ui.adapter.CurrencyAdapter
import by.maxluxs.currency_list.ui.adapter.CurrencyCallback
import by.maxluxs.currency_list.ui.adapter.SpacesItemDecoration
import by.maxluxs.feature_currency_details.ui.CurrencyDetailsFragment
import by.maxluxs.feature_filter.FilterItemListDialogFragment
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
        setListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_app_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_filter -> {
                FilterItemListDialogFragment.newInstance(4)
                    .show(childFragmentManager, FilterItemListDialogFragment.tag)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClickCurrencyItem(model: CryptoCurrency) {
        val bundle = bundleOf(CurrencyDetailsFragment.MODEL_KEY to model.id)
        findNavController().navigate(R.id.action_to_currency_details, bundle)
    }

    private fun setObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            it?.let { list -> currencyAdapter?.submitList(list) }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it.localizedMessage ?: "")
        }
        viewModel.progress.observe(viewLifecycleOwner) {
            if (it) {
                (requireActivity() as? CanShowProgress)?.showProgress()
                binding.refreshList.isRefreshing = true
            } else {
                (requireActivity() as? CanShowProgress)?.hideProgress()
                binding.refreshList.isRefreshing = false
            }
        }
    }

    private fun setListeners() {
        binding.refreshList.setOnRefreshListener {
            viewModel.getCurrencies()
        }
    }

    private fun setAdapter() {
        binding.currencyList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CurrencyAdapter().apply {
                clickCallback = this@CurrencyListFragment::onClickCurrencyItem
            }
            addItemDecoration(SpacesItemDecoration(22))
        }
    }

    private fun showError(message: String) =
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_SHORT)
            .show()

}
