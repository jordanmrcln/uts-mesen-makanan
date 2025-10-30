package com.example.mesenmakanan.activities

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.* // Diperlukan untuk remember dan mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext // Diperlukan untuk Toast
import androidx.compose.ui.text.input.PasswordVisualTransformation // Untuk menyembunyikan password
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(navController: NavController) {
    // --- 1. STATE MANAGEMENT ---
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            // Menggunakan LazyColumn agar layar bisa di-scroll jika keyboard muncul
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { Spacer(modifier = Modifier.height(64.dp)) } // Padding atas

                // Judul Utama: "Sign up"
                item {
                    Text(
                        text = "Sign up",
                        style = MaterialTheme.typography.displaySmall,
                        textAlign = TextAlign.Center
                    )
                }

                item { Spacer(modifier = Modifier.height(8.dp)) }

                // Subteks
                item {
                    Text(
                        text = "Buat akun untuk memulai pemesanan makanan",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }

                item { Spacer(modifier = Modifier.height(32.dp)) }

                // --- 2. KOLOM INPUT (TEXTFIELDS) ---

                // Kolom Nama
                item {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nama Lengkap") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }

                // Kolom Email
                item {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }

                // Kolom Password
                item {
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(), // Menyembunyikan teks
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item { Spacer(modifier = Modifier.height(64.dp)) } // Spacer untuk menambah ruang di bagian bawah
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Tombol "Register" - Sekarang bisa dipencet dan validasi
                Button(
                    onClick = {
                        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                            // Lakukan proses registrasi atau navigasi
                            navController.navigate("home")
                            Toast.makeText(context, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 14.dp)
                ) {
                    Text(text = "Register", style = MaterialTheme.typography.titleMedium)
                }

                // Tombol "Login"
                OutlinedButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 14.dp)
                ) {
                    Text(text = "Login", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(navController = rememberNavController())
}