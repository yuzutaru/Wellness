package com.yustar.common.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = Gray100,
    surface = Gray90,
    primary = Blue40,
    onPrimaryFixedVariant = Blue60,
    onPrimary = Blue80,
    onPrimaryContainer = Blue10,
    onSecondaryFixedVariant = Gray80,
    onSecondary = White,
    onTertiaryFixed = Gray60,
    onTertiary = Gray20
)

private val LightColorScheme = lightColorScheme(
    /* Other default colors to override*/
    background = Gray10,
    surface = White,
    primary = Blue60,
    onPrimaryFixedVariant = Blue60,
    onPrimary = Blue60,
    onPrimaryContainer = Blue10,
    onSecondaryFixedVariant = Gray80,
    onSecondary = Gray80,
    onTertiaryFixed = Gray60,
    onTertiary = Gray60
)

@Composable
fun WellnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

    MaterialTheme(
      colorScheme = colorScheme,
      typography = Typography,
      content = content
    )
}