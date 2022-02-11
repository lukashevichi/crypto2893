package by.maxluxs.feature_converter.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.maxluxs.common.activity.CanShowProgress
import by.maxluxs.feature_converter.R
import by.maxluxs.feature_converter.databinding.ConverterFragmentBinding
import by.maxluxs.feature_converter.presentation.DefaultConverterViewModel
import by.maxluxs.feature_converter.ui.dialog.SelectorDialog
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment(R.layout.converter_fragment) {

    private val viewModel: DefaultConverterViewModel by viewModels()

    private var _binding: ConverterFragmentBinding? = null
    private val binding: ConverterFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ConverterFragmentBinding.bind(view)
        setListeners()
        setObservers()
    }

    private fun setObservers() {
        viewModel.currencies.observe(viewLifecycleOwner) {

        }
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it.localizedMessage ?: "")
        }
        viewModel.progress.observe(viewLifecycleOwner) {
            if (it) {
                (requireActivity() as? CanShowProgress)?.showProgress()
            } else {
                (requireActivity() as? CanShowProgress)?.hideProgress()
            }
        }
        viewModel.result.observe(viewLifecycleOwner) {
            binding.resultValue.text = it.toString()
        }
        viewModel.value.observe(viewLifecycleOwner) {

        }
    }

    private fun setListeners() {
        binding.mainValue.setOnClickListener {
            SelectorDialog(viewModel.currenciesModels)
                .apply { selectCallback = viewModel::setValue }
                .show(childFragmentManager, SelectorDialog.TAG)
        }
        binding.resultValue.setOnClickListener {

        }
        binding.transfer.setOnClickListener {

        }
        binding.moneyInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0.toString().let {
                    try {
                        val value = it.toDouble()
                        viewModel.convert(value)
                    } catch (e: Exception) {}
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun showError(message: String) =
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_SHORT)
            .show()

}