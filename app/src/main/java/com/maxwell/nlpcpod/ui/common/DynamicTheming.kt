package com.maxwell.nlpcpod.ui.common

import android.content.Context
import androidx.collection.LruCache
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import coil.size.Scale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun rememberDominantColorState(
    context: Context = LocalContext.current,
    defaultColor: Color = MaterialTheme.colors.primary,
    defaultOnColor: Color = MaterialTheme.colors.onPrimary,
    cacheSize: Int = 12,
    isColorValid: (Color) -> Boolean = { true }
): DominantColorState = remember {
    DominantColorState(context, defaultColor, defaultOnColor, cacheSize, isColorValid)
}

@Stable
class DominantColorState(
    private val context: Context,
    private val defaultColor: Color,
    private val defaultOnColor: Color,
    cacheSize: Int = 12,
    private val isColorValid: (Color) -> Boolean = { true }
) {

    var color by mutableStateOf(defaultColor)
        private set

    var onColor by mutableStateOf(defaultOnColor)
        private set

    private val cache = when {
        cacheSize > 0 -> LruCache<String, DominantColors>(cacheSize)
        else -> null
    }

    suspend fun updateColorsFromImageUrl(url: String) {
        val result = calculateDominantColor(url)
        color = result?.color ?: defaultColor
        onColor = result?.onColor ?: defaultOnColor
    }

    private suspend fun calculateDominantColor(url: String): DominantColors? {
        val cached = cache?.get(url)

        if (cached != null) return cached

        return calculateSwatchesInImage(context, url)

            .sortedBy { swatch -> swatch.population }

            .firstOrNull { swatch -> isColorValid(Color(swatch.rgb)) }

            ?.let { swatch ->
                DominantColors(Color(swatch.rgb), Color(swatch.rgb).copy(alpha = 1f))

            }?.also { result -> cache?.put(url, result) }
    }


    fun reset() {
        color = defaultColor
        onColor = defaultColor
    }
}


@Immutable
private data class DominantColors(val color: Color, val onColor: Color)

private suspend fun calculateSwatchesInImage(context: Context, url: String): List<Palette.Swatch> {

    val request = ImageRequest.Builder(context).data(url).size(128)
        .scale(Scale.FILL).allowHardware(false)
        .memoryCacheKey("$url.palette").build()

    val bitmap = when (val result = context.imageLoader.execute(request)) {
        is SuccessResult -> result.drawable.toBitmap()
        else -> null
    }

    return bitmap?.let {

        withContext(Dispatchers.Default) {
            val palette = Palette.Builder(bitmap).resizeBitmapArea(0).clearFilters()
                .maximumColorCount(8).generate()

            palette.swatches
        }

    } ?: emptyList()
}