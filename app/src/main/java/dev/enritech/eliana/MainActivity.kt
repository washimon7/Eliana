package dev.enritech.eliana

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.enritech.eliana.core.BottomNavBar
import dev.enritech.eliana.core.BottomNavBarItem
import dev.enritech.eliana.ui.theme.ElianaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()
            ElianaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = { BottomNavBar(navigationController) }) {
                        NavHost(
                            navController = navigationController,
                            startDestination = BottomNavBarItem.Home.route
                        ) {
                            composable(BottomNavBarItem.Home.route) { Text(text = "Home screen") }
                            composable(BottomNavBarItem.Search.route) { Text(text = "Search screen") }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ElianaTheme {
        Text(text = "MAIN")
    }
}