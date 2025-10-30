package com.example.mesenmakanan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mesenmakanan.activities.AddressScreen
import com.example.mesenmakanan.activities.HomeScreen
import com.example.mesenmakanan.activities.LoginScreen
import com.example.mesenmakanan.activities.MenuDetailScreen
import com.example.mesenmakanan.activities.OrderConfirmationScreen
import com.example.mesenmakanan.activities.RegisterScreen
import com.example.mesenmakanan.activities.SplashScreen
import com.example.mesenmakanan.activities.SuccessScreen
import com.example.mesenmakanan.ui.theme.MesenMakananTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MesenMakananApp()
        }
    }
}

@Composable
fun MesenMakananApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splashscreen") {
        composable("splashscreen") { SplashScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("menuDetail") { MenuDetailScreen(navController) }
        composable("address") { AddressScreen(navController) }
        composable("orderConfirmation") { OrderConfirmationScreen(navController) }
        composable("success") { SuccessScreen(navController) }
    }
}
