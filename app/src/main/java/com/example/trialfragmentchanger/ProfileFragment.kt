package com.example.trialfragmentchanger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.trialfragmentchanger.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var viewModel: DataModel

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentProfileBinding.bind(view)

        viewModel = ViewModelProvider(requireActivity())[DataModel::class.java]

        binding.profileLayout.setOnClickListener {
            (requireActivity() as MainActivity).replaceFragment(ProfileSettingsFragment())
        }



        viewModel.nameOfUser.observe(viewLifecycleOwner){ newText ->
            binding.profileNameText.text = newText
        }

        viewModel.surnameOfUser.observe(viewLifecycleOwner){ newText ->
            binding.profileSurnameText.text = newText
        }





    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment()


    }
}