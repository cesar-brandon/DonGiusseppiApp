package com.example.dongiusseppiapp.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dongiusseppiapp.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivCategoryPizza.setOnClickListener {
            navigateToMenu("pizza")
        }
        binding.ivCategoryDessert.setOnClickListener {
            navigateToMenu("postre")
        }
        binding.ivCategoryIcecream.setOnClickListener {
            navigateToMenu("helado")
        }
        binding.ivCategorySoda.setOnClickListener {
            navigateToMenu("bebida")
        }
    }

    private fun navigateToMenu(category: String) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToMenuFragment(category)
        findNavController().navigate(action)
    }
}