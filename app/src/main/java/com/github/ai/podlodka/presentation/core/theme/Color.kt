package com.github.ai.podlodka.presentation.core.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFFF4D144)
val primaryDarkColor = Color(0xFF303F9F)
val errorTextColor = Color(0xFFC00020)
val primaryTitleColor = Color(0xFFFFFFFF)
val secondaryTitleColor = Color(0xFFEEF2FB)
val primaryDescriptionColor = Color(0xB2EEF2FB)
val secondaryDescriptionColor = Color(0xFFA8ADB7)
val hintColor = Color(0xFF45454D)
val backgroundColor = Color(0xFF050B18)
val placeHolderColor = Color(0xFF666666)

val primaryTextColor = primaryTitleColor
val secondaryTextColor = secondaryTitleColor

val AppColors = lightColors(
    primary = primaryColor,
    primaryVariant = primaryDarkColor,
    background = backgroundColor,
    error = errorTextColor,
    onSurface = backgroundColor
)