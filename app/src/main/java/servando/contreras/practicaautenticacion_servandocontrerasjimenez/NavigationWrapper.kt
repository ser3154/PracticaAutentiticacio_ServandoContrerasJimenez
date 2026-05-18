package servando.contreras.practicaautenticacion_servandocontrerasjimenez

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.home.HomeScreen
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.inicial.InicialScreen
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.login.LoginScreen
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth){

    NavHost(navHostController, startDestination = "home"){
        composable("inicial"){
            InicialScreen(
                navigationToLogin = {navHostController.navigate("login")},
                naviationToSignUp = {navHostController.navigate("signUp")}
            )
        }
        composable("Login"){
            LoginScreen(auth){navHostController.navigate("home")}
        }
        composable("signUp") {
            SignUpScreen(auth)
        }
        composable("home"){
            HomeScreen()
        }
    }

}