package com.akv.mycomposeexperiments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.akv.mycomposeexperiments.screens.parallalx.ParallalxCarouselEffect
import com.akv.mycomposeexperiments.ui.theme.MyComposeExperimentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeExperimentsTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    ParallalxCarouselEffect()
}