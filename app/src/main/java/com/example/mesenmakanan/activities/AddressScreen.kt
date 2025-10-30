package com.example.mesenmakanan.activities

import ads_mobile_sdk.h5
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddressScreen(navController: NavController) {
    var address = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter Address", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("orderConfirmation") }) {
            Text("Proceed to Confirmation")
        }
    }
}

@Preview
@Composable
fun PreviewAddressScreen() {
    AddressScreen(navController = rememberNavController())
}
