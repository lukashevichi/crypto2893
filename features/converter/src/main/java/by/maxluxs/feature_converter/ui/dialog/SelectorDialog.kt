package by.maxluxs.feature_converter.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.feature_converter.R
import by.maxluxs.feature_converter.databinding.SelectorDialogBinding

class SelectorDialog(private val currencies: List<CryptoCurrency>) : DialogFragment() {

    private var _binding: SelectorDialogBinding? = null
    private val binding: SelectorDialogBinding get() = _binding!!

    var selectCallback: ((CryptoCurrency) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.select_currency))
            .setPositiveButton(getString(R.string.select)) { _, _ -> }
            .create()
            .apply {
                _binding = SelectorDialogBinding.inflate(layoutInflater)
                setView(binding.root)
                ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    currencies
                ).also { adapter ->
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner
                    binding.spinner.adapter = adapter
                }
                binding.spinner.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            (p0?.selectedItem as? CryptoCurrency)?.let { selectCallback?.invoke(it) }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}

                    }
            }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }


}