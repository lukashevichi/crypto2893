package by.maxluxs.feature_converter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.maxluxs.feature_converter.databinding.ConverterFragmentBinding

class ConverterFragment : Fragment(R.layout.converter_fragment) {

    private lateinit var viewModel: ConverterViewModel

    private var _binding: ConverterFragmentBinding? = null
    private val binding: ConverterFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ConverterFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[ConverterViewModel::class.java]
    }

}