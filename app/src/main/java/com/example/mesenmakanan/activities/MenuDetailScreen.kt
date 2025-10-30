package com.example.mesenmakanan.activities

import com.example.mesenmakanan.data.MenuItem // 1. Use the public MenuItem class
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button // 2. Add import for Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Divider // 3. Change HorizontalDivider to Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// 4. REMOVE the private data class declaration from here
// private data class MenuItem(val name: String, val price: String, val description: String)

@Composable
fun MenuDetailScreen(
    navController: NavController,
    // The 'menuItem' parameter now correctly refers to the public MenuItem class
    menuItem: MenuItem = MenuItem(
        name = "Dimsum Mentai",
        price = "Rp 30.000",
        description = "Dimsum kukus dengan saus mentai gurih, dibakar sebentar untuk aroma yang menggugah selera."
    )
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Gambar Placeholder (Jika ada)
        // Image(painter = painterResource(id = R.drawable.dimsum_mentai), contentDescription = null, modifier = Modifier.height(200.dp))
        // Spacer(modifier = Modifier.height(16.dp))

        // Nama Menu (Header Utama)
        Text(
            text = menuItem.name,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Harga
        Text(
            text = menuItem.price,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.Start)
        )

        // 5. FIX: Use Divider instead of HorizontalDivider
        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // Deskripsi (Body)
        Text(
            text = "Deskripsi:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = menuItem.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol Pesan / Lanjut ke Alamat
        Button(
            onClick = { navController.navigate("address") },
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("Add to Cart & Proceed to Address")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuDetailScreen() {
    MenuDetailScreen(navController = rememberNavController())
}
