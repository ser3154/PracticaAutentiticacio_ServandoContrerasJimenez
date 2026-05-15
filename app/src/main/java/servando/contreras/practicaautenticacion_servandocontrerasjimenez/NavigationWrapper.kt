package servando.contreras.practicaautenticacion_servandocontrerasjimenez

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.inicial.InicialScreen
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.login.LoginScreen
import servando.contreras.practicaautenticacion_servandocontrerasjimenez.presentacion.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth){

    NavHost(navHostController, startDestination = "inicial"){
        composable("inicial"){
            InicialScreen(
                navigationToLogin = {navHostController.navigate("login")},
                naviationToSignUp = {navHostController.navigate("signUp")}
            )
        }
        composable("Login"){
            LoginScreen(auth)
        }
        composable("signUp") {
            SignUpScreen(auth)
        }
    }

}