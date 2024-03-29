package com.example.dongiusseppiapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.dongiusseppiapp.databinding.ActivityProductBinding
import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuModel
import com.example.dongiusseppiapp.domain.model.MenuModel.AMERICANA
import com.example.dongiusseppiapp.domain.model.MenuModel.ARROZ_CON_LECHE
import com.example.dongiusseppiapp.domain.model.MenuModel.BROWNIES
import com.example.dongiusseppiapp.domain.model.MenuModel.COCA_COLA_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.CONCORDIA_1LT
import com.example.dongiusseppiapp.domain.model.MenuModel.CONCORDIA_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.EMPANADAS
import com.example.dongiusseppiapp.domain.model.MenuModel.FANTA_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.HELADO
import com.example.dongiusseppiapp.domain.model.MenuModel.HELADO_4_BOLAS
import com.example.dongiusseppiapp.domain.model.MenuModel.INCA_KOLA_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_AMERICANA
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_OLIVO
import com.example.dongiusseppiapp.domain.model.MenuModel.OLIVO
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_AMERICANA
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_OLIVO
import com.example.dongiusseppiapp.domain.model.MenuModel.ROLLOS_CANELA
import com.example.dongiusseppiapp.domain.model.MenuModel.SEVEN_UP_1LT
import com.example.dongiusseppiapp.domain.model.MenuModel.SEVEN_UP_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.SPORADE_PERSONAL
import com.example.dongiusseppiapp.domain.model.MenuModel.YOGGIS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
@AndroidEntryPoint
class ProductActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val productViewModel: ProductViewModel by viewModels()
    private val args: ProductActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initUIListeners()
        initUIState()

        val menuInfo = getMenuInfo(args.type)
        productViewModel.setProductName(
            menuInfo.name, menuInfo.image, menuInfo.cardImage, menuInfo.description, menuInfo.price
        )
    }

    private fun getMenuInfo(menuType: MenuModel): MenuInfo {
        return when (menuType) {
            AMERICANA -> MenuInfo.Americana
            MEDIA_AMERICANA -> MenuInfo.MediaAmericana
            PORCION_AMERICANA -> MenuInfo.PorcionAmericana
            HAWAIANA -> MenuInfo.Hawaiana
            MEDIA_HAWAIANA -> MenuInfo.MediaHawaiana
            PORCION_HAWAIANA -> MenuInfo.PorcionHawaiana
            OLIVO -> MenuInfo.Olivos
            MEDIA_OLIVO -> MenuInfo.MediaOlivo
            PORCION_OLIVO -> MenuInfo.PorcionOlivo

            ARROZ_CON_LECHE -> MenuInfo.ArrozConLeche
            BROWNIES -> MenuInfo.Brownies
            EMPANADAS -> MenuInfo.Empanadas
            ROLLOS_CANELA -> MenuInfo.RollosCanela
            YOGGIS -> MenuInfo.Yoggis

            HELADO -> MenuInfo.Helado


            HELADO_4_BOLAS -> MenuInfo.Helado4Bolas
            SEVEN_UP_PERSONAL -> MenuInfo.SevenUpPersonal
            SEVEN_UP_1LT -> MenuInfo.SevenUp1Lt
            SPORADE_PERSONAL -> MenuInfo.SporadePersonal
            COCA_COLA_PERSONAL -> MenuInfo.CocaColaPersonal
            CONCORDIA_PERSONAL -> MenuInfo.ConcordiaPersonal
            CONCORDIA_1LT -> MenuInfo.Concordia1Lt
            FANTA_PERSONAL -> MenuInfo.FantaPersonal
            INCA_KOLA_PERSONAL -> MenuInfo.IncaKolaPersonal
        }
    }

    private fun initUIListeners() {
        binding.ivChevronBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivFavorite.setOnClickListener {
            it.isSelected = !it.isSelected
        }
        binding.btnIncrease.setOnClickListener {
            productViewModel.incrementProductCount()
        }
        binding.btnDecrease.setOnClickListener {
            productViewModel.decrementProductCount()
        }
        binding.btnAddToCart.setOnClickListener {
            val product = productViewModel.state.value as ProductState.Success
            val quantity = productViewModel.productCount.value

            finish()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    productViewModel.state.collect {
                        when (it) {
                            ProductState.Loading -> loadingState()
                            is ProductState.Error -> errorState(it.message)
                            is ProductState.Success -> delaySuccessState(it)
                        }
                    }
                }

                launch {
                    productViewModel.productCount.collect { count ->
                        binding.tvProductCount.text = count.toString()
                    }
                }

                launch {
                    productViewModel.totalPrice.collect { price ->
                        binding.tvProductPrice.text = "S/.${"%.2f".format(price)}"
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }

    private fun errorState(message: String) {
        binding.progressBar.isVisible = false
    }

    private suspend fun delaySuccessState(state: ProductState.Success) {
        kotlinx.coroutines.delay(500)
        successState(state)
    }

    private fun successState(state: ProductState.Success) {
        lifecycleScope.launch {
            binding.progressBar.isVisible = false
            binding.ivFavorite.isVisible = true
            binding.tvProductPrice.isVisible = true
            binding.tvProductName.text = getString(state.name)
            binding.ivProductImage.setImageResource(state.image)
            binding.tvProductDescription.text = getString(state.description)
            binding.tvProductPrice.text = "S/.${getString(state.price)}"
        }
    }
}