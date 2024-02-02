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
import com.example.dongiusseppiapp.domain.model.MenuModel.HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_AMERICANA
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.MEDIA_OLIVO
import com.example.dongiusseppiapp.domain.model.MenuModel.OLIVO
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_AMERICANA
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_HAWAIANA
import com.example.dongiusseppiapp.domain.model.MenuModel.PORCION_OLIVO
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
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
            menuInfo.name,
            menuInfo.image,
            menuInfo.cardImage,
            menuInfo.description,
            menuInfo.price
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
        }
    }

    private fun initUIListeners() {
        binding.ivChevronBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                productViewModel.state.collect {
                    when (it) {
                        ProductState.Loading -> loadingState()
                        is ProductState.Error -> errorState(it.message)
                        is ProductState.Success -> delaySuccessState(it)
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
        kotlinx.coroutines.delay(1200)
        successState(state)
    }

    private fun successState(state: ProductState.Success) {
        lifecycleScope.launch {
            binding.progressBar.isVisible = false
            binding.tvProductName.text = getString(state.name)
            binding.ivProductImage.setImageResource(state.image)
            binding.tvProductDescription.text = getString(state.description)
            binding.tvProductPrice.text = getString(state.price)
        }
    }
}