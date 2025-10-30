package com.example.mesenmakanan.activities

// 1. Import necessary components
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Make sure this is imported
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mesenmakanan.data.MenuItem
import kotlin.collections.listOf

// 2. Define a data structure for your menu item
data class MenuItem(
    val name: String,
    val price: String
)

// 3. Create a list of menu items (this is your sample data)
val menuItemsList = listOf(MenuItem("Dimsum Mentai", "Rp 30.000", "Lezatnya dimsum dengan saus mentai spesial."),
MenuItem("Seblak", "Rp 10.000", "Seblak pedas dengan aneka kerupuk dan topping."),
MenuItem("Nasi Goreng", "Rp 15.000", "Nasi goreng spesial dengan telur dan ayam."),
MenuItem("Nasi Padang", "Rp 10.000", "Nasi dengan lauk khas Padang, rendang."),
MenuItem("Cireng Bumbu Rujak", "Rp 10.000", "Cireng renyah disajikan dengan bumbu rujak pedas manis."),
MenuItem("Lumpia Basah", "Rp 8.000", "Lumpia basah khas Bandung dengan isian tauge dan bengkuang."),
MenuItem("Mie Jebew", "Rp 12.000", "Mie super pedas yang menggugah selera."),
MenuItem("Roti Bakar", "Rp 5.000", "Roti bakar dengan pilihan topping cokelat atau keju."),
MenuItem("Ayam Bakar", "Rp 13.000", "Ayam bakar bumbu kecap manis, disajikan dengan sambal."),
MenuItem("Ayam Goreng", "Rp 15.000", "Ayam goreng kremes yang gurih dan renyah.")
)


@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Available Menu",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // 4. FIX: Pass the list of data (menuItemsList) to the items function
            items(menuItemsList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable {
                            // You might want to pass the item's ID or name here in the future
                            navController.navigate("menuDetail")
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            // Nama Menu
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleLarge
                            )
                            // Detail atau deskripsi singkat
                            Text(
                                text = "Klik untuk detail & pesan",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Harga
                        Text(
                            text = item.price,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
