package com.example.amazon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amazon.ui.theme.Purple

class allcat {
    @Preview
    @Composable
    fun allcategories() {
        Column {
            Divider(modifier= Modifier
                .fillMaxWidth()
                .height(2.dp)
            , color = Purple)
            Row (modifier = Modifier.padding(6.dp)){
                Text(text = "See all categories", color = Purple)
                Spacer(modifier = Modifier.width(40.dp))
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "", tint = Purple)
            }
            Divider(modifier= Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(bottom = 50.dp),
                color= Purple)

        }
    }
}