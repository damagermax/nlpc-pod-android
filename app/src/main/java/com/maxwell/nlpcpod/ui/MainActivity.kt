package com.maxwell.nlpcpod.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.maxwell.nlpcpod.ui.navigation.Navigation
import com.maxwell.nlpcpod.ui.navigation.Screens
import com.maxwell.nlpcpod.ui.navigation.navItems
import com.maxwell.nlpcpod.ui.theme.NlpcPodTheme
import com.maxwell.nlpcpod.ui.theme.Red600
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NlpcPodTheme {

                val controller = rememberSystemUiController()
                val navController = rememberNavController()


                SideEffect {
                    // controller.setSystemBarsColor(color = Color.Transparent, darkIcons = true)
                }

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomBar(currentDestination, navController) },
                    content = {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .navigationBarsPadding()
                                .statusBarsPadding(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Navigation(it, navController)

                        }
                    })


            }
        }
    }
}


@Composable
fun BottomBar(currentDestination: NavDestination?, navController: NavHostController) {
    val bottomBarState = rememberSaveable {
        mutableStateOf(false)
    }

    when (currentDestination?.route) {
        Screens.Browse.route, Screens.Search.route -> {
            bottomBarState.value = true
        }

        else -> bottomBarState.value = false
    }
    AnimatedVisibility(visible = bottomBarState.value) {

        Column {
            Divider()
            BottomNavigation(
                backgroundColor = Color.Black,
               contentColor = Red600
               ) {

                navItems.forEach { screens ->
                    BottomNavigationItem(
                        icon = { Icon(screens.icon!!, contentDescription = null) },
                        selectedContentColor = Red600,
                        alwaysShowLabel = false,
                       unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                        label = {
                            Text(
                                text = screens.title!!,
                                style = MaterialTheme.typography.labelSmall
                                , fontWeight = FontWeight.Light
                            )
                        },
                        selected = currentDestination?.route == screens.route,
                        onClick = {
                            navController.navigate(screens.route) {

                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        })

                }
            }
        }

    }


}