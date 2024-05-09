package com.example.counterapplication


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapplication.ui.theme.CounterApplicationTheme

class MainActivity : ComponentActivity()
{
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter()
{

// The color list is for different shade color
    val ColorList : List<Color> = listOf(
        Color(0XFF07BEB8) ,
        Color(0XFF3DCCC7) ,
        Color(0XFF68D8D6) ,
        Color(0XFF9CEAEF) ,
        Color(0XFFC4FFF9) ,
                                        )
    val number = remember {
        mutableIntStateOf(0)
    }

// This is for TextDesign is use when we need design text again and again.
    val TextDesign = TextStyle(

        textMotion = TextMotion.Animated ,
        textDirection = TextDirection.Rtl ,
        color = Color(0xFF080708) ,
        fontSize = 123.sp ,
        shadow = Shadow(color = Color.Green , offset = Offset(5.0f , 10f) , blurRadius = 10f) ,
        fontStyle = FontStyle.Italic ,
        fontWeight = FontWeight.SemiBold ,
        fontFamily = FontFamily.SansSerif)

    Column(
        modifier = Modifier
                .fillMaxSize()
                .background(brush = background(isVerticalGradient = false , colors = ColorList))
                .size(220.dp) ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally ,
          ) {

        Text("${number.intValue}" ,
             style = TextDesign ,
             modifier = Modifier.padding(vertical = 55.dp))

        Spacer(modifier = Modifier.padding(10.dp))

        FloatingActionButton(onClick = {number.intValue ++} ,
                             modifier = Modifier.size(50.dp) ,
                             shape = CircleShape ,
                             containerColor = Color(0xFF080708)) {
            Icon(Icons.Filled.Add , "add" , modifier = Modifier , Color(0xFF40E200))

        }

        Spacer(modifier = Modifier.padding(44.dp))

        FloatingActionButton(onClick = {number.intValue --} ,
                             modifier = Modifier.size(50.dp) ,
                             shape = CircleShape ,
                             containerColor = Color(0xFF080708)) {
            Icon(Icons.Filled.Close , "minus" , modifier = Modifier , Color(0xFFD40202))

        }
    }
}

// This function is for background color

@Composable
private fun background(
        isVerticalGradient : Boolean , colors : List<Color>
                      ) : Brush
{

    val endOffset = if (isVerticalGradient)
    { // This is for x axis.
        Offset(0f , Float.POSITIVE_INFINITY)
    }
    else // This is for y axis.
    {
        Offset(Float.POSITIVE_INFINITY , 0f)
    }

    return Brush.linearGradient(colors = colors , start = Offset.Zero , end = endOffset)
}

