package com.example.projectoria.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projectoria.R

// Set of Material typography styles to start with

val montserrat = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.montserrat, FontWeight.Normal),
    Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_black_italic, FontWeight.Black, FontStyle.Italic),
)

// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 ,
//
//    h1 =
//
//    subtitle1 =
//    ),
//
//    subtitle2 = TextStyle( // it's important text
//        fontFamily = montserrat,
//        fontWeight = FontWeight.Medium,
//        fontSize = 20.sp
//    ),
//
//    caption = ,
//
//    )

//val displayLarge: TextStyle = COMPILED_CODE,
//val displayMedium: TextStyle = COMPILED_CODE,
//val displaySmall: TextStyle = COMPILED_CODE,
//
//val headlineMedium: TextStyle = COMPILED_CODE,
//val headlineSmall: TextStyle = COMPILED_CODE,
//val titleLarge: TextStyle = COMPILED_CODE,
//val titleMedium: TextStyle = COMPILED_CODE,
//val titleSmall: TextStyle = COMPILED_CODE,
//val bodyLarge: TextStyle = COMPILED_CODE,
//val bodyMedium: TextStyle = COMPILED_CODE,
//val bodySmall: TextStyle = COMPILED_CODE,
//val labelLarge: TextStyle = COMPILED_CODE,
//val labelMedium: TextStyle = COMPILED_CODE,
//val labelSmall: TextStyle = COMPILED_CODE

val Typography = Typography(
    bodyMedium =  TextStyle( // it's a standard text
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    letterSpacing = 0.05.sp,
    ),

    titleLarge = TextStyle( // it's a header text
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
    ),

    bodyLarge = TextStyle( // it's bold text
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle( // it's form text
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)