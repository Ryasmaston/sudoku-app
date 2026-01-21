package com.example.sudoku_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sudoku_app.ui.theme.SudokuappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SudokuappTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen()
        }
        composable(route = "game") {
            GameScreen()
        }
    }

}

@Composable
fun  HomeScreen(){}

@Composable
fun GameScreen(){}

@Preview (showSystemUi = true)
@Composable
fun PreviewHome(){
    SudokuappTheme() {
        HomeScreen()
    }
}




