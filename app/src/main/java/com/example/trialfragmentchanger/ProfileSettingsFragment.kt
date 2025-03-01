package com.example.trialfragmentchanger

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.trialfragmentchanger.databinding.FragmentProfileBinding
import com.example.trialfragmentchanger.databinding.FragmentProfileSettingsBinding


class ProfileSettingsFragment : Fragment() {

    private lateinit var viewModel: DataModel

    private var _binding: FragmentProfileSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileSettingsBinding.bind(view)

        viewModel = ViewModelProvider(requireActivity())[DataModel::class.java]

        viewModel.nameOfUser.value?.let { binding.nameEditText.setText(it) }
        viewModel.surnameOfUser.value?.let { binding.surnameEditText.setText(it) }

        binding.infoSaveButton.setOnClickListener {
            viewModel.nameOfUser.value = binding.nameEditText.text.toString()
            viewModel.surnameOfUser.value = binding.surnameEditText.text.toString()
            (requireActivity() as MainActivity).replaceFragment(ProfileFragment())
        }


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileSettingsFragment()

    }
}