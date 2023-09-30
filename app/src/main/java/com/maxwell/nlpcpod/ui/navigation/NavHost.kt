package com.maxwell.nlpcpod.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.maxwell.nlpcpod.ui.screen.auth.forgotpassword.ForgotPassword
import com.maxwell.nlpcpod.ui.screen.auth.login.LoginScreen
import com.maxwell.nlpcpod.ui.screen.auth.signup.SignupScreen
import com.maxwell.nlpcpod.ui.screen.browse.BrowseScreen
import com.maxwell.nlpcpod.ui.screen.search.SearchScreen

@Composable
fun Navigation(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(modifier = Modifier.padding(paddingValues),navController = navController, startDestination = Screens.AuthNavigation.route) {

        navigation(startDestination = Screens.Login.route, route = Screens.AuthNavigation.route) {
            composable(route = Screens.Login.route) {LoginScreen(navController) }
            composable(route = Screens.Register.route) { SignupScreen(navController) }
            composable(route = Screens.ForgotPassword.route){ ForgotPassword(navController)}
        }

        navigation(startDestination = Screens.Browse.route, route = Screens.HomeNavigation.route) {
            composable(route = Screens.Browse.route) { BrowseScreen() }
            composable(route = Screens.Search.route) { SearchScreen() }
        }
    }

}