package com.example.applab1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.applab1.R
import com.example.applab1.databinding.SecondFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    private lateinit var binding: SecondFragmentBinding
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        //binding.toolbar.setOnClickListener {
        //    findNavController().navigateUp()
        //}
        binding.bigUgaBuga.text = args.id
        binding.materialSwitch.setOnCheckedChangeListener { _, isChecked ->
            binding.text.setBackgroundColor(resources.getColor(if (isChecked) R.color.teal_200 else R.color.primary_90, context?.theme))
        }
        return binding.root
    }

}