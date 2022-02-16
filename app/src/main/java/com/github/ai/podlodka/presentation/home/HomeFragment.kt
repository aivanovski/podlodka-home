package com.github.ai.podlodka.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.github.ai.podlodka.presentation.theme.AppTheme
import com.github.ai.podlodka.databinding.BaseFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =  BaseFragmentBinding.inflate(inflater, container, false)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppTheme {
                    HomeScreen(viewModel = viewModel)
                    // Screen()
                }
            }
        }

        return binding.root
    }
}

@Composable
fun Screen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello",
            fontSize = 28.sp,
            color = Color.Green,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun Pr() {
    AppTheme {
        Screen()
    }
}