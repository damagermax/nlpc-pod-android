package com.maxwell.nlpcpod.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.maxwell.nlpcpod.ui.screen.auth.forgotpassword.ForgotPassword
import com.maxwell.nlpcpod.ui.screen.auth.login.LoginScreen
import com.maxwell.nlpcpod.ui.screen.auth.signup.SignupScreen
import com.maxwell.nlpcpod.ui.screen.browse.BrowseScreen
import com.maxwell.nlpcpod.ui.screen.search.SearchScreen
import com.maxwell.nlpcpod.ui.screen.series_detail.SeriesDetailScreen

@Composable
fun Navigation(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = Screens.HomeNavigation
            .route
    ) {

        navigation(startDestination = Screens.Login.route, route = Screens.AuthNavigation.route) {
            composable(route = Screens.Login.route) { LoginScreen(navController) }
            composable(route = Screens.Register.route) { SignupScreen(navController) }
            composable(route = Screens.ForgotPassword.route) { ForgotPassword(navController) }
        }

        navigation(startDestination = Screens.Browse.route, route = Screens.HomeNavigation.route) {
            composable(route = Screens.Browse.route) { BrowseScreen(navigation = navController) }
            composable(route = Screens.Search.route) { SearchScreen() }

            composable(route = Screens.SeriesDetail.route,) {
                SeriesDetailScreen() }
        }
    }

}