package br.com.clb.testuserlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import br.com.clb.testuserlistapp.ui.theme.TestUserListAppTheme


private val menuOptionsBar = listOf(
    MenuBar(name = "Ativados", icons = Icons.Filled.Add),
    MenuBar(name = "Desativados",icons = Icons.Filled.Close),
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val showBottomBar = remember { mutableStateOf(true) }
            TestUserListAppTheme {
                Scaffold(
                    bottomBar = {
                        if (showBottomBar.value) {
                            MenuBottomBar(navController)
                        }
                    },
                    modifier = Modifier.fillMaxSize()


                ) { innerPadding ->

                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        navController = navController,
                        startDestination = "atv"
                    ) {
                        composable("atv") {
                            showBottomBar.value = true
                            ListScreen(navController)
                        }
                        composable("dtv") {
                            showBottomBar.value = true
                            DesativeUSerScreen()
                        }
                        composable("crt") {
                            showBottomBar.value = false
                            CreateUserScreen(navController)
                        }
                        composable (
                            route = "det/name/{name}/birthDate/{birthDate}/cpf/{cpf}/city/{city}",
                            arguments = listOf(
                                navArgument("name") {type =NavType.StringType } ,
                                navArgument("birthDate") {type =NavType.StringType }
                                ,navArgument("cpf") {type =NavType.IntType }
                                ,navArgument("city") {type =NavType.StringType }
                            )

                        ){ backStackEntry->
                            val name = backStackEntry.arguments?.getString("name")
                            val birthDate = backStackEntry.arguments?.getString("birthDate")
                            val cpf = backStackEntry.arguments?.getString("cpf")
                            val city = backStackEntry.arguments?.getString("city")

                            showBottomBar.value = false
                            DetailUSerScreen(navController,name, birthDate, cpf, city)
                        }

                    }
                }
            }
        }
    }


    @Composable
    fun MenuBottomBar(
        navController: NavController
    ) {
        var selectedItem by remember { mutableStateOf(menuOptionsBar[0]) }

        BottomAppBar(
            containerColor = Color(0xFF009688),
        ) {
            val actions = @Composable {
                menuOptionsBar.forEach { item ->
                    val text = item.name
                    val icon = item.icons
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF009688),
                            unselectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedTextColor = Color.White,
                            indicatorColor = Color.White
                        ),
                        alwaysShowLabel = false,
                        selected = selectedItem == item,
                        onClick = {
                            selectedItem = item
                            val route = when (text) {
                                "Ativados" -> "atv"
                                "Desativados" -> "dtv"
                                else -> { "atv" }
                            }
                            navController.navigate(route, navOptions = navOptions {
                                launchSingleTop = true
                                popUpTo(navController.graph.startDestinationId)
                            })
                        },
                        icon = { Icon(imageVector = icon, contentDescription = null) },
                        label = { Text(text = text, color = Color.White) },
                    )

                }
            }
            actions()
        }
    }
}