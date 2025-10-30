package com.example.mesenmakanan.activities

import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Diperlukan untuk Text, Button, MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // PERBAIKAN 1: Ganti h4 menjadi headlineLarge (M3 equivalent untuk judul sukses)
        Text(
            text = "Success!",
            style = MaterialTheme.typography.headlineLarge // Menggantikan h4
        )
        Spacer(modifier = Modifier.height(16.dp))

        // PERBAIKAN 2: Ganti body1 menjadi bodyMedium (M3 equivalent untuk teks isi)
        Text(
            text = "Your order has been placed successfully!",
            style = MaterialTheme.typography.bodyMedium // Menggantikan body1
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("home") }) {
            Text("Go to Home")
        }
    }
}

@Preview(showBackground = true) // Tambah showBackground untuk visual lebih baik
@Composable
fun PreviewSuccessScreen() {
    SuccessScreen(navController = rememberNavController())
}