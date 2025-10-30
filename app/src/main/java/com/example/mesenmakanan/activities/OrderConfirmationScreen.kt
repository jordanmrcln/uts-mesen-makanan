package com.example.mesenmakanan.activities

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
fun OrderConfirmationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // PERBAIKAN 1: Ganti h5 menjadi headlineMedium (M3 equivalent)
        Text(
            text = "Order Confirmation",
            style = MaterialTheme.typography.headlineMedium // Menggantikan h5
        )
        Spacer(modifier = Modifier.height(16.dp))

        // PERBAIKAN 2: Ganti body1 menjadi bodyMedium (M3 equivalent)
        Text(
            text = "Order Details Here",
            style = MaterialTheme.typography.bodyMedium // Menggantikan body1
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("success") }) {
            Text("Confirm Order")
        }
    }
}

@Preview(showBackground = true) // Tambah showBackground untuk visual lebih baik
@Composable
fun PreviewOrderConfirmationScreen() {
    OrderConfirmationScreen(navController = rememberNavController())
}