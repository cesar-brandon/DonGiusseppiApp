package com.example.dongiusseppiapp.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.dongiusseppiapp.databinding.FragmentMenuBinding
import com.example.dongiusseppiapp.domain.model.MenuInfo.Americana
import com.example.dongiusseppiapp.domain.model.MenuInfo.Hawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaOlivo
import com.example.dongiusseppiapp.domain.model.MenuInfo.Olivos
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionOlivo
import com.example.dongiusseppiapp.domain.model.MenuModel
import com.example.dongiusseppiapp.ui.menu.adapter.MenuAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MenuFragment : Fragment() {
    private val menuViewModel: MenuViewModel by viewModels()
    private lateinit var menuAdapter: MenuAdapter
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        menuAdapter = MenuAdapter(onItemSelect = {
            val type = when (it) {
                Americana -> MenuModel.AMERICANA
                MediaAmericana -> MenuModel.MEDIA_AMERICANA
                PorcionAmericana -> MenuModel.PORCION_AMERICANA
                Hawaiana -> MenuModel.HAWAIANA
                MediaHawaiana -> MenuModel.MEDIA_HAWAIANA
                PorcionHawaiana -> MenuModel.PORCION_HAWAIANA
                Olivos -> MenuModel.OLIVO
                MediaOlivo -> MenuModel.MEDIA_OLIVO
                PorcionOlivo -> MenuModel.PORCION_OLIVO
            }
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToProductActivity(type)
            )
        })

        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(requireContext(), 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (position < 3) 2 else 1
                    }
                }
            }
            adapter = menuAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                menuViewModel.menu.collect { menu ->
                    binding.ivLoadingPizza.visibility = View.VISIBLE

                    Glide.with(requireContext())
                        .load(com.example.dongiusseppiapp.R.drawable.loader_pizza)
                        .into(binding.ivLoadingPizza)

                    delay(2000)

                    menuAdapter.updateList(menu)

                    binding.ivLoadingPizza.visibility = View.GONE
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}