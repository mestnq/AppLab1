package com.example.applab1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applab1.adapters.ItemsListAdapter
import com.example.applab1.data.Item
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
    private var binding: FirstFragmentBinding? = null
    private lateinit var items: List<Item>

    private val _binding get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("FirstFragment onCreate")
        items = apiManager.getSampleList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("FirstFragment onCreateView")
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("FirstFragment onViewCreated")

        val newAdapter = ItemsListAdapter {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.id.toString(), it.header, it.subheadForHeader, it.title, it.subheadForTitle, it.description))
        }

        newAdapter.submitList(items)
        _binding.recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        _binding.recyclerView.adapter = newAdapter
    }
}