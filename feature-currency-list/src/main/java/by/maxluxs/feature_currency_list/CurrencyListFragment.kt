package by.maxluxs.feature_currency_list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.feature_currency_list.adapter.CurrencyAdapter
import by.maxluxs.feature_currency_list.adapter.CurrencyCallback
import by.maxluxs.feature_currency_list.databinding.CurrencyListFragmentBinding
import by.maxluxs.feature_currency_list.model.CurrencyModel

class CurrencyListFragment : Fragment(R.layout.currency_list_fragment), CurrencyCallback {

    private lateinit var viewModel: CurrencyListViewModel

    private var _binding: CurrencyListFragmentBinding? = null
    private val binding: CurrencyListFragmentBinding get() = _binding!!

    private val currencyAdapter get() = binding.currencyList.adapter as? CurrencyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CurrencyListViewModel::class.java]
        _binding = CurrencyListFragmentBinding.bind(view)
        setAdapter()
    }

    private fun setAdapter() {
        binding.currencyList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CurrencyAdapter().apply {
                clickCallback = this@CurrencyListFragment::onClickCurrencyItem
            }
        }
        currencyAdapter?.submitList(listOf(CurrencyModel("Bitcoin", "5000$")))
    }

    override fun onClickCurrencyItem(model: CurrencyModel) {
        val bundle = bundleOf("name" to model.name, "price" to model.name)
        findNavController().navigate(R.id.action_to_currency_details, bundle)
    }

}
