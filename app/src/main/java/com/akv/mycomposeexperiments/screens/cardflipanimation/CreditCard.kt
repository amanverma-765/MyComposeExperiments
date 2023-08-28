package com.akv.mycomposeexperiments.screens.cardflipanimation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akv.mycomposeexperiments.R


@Composable
fun FrontCard() {

    val cardGradient = remember {
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF00014F),
                Color(0xFF3A6073)
            )
        )
    }

    Box(
        modifier = Modifier
            .width(354.dp)
            .height(225.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = cardGradient
            )
            .padding(5.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.world_map),
            contentDescription = "World Map",
            colorFilter = ColorFilter.tint(Color.LightGray),
            modifier = Modifier
                .fillMaxSize()
                .alpha(.2f),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.cardholder),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500)
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.exclude_logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .width(28.dp)
                            .height(18.dp)
                    )

                    Text(
                        text = stringResource(R.string.java_bank),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center
                        )
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nfc_logo),
                    contentDescription = "nfc logo",
                    modifier = Modifier
                        .width((51.5).dp)
                        .height(38.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .fillMaxWidth()
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.cardnumber),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                        )
                    )

                    Text(
                        text = stringResource(R.string.cardexpiry),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500)
                        ),
                        modifier = Modifier.alpha(.4f)
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.mastercard_logo),
                        contentDescription = "mastercard logo",
                        modifier = Modifier
                            .width(41.dp)
                            .height(25.dp)
                    )

                    Text(
                        text = "Mastercard",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 8.sp,
                            fontWeight = FontWeight(500)
                        )
                    )
                }
            }
        }
    }

}

@Composable
fun BackCard() {


//    val text1 = stringResource(R.string.dummytext2)
//    val text2 = stringResource(R.string.dummytext3)


    val cardGradient = remember {
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF00014F),
                Color(0xFF3A6073)
            )
        )
    }

    Box(
        modifier = Modifier
            .width(354.dp)
            .height(225.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = cardGradient
            )
            .padding(5.dp)
            .graphicsLayer(
                rotationY = 180f
            )
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.size(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .background(Color.Black)
            )

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(42.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = (123).toString(),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }

//            Text(
//                text = text1 ,
//                fontSize = 6.sp,
//                color = Color.White,
//                lineHeight = 10.sp,
//                modifier = Modifier.padding(horizontal = 18.dp)
//            )
//
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(
//                text = text2,
//                fontSize = 6.sp,
//                color = Color.White,
//                lineHeight = 10.sp,
//                modifier = Modifier.padding(horizontal = 18.dp)
//            )
//        }

        }
    }
}