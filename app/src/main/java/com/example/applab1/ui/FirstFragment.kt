package com.example.applab1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applab1.adapters.ItemsListAdapter
import com.example.applab1.repository.SampleRepository
import com.example.applab1.repository.SampleRepositoryImpl
import com.example.applab1.databinding.FirstFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    private val apiManager: SampleRepository = SampleRepositoryImpl()
    private val newAdapter = ItemsListAdapter() //todo listener
    private var binding: FirstFragmentBinding? = null

    private val _binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        init()
        return _binding.root
    }

    private fun init() {
        val items = apiManager.getSampleList()
        newAdapter.submitList(items)
        _binding.recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        _binding.recyclerView.adapter = newAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}