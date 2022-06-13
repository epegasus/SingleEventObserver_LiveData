package dev.pegasus.singleobserver.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dev.pegasus.singleobserver.R
import dev.pegasus.singleobserver.databinding.FragmentHomeBinding
import dev.pegasus.singleobserver.view_model.MainViewModel

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            binding.tvTitle.text = it.toString()
        }

        binding.button.setOnClickListener { viewModel.add() }
        binding.button2.setOnClickListener { findNavController().navigate(R.id.action_fragmentHome_to_fragmentSecondary) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}