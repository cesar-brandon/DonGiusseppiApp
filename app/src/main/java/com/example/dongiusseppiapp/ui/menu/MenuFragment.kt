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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dongiusseppiapp.databinding.FragmentMenuBinding
import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuInfo.*
import com.example.dongiusseppiapp.domain.model.MenuModel
import com.example.dongiusseppiapp.ui.menu.adapter.MenuAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MenuFragment : Fragment() {
    private val args: MenuFragmentArgs by navArgs()
    private val menuViewModel: MenuViewModel by viewModels()
    private lateinit var menuAdapter: MenuAdapter
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuViewModel.setCategory(args.category)
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

                ArrozConLeche -> MenuModel.ARROZ_CON_LECHE
                Brownies -> MenuModel.BROWNIES
                Empanadas -> MenuModel.EMPANADAS
                RollosCanela -> MenuModel.ROLLOS_CANELA
                Yoggis -> MenuModel.YOGGIS

                Helado -> MenuModel.HELADO
                Helado4Bolas -> MenuModel.HELADO_4_BOLAS

                SevenUpPersonal -> MenuModel.SEVEN_UP_PERSONAL
                SevenUp1Lt -> MenuModel.SEVEN_UP_1LT
                SporadePersonal -> MenuModel.SPORADE_PERSONAL
                CocaColaPersonal -> MenuModel.COCA_COLA_PERSONAL
                ConcordiaPersonal -> MenuModel.CONCORDIA_PERSONAL
                Concordia1Lt -> MenuModel.CONCORDIA_1LT
                FantaPersonal -> MenuModel.FANTA_PERSONAL
                IncaKolaPersonal -> MenuModel.INCA_KOLA_PERSONAL
            }
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToProductActivity(type)
            )
        })

        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(requireContext(), 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (menuViewModel.category.value == "pizza" && position < 3) {
                            2
                        } else {
                            1
                        }
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
                    binding.lottieLoading.visibility = View.VISIBLE
                    binding.rvMenu.visibility = View.INVISIBLE

                    delay(1000)

                    binding.rvMenu.visibility = View.VISIBLE
                    menuAdapter.updateList(menu)

                    binding.lottieLoading.visibility = View.INVISIBLE
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