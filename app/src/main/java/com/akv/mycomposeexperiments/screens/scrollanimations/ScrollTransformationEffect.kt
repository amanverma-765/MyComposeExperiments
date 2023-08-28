package com.akv.mycomposeexperiments.screens.scrollanimations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollTransition() {

    // SearchBar Related Variables
    val query = remember { mutableStateOf("") }
    val isActive = remember { mutableStateOf(false) }

    // LazyColumn Related Variables
    val lazyState = rememberLazyListState()
    val isScrolling = lazyState.isScrollInProgress
    val isScrollingUp = lazyState.isScrollingUp()

    // Card Animation
    val animateScroll = animateFloatAsState(
        targetValue = if (isScrollingUp && isScrolling) -50f else if (!isScrollingUp && isScrolling) 50f else 0f,
        animationSpec = tween(500),
        label = ""
    )

    Scaffold(

        // SearchBar
        topBar = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                SearchBar(
                    query = query.value,
                    onQueryChange = { query.value = it },
                    onSearch = { isActive.value = false },
                    active = isActive.value,
                    onActiveChange = { isActive.value = it },
                    placeholder = { Text(text = "Search here") },
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = SearchBarDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = .5f)
                    ),
                ) {}
            }
        }

    ) { paddingValues ->

        // LazyColumn
        LazyColumn(
            contentPadding = paddingValues,
            state = lazyState,
        ) {
            items(itemColors) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(top = 16.dp, start = 20.dp, end = 20.dp)

                        // animation applied here
                        .graphicsLayer(
                            rotationX = animateScroll.value,
                            cameraDistance = 30f
                        ),
                    colors = CardDefaults.cardColors(containerColor = it)
                ) {}
            }
        }
    }
}

val itemColors = listOf(
    Color(0xFFFF1744),
    Color(0xFFD500F9),
    Color(0xFF00E5FF),
    Color(0xFF76FF03),
    Color(0xFF3D5AFE),
    Color(0xFF1DE9B6),
    Color(0xFF43A047),
    Color(0xFF039BE5),
    Color(0xFF00897B),
    Color(0xFFFDD835),
    Color(0xFFF8BBD0),
    Color(0xFFD32F2F),
    Color(0xFF69F0AE),
    Color(0xFFFF6F00),
    Color(0xFF01579B),
    Color(0xFFBF360C),
    Color(0xFFFBC02D),
    Color(0xFF2962FF),
    Color(0xFFAA00FF),
    Color(0xFF00B8D4),
    Color(0xFFD50000),
    Color(0xFFD500F9),

)


// Returns the lazyColumn scroll direction
@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableIntStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableIntStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}