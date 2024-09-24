package com.example.weather.presentation.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Gradient(
    val primaryGradient: Brush,
    val secondaryGradient: Brush,
    val shadowColor: Color
) {
    constructor(
        firstColor: Color,
        secondColor: Color,
        thirdColor: Color,
        fourthColor: Color,
    ) : this(
        primaryGradient = Brush.linearGradient(listOf(firstColor, secondColor)),
        secondaryGradient = Brush.linearGradient(listOf(thirdColor, fourthColor)),
        shadowColor = firstColor
    )
}

object CardGradients {
    val gradients = listOf(
        Gradient(
            firstColor = Color(28,164,214),
            secondColor = Color(69,207,254),
            thirdColor = Color(69,207,254),
            fourthColor = Color(28,164,214),
        ),
        Gradient(
            firstColor = Color(86,151,254),
            secondColor = Color(177,136,254),
            thirdColor = Color(177,136,254),
            fourthColor = Color(86,151,254),
        ),
        Gradient(
            firstColor = Color(16,99,129),
            secondColor = Color(28,164,214),
            thirdColor = Color(28,164,214),
            fourthColor = Color(16,99,129),
        ),
        Gradient(
            firstColor = Color(140,229,164),
            secondColor = Color(57,184,194),
            thirdColor = Color(57,184,194),
            fourthColor = Color(140,229,164),
        ),
        Gradient(
            firstColor = Color(157,121,234),
            secondColor = Color(240,158,190),
            thirdColor = Color(240,158,190),
            fourthColor = Color(157,121,234),
        )
    )
}