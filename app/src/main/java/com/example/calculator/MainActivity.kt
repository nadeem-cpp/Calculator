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
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.BgColor1
import com.example.calculator.ui.theme.BgColor2
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
                        BgColor1, BgColor2
                    )
                )
            )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val calculation = remember { mutableStateOf("") }
        val helper = remember { mutableDoubleStateOf(0.0) }
        var operator by remember { mutableStateOf("") }

        Box(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ){
            Text(text = "${ helper.doubleValue }")
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
            IconButton(
                onClick = {
                    helper.doubleValue = calculation.value.toDouble()
                    calculation.value = ""
                    operator = "/"
                          },
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
            IconButton(
                onClick = {
                    helper.doubleValue = calculation.value.toDouble()
                    calculation.value = ""
                    operator = "*"
                },
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
            IconButton(
                onClick = {
                    helper.doubleValue = calculation.value.toDouble()
                    calculation.value = ""
                    operator = "-"
                          },
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
            IconButton(
                onClick = {
                    helper.doubleValue = calculation.value.toDouble()
                    calculation.value = ""
                    operator = "+"
                          },
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
                .fillMaxWidth()
                .height(153.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
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
                }

                Row {
                    IconButton(
                        onClick = {
                            helper.doubleValue = calculation.value.toDouble()
                            calculation.value = ""
                            operator = "%"
                                  },
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

                }
                Row {
                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.square_0,
                        value = "0",
                        description = "digit 0"
                    )

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
                }

                Row {
                    IconBtn(
                        text = calculation,
                        iconID = R.drawable.dice_1,
                        value = "." ,
                        description = "dot"
                    )
                }

            }
            Column {
                IconButton(
                    onClick = {

                        when (operator) {
                            "+" -> {
                                calculation.value = "${ helper.doubleValue + calculation.value.toDouble() }"
                            }
                            "-" -> {
                                calculation.value = "${ helper.doubleValue - calculation.value.toDouble() }"
                            }
                            "*" -> {
                                calculation.value = "${ helper.doubleValue * calculation.value.toDouble() }"
                            }
                            "/" -> {
                                calculation.value = "${ helper.doubleValue / calculation.value.toDouble() }"
                            }
                            "%" -> {
                                calculation.value = "${ (helper.doubleValue / calculation.value.toDouble()) * 100 }"
                            }
                        }
                              },
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


