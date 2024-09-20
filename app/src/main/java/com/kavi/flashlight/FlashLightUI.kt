package com.kavi.flashlight

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun FlashUI(context: Context,modifier: Modifier = Modifier){
    val torchState = remember {
        mutableStateOf(false)
    }
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedButton(onClick = {
            val newState = !torchState.value
            torch(context, newState)
            torchState.value = newState
        },
            modifier = Modifier
                .size(150.dp)
                .padding(20.dp),
            shape = CircleShape,
            border = BorderStroke(5.dp,if(!torchState.value) Color.Red else Color(0xFF228C22)),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent // Set the background color
            )
            ) {
                Image(painter = painterResource(id = if(torchState.value) R.drawable.power_on else R.drawable.power_off),
                    contentDescription = "Button Image",
                    modifier =  Modifier.size(75.dp)
                )

        }

    }
}