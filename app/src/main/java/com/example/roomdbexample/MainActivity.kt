package com.example.roomdbexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbexample.datamodels.Customer
import com.example.roomdbexample.ui.theme.RoomDBExampleTheme
import com.example.roomdbexample.viewmodels.CustomerViewModel
import com.example.roomdbexample.widgets.CustomerList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customerViewModel=ViewModelProvider(this).get(CustomerViewModel::class.java)
        setContent {
            RoomDBExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomerList(customerViewModel)
                }
            }
        }
    }
}

