package com.softserve.edu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.softserve.edu.service.Calc
import com.softserve.edu.service.CalcFilter
import com.softserve.edu.service.DigitalFilter
import com.softserve.edu.ui.theme.JUnit4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val game = Game()
            JUnit4Theme {
                //val game = Game()
                var uiScore by remember {
                    mutableStateOf(0)
                }
                //
                val calcFilter = CalcFilter(Calc())
                var addFirst by remember {
                    mutableStateOf("1")
                }
                var addSecond by remember {
                    mutableStateOf("0")
                }
                Column(
                    //modifier = Modifier.fillMaxSize(),
                    modifier = Modifier.fillMaxHeight(0.7f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    //verticalArrangement = Arrangement.SpaceAround,
                    //verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Your score: $uiScore",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                    Button(
                        onClick = {
                            game.incrementScore()
                            uiScore = game.score
                        }
                    ){
                        Text(
                            text = "Increment score",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.Yellow
                        )
                    }
                    //
                    Text(
                        text = "Mini Calc",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                    TextField(
                        value = addFirst, // Current value of the text field
                        onValueChange = {newText ->
                            addFirst = DigitalFilter(newText)
                        }, // Callback for when the value changes
                        label = @Composable { Text(text = "Enter addition", fontSize = 30.sp) },
                        textStyle = TextStyle(fontSize = 30.sp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            unfocusedTextColor = Color(0xff888888),
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color(0xff222222),
                        )
                    )
                    TextField(
                        //modifier = Modifier
                        //    .background(Color.Yellow),
                        //.fillMaxWidth(), // Modifier to fill the available width
                        value = addSecond, // Current value of the text field
                        onValueChange = {newText ->
                            addSecond = DigitalFilter(newText)
                        }, // Callback for when the value changes
                        label = @Composable { Text(text = "Enter addition", fontSize = 30.sp) },
                        //label = @androidx.compose.runtime.Composable { Text(text = "Enter addition", fontSize = 30.sp) }, // Optional label for the text field
                        textStyle = TextStyle(fontSize = 30.sp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            unfocusedTextColor = Color(0xff888888),
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color(0xff222222),
                        )
                    )
                    Text(
                        text = "Result: " + calcFilter.add(addFirst,
                            addSecond),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                }

//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JUnit4Theme {
        Greeting("Android")
    }
}