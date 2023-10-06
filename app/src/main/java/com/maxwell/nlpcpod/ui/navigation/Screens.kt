package com.maxwell.nlpcpod.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val title: String? = null, val icon: ImageVector? = null) {

    object AuthNavigation : Screens(route = "auth")
    object Login : Screens(route = "login")
    object Register : Screens(route = "signup")
    object ForgotPassword : Screens(route = "forgot-password")


    object HomeNavigation : Screens(route = "home-navigation")
    object Home : Screens(route = "home")
    object Browse : Screens(route = "browse", title = "Browse", icon = Icons.Filled.Home)
    object Search : Screens(route = "search", title = "Search", icon = Icons.Filled.Search)
    object Settings : Screens(route = "setting", title = "Settings", icon = Icons.Filled.Settings)

    object SeriesDetail : Screens(route = "series-detail/{series}"){
        fun data(seriesJson:String)="series-detail/$seriesJson"
    }


}


val navItems = listOf(
    Screens.Browse,
    Screens.Search,
    Screens.Settings
)