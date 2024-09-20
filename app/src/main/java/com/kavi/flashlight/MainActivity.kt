package com.kavi.flashlight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.flashlight.ui.theme.FlashLightTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashLightTheme {
                Scaffold(
                    topBar = {
                             TopAppBar(
                                 colors = TopAppBarDefaults.topAppBarColors(
                                     containerColor = Color.Red
                                 ),
                                 title = {
                                     Text(
                                         text = "Flash Light",
                                         fontSize = 30.sp,
                                         modifier = Modifier
                                             .fillMaxWidth()
                                             .padding(5.dp)
                                     )
                                 })
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlashUI(context = this,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlashLightTheme {
        Greeting("Android")
    }
}