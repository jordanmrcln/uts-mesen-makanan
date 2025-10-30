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
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // PERBAIKAN: Ganti h4 menjadi displaySmall (M3 equivalent untuk judul besar)
        Text(
            text = "Welcome to Mesen Makanan",
            style = MaterialTheme.typography.displaySmall // Lebih cocok untuk judul utama/besar
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("register") }) {
            Text(text = "Get Started")
        }
    }
}

@Preview(showBackground = true) // Tambah showBackground untuk tampilan yang lebih baik
@Composable
fun PreviewSplashScreen() {
    // Memastikan theme terpakai jika Anda memiliki theme custom
    // MesenMakananTheme { // Uncomment baris ini jika Anda mengimpor theme
    SplashScreen(navController = rememberNavController())
    // }
}