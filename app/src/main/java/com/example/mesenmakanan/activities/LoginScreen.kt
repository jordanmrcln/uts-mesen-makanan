package com.example.mesenmakanan.activities

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation // Diperlukan untuk menyembunyikan password
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Data class sederhana untuk menampung info pengguna
data class User(val username: String, val password: String)

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    // SIMULASI DATABASE: Daftar pengguna yang sudah terdaftar
    // Tambahkan pengguna di sini. Contoh: "admin" dan "password123"
    val registeredUsers = remember {
        listOf(
            User("user1", "pass123"),
            User("admin", "password123"),
            User("nama", "pass")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(), // Menyembunyikan password
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Mohon masukkan Username dan Password.", Toast.LENGTH_SHORT).show()
                } else {
                    // --- LOGIKA CEK PENDAFTARAN ---
                    val isAuthenticated = registeredUsers.any { user ->
                        user.username == username && user.password == password
                    }

                    if (isAuthenticated) {
                        navController.navigate("home")
                        Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Akun belum terdaftar atau kredensial salah.", Toast.LENGTH_LONG).show()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Tombol untuk navigasi ke Register (jika pengguna belum punya akun)
        TextButton(onClick = { navController.navigate("register") }) {
            Text("Belum punya akun? Daftar di sini")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}