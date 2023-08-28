package com.akv.mycomposeexperiments.screens.cardflipanimation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedCardScreen() {

    val isFlipped = rememberSaveable { mutableStateOf(true) }
    val flipAnim = animateFloatAsState(
        targetValue = if (isFlipped.value) 0f else 180f,
        label = "Card Animation Provider",
        animationSpec = tween(
            durationMillis = 1500,
            easing = FastOutSlowInEasing
        )
    )

    Box(
        modifier = Modifier
            .wrapContentSize()
            .clickable { isFlipped.value = !isFlipped.value }
            .graphicsLayer(
                rotationY = flipAnim.value,
                cameraDistance = 20f
            )
            .background(Color.Transparent)
    ) {

        if (flipAnim.value <= 90) FrontCard() else BackCard()
    }



    Spacer(modifier = Modifier.size(16.dp))
    Button(
        onClick = { isFlipped.value = !isFlipped.value },
    ) {
        Text(text = "Flip")
    }

}

@Composable
fun Front() {
    Box(
        modifier = Modifier
            .width(354.dp)
            .height(225.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Green)
    )

}

@Composable
fun Back() {
    Box(
        modifier = Modifier
            .width(354.dp)
            .height(225.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Red)
    )
}