package com.example.amazon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class myProducts {
    @Preview
    @Composable
    fun products() {
        Row (modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()){
            Box(modifier = Modifier.weight(1f)){
            Card(colors = CardDefaults.cardColors(Color.White),modifier= Modifier
                .width(200.dp)
                .height(200.dp)
                ) {
                Image(
                    painter = painterResource(id = R.drawable.earbud),
                    contentDescription = "smartwatch",
                    modifier = Modifier
                        .weight(5f)
                        .align(Alignment.CenterHorizontally)
                )
                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "SmartWatch", modifier = Modifier
                            .padding(top = 4.dp, start = 8.dp)
                            .weight(2f)
                    )
                    Row(modifier=Modifier.weight(1f)) {
                        Icon(
                            Icons.Outlined.ShoppingCart,
                            contentDescription = "Localized description",
                            tint = Color.Red
                        )
                        Text(
                            text = "999", color = Color.Red, modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                }
            }
                Image(
                    painter = painterResource(id = R.drawable.offer), // Replace 'menu_icon' with your actual image resource
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .clickable { /* Handle navigation icon click */ }
                        .align(Alignment.TopStart)
                )
            }
            Spacer(modifier = Modifier.width(4.dp),)
           //2
            Box(modifier = Modifier.weight(1f)){
                Card(colors = CardDefaults.cardColors(Color.White),modifier= Modifier
                    .width(200.dp)
                    .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mobile2),
                        contentDescription = "smartwatch",
                        modifier = Modifier
                            .weight(5f)
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = "SmartWatch", modifier = Modifier
                                .padding(top = 4.dp, start = 8.dp)
                                .weight(2f)
                        )
                        Row(modifier=Modifier.weight(1f)) {
                            Icon(
                                Icons.Outlined.ShoppingCart,
                                contentDescription = "Localized description",
                                tint = Color.Red
                            )
                            Text(
                                text = "999", color = Color.Red, modifier = Modifier
                                    .padding(4.dp)
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.offer), // Replace 'menu_icon' with your actual image resource
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .clickable { /* Handle navigation icon click */ }
                        .align(Alignment.TopStart)
                )
            }
        }
    }
}