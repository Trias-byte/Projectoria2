package com.example.projectoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectoria.auth.MainAuthScreen
import com.example.projectoria.auth.OnSuccessfulScreen
import com.example.projectoria.auth.SignInScreen
import com.example.projectoria.auth.SignUpScreen
import com.example.projectoria.main.NotificationMessage
import com.example.projectoria.pages.TestCreator
import com.example.projectoria.ui.theme.ProjectoriaTheme
import com.google.api.Authentication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)
            ProjectoriaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    AuthenticationApp()
                }
            }
        }
    }
}
sealed class DestinationScreen(val route: String){
    data object Main: DestinationScreen("main")
    data object SignIn: DestinationScreen("signIn")
    data object SignUp: DestinationScreen("signUp")
    data object Successful: DestinationScreen("successful")

}
@Composable
fun AuthenticationApp(){


    val vm = hiltViewModel<FbViewModel>()
    val navController = rememberNavController()

    NotificationMessage(vm)

    NavHost(navController = navController, startDestination = DestinationScreen.Main.route){
        composable(DestinationScreen.Main.route){
            MainAuthScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.SignIn.route){
            SignInScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.SignUp.route){
            SignUpScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Successful.route){
            OnSuccessfulScreen(navController = navController, vm = vm)
        }
    }

}