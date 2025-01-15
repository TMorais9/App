package pt.iade.ei.gdchaves

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.iade.ei.gdchaves.ui.components.Carrinho
import pt.iade.ei.gdchaves.ui.components.CartViewModel
import pt.iade.ei.gdchaves.ui.components.Clube
import pt.iade.ei.gdchaves.ui.components.Conta
import pt.iade.ei.gdchaves.ui.components.Encomendas
import pt.iade.ei.gdchaves.ui.components.Equipa
import pt.iade.ei.gdchaves.ui.components.GameInfo
import pt.iade.ei.gdchaves.ui.components.Jogos
import pt.iade.ei.gdchaves.ui.components.Loja
import pt.iade.ei.gdchaves.ui.components.UserViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
) {
    val cartViewModel: CartViewModel = viewModel()
    val userViewModel: UserViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                navController = navController
            )
        }
        composable("create_account") {
            CriarConta(
                navController,
                userViewModel
            )
        }
        composable("main") {
            MainView(
                navController = navController
            )
        }
        composable("gameInfo") {
            GameInfo(
                navHostController = navController
            )
        }
        composable("equipa") {
            Equipa(
                navHostController = navController
            )
        }
        composable("clube") {
            Clube(
                navHostController = navController
            )
        }
        composable("loja") {
            Loja(
                navController = navController,
                cartViewModel = cartViewModel
            )
        }
        composable("jogos") {
            Jogos(
                navHostController = navController,
                navControlor = navController
            )
        }
        composable("quotas") {
            Quotas(
                navHostController = navController
            )
        }
        composable("conta") {
            Conta(
                navHostController = navController,
                userViewModel = userViewModel
            )
        }
        composable("carrinho") {
            Carrinho(
                navController = navController,
                cartViewModel = cartViewModel
            )
        }
        composable("encomendas") {
            Encomendas(
                navController = navController,
                cartViewModel = cartViewModel
            )
        }
    }
}
