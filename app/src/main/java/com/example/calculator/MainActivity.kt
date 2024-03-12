package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.BtnColor
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Calculator()

                }
            }
        }
    }
}


@Composable
fun IconBtn(text: MutableState<String>, iconID: Int, value: String, description: String ) {
    val maxInput = 20
    IconButton(onClick = {
        if  (text.value.length <= maxInput) { text.value += value }
    },
        modifier = Modifier
            .size(70.dp)
            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)

    ) {
        Icon(
            painter = painterResource(id = iconID),
            contentDescription = description,
            modifier = Modifier.size(40.dp),
            tint = Color.DarkGray
        )
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Calculator () {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF3F3F3), // Start color
                        Color(0xFF8D8D8D)  // End color

                    )
                )
            )
    )
    Column(
        modifier = Modifier
//            .wrapContentSize()
            .fillMaxSize()
            .padding(20.dp)
            ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val calculation = remember { mutableStateOf("calculations") }
        val expression by remember { mutableStateOf("expression") }

        Box(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ){
            Text(text = expression)
        }
        Text(text = calculation.value, fontSize = 38.sp, textAlign = TextAlign.End,
            modifier = Modifier
                .wrapContentHeight()
                .height(140.dp)
                .fillMaxWidth(),
            lineHeight = 40.sp

        )
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 3.dp,
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

//            IconBtn(
//                text = calculation,
//                iconID = R.drawable.trash3,
//                description = "clear")

            IconButton(onClick = { calculation.value = "" },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.trash3),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray

                )

            }
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
            ) {
                Icon(painter = painterResource(id = R.drawable.slash_lg),
                    contentDescription = "Divider",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray
                )
            }
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray
                )

            }
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)

            ) {
                Icon(
                    painterResource(id = R.drawable.backspace),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val digits: MutableList<String> = mutableListOf("7", "8", "9")
            val iconsIDs : MutableList<Int> = mutableListOf(
                R.drawable.square_7,
                R.drawable.square_8,
                R.drawable.square_9,
            )

            for( i in 0..2)
            {
                IconBtn(
                    text = calculation,
                    iconID = iconsIDs[i],
                    value = digits[i],
                    description = "digit"
                )
            }
//            IconButton(onClick = { calculation.value += "7" },
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.square_7),
//                    contentDescription = "Favorite",
//                    modifier = Modifier.size(40.dp),
//                    tint = Color.DarkGray
//                )
//
//            }
//            IconButton(onClick = { calculation.value += "8" },
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(painter = painterResource(id = R.drawable.square_8),
//                    contentDescription = "Divider",
//                    modifier = Modifier.size(40.dp)
//                )
//            }
//            IconButton(onClick = { calculation.value += "9"},
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.square_9),
//                    contentDescription = "Favorite",
//                    modifier = Modifier.size(40.dp),
//                    tint = Color.DarkGray
//
//                )
//
//            }
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
            ) {
                Icon(
                    painterResource(id = R.drawable.dash_lg),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray

                )

            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val digits: MutableList<String> = mutableListOf("4", "5", "6")
            val iconsIDs : MutableList<Int> = mutableListOf(
                R.drawable.square_4,
                R.drawable.square_5,
                R.drawable.square_6,
                )

            for( i in 0..2)
            {
                IconBtn(
                    text = calculation,
                    iconID = iconsIDs[i],
                    value = digits[i],
                    description = "digit"
                )
            }
//            IconButton(onClick = { calculation.value += "4"},
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.square_4),
//                    contentDescription = "Favorite",
//                    modifier = Modifier.size(40.dp)
//                )
//
//            }
//            IconButton(onClick = { calculation.value += "5" },
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(painter = painterResource(id = R.drawable.square_5),
//                    contentDescription = "Divider",
//                    modifier = Modifier.size(40.dp)
//                )
//            }
//            IconButton(onClick = { calculation.value += "6" },
//                modifier = Modifier
//                    .size(70.dp)
//                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.square_6),
//                    contentDescription = "Favorite",
//                    modifier = Modifier.size(40.dp)
//                )
//
//            }
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                    .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(40.dp),
                    tint = Color.DarkGray
                    
                )

            }
        }
        Row(
            modifier = Modifier
//                .wrapContentHeight()
                .fillMaxWidth()
                .height(153.dp),
//                .background(color = Color.Green),
            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {

                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.square_1,
                        value = "1",
                        description = "digit 1"
                    )
//                    IconButton(
//                        onClick = {
//                            if  (calculation.value.length <= maxInput) { calculation.value += "1" }
//                                  },
//                        modifier = Modifier
//                            .size(70.dp)
//                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.square_1),
//                            contentDescription = "Favorite",
//                            modifier = Modifier.size(40.dp)
//                        )
//
//                    }

                }

                Row {
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(70.dp)
                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.percent),
                            contentDescription = "Favorite",
                            modifier = Modifier.size(40.dp),
                            tint = Color.DarkGray
                        )
                    }
                }

            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.square_2,
                        value = "2",
                        description = "digit 2"
                    )
//                    IconButton(onClick = { calculation.value += "2" },
//                        modifier = Modifier
//                            .size(70.dp)
//                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//                    ) {
//                        Icon(painter = painterResource(id = R.drawable.square_2),
//                            contentDescription = "Divider",
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }

                }
                Row {
                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.square_0,
                        value = "0",
                        description = "digit 0"
                    )
//                    IconButton(onClick = {calculation.value += "0" },
//                        modifier = Modifier
//                            .size(70.dp)
//                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//                    ) {
//                        Icon(painter = painterResource(id = R.drawable.square_0),
//                            contentDescription = "Divider",
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }

                }

            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {

                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.square_3,
                        value = "3",
                        description = "digit 3"
                    )
//                    IconButton(onClick = { calculation.value += "3"},
//                        modifier = Modifier
//                            .size(70.dp)
//                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.square_3),
//                            contentDescription = "Favorite",
//                            modifier = Modifier.size(40.dp)
//                        )
//
//                    }
                }

                Row {
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(70.dp)
                            .background(color = BtnColor, shape = MaterialTheme.shapes.medium)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.dice_1),
                            contentDescription = "Favorite",
                            modifier = Modifier.size(40.dp),
                            tint = Color.DarkGray
                        )

                    }
                }

            }
            Column {
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(70.dp)
                        .fillMaxHeight()
                        .background(color = BtnColor, shape = MaterialTheme.shapes.medium)

                ) {
                    Icon(
                        painterResource(id = R.drawable.equal_icon),
                        contentDescription = "Favorite",
                        modifier = Modifier.size(40.dp),
                        tint = Color.DarkGray

                    )

                }

            }

        }

    }
}


