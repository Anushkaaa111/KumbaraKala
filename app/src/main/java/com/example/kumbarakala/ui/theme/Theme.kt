package com.example.kumbarakala.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val KumbaraColorScheme = lightColorScheme(
    primary = Clay,
    onPrimary = Bone,
    primaryContainer = Sand,
    onPrimaryContainer = Cocoa,
    secondary = ClayDeep,
    onSecondary = Bone,
    secondaryContainer = Linen,
    onSecondaryContainer = Walnut,
    tertiary = Mist,
    onTertiary = Bone,
    background = Bone,
    onBackground = Cocoa,
    surface = Linen,
    onSurface = Cocoa,
    surfaceVariant = Sand,
    onSurfaceVariant = Walnut,
    outline = Stone,
    outlineVariant = Hairline
)

@Composable
fun KumbaraKalaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = KumbaraColorScheme,
        typography = Typography,
        content = content
    )
}
