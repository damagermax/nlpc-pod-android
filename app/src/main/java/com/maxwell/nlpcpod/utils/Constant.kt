package com.maxwell.nlpcpod.utils

import java.util.Locale.Category

object Constant {

    // PREFERNCE
    const val SETTINGS = "setting"
    const val ACCESS_TOKEN = "access_token"

    // END POINT
    const val BASE_URL = "http://10.0.2.2:500/api/v1/"

    const val LOGIN = "auth/login"
    const val SIGNUP = "auth/register"
    const val FORGOT_PASSWORD = "/auth/forgotpassword"

    private const val PODCAST = "podcast"
    const val SERIES_ID = "categoryId"
    const val CATEGORY_ID = "categoryId"

    const val CATEGORIES = "$PODCAST/categories"
    const val ALL_SERIES = "$PODCAST/series"
    const val CATEGORIES_SERIES = "$PODCAST/{$CATEGORY_ID}/series"
    const val SERIES_EPISODES = "$PODCAST/{$SERIES_ID}/episodes"
}