package com.mbialowas.composeintroduction2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbialowas.composeintroduction2024.ui.theme.ComposeIntroduction2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeIntroduction2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Counter(modifier = Modifier.padding(innerPadding))
                        Switcher()
                        //CustomList()
                        //CustomGrid()
                        MyCheckbox()
                    }

                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier){

//    var counter: Int = 0
    var counter by remember{
        mutableStateOf(10)
    }

    Button(
        onClick = {
            counter += 1
        }) {
            Text(text="This button has been clicked $counter times.")
        }
}

@Composable
fun Switcher(){
    val checked = remember{ mutableStateOf(false)}
    Column(){
        Switch(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }
        )
        if (checked.value){
            Text(text = "Switch is checked")
        } else {
            Text(text = "Switch is not checked")
        }

    }
}

@Composable
fun CustomList(){
    val itemList = List(200){"Control $it"}
    LazyColumn{
        items(itemList){ item ->
            Text(text = item)
        }
    }
}
@Composable
fun CustomGrid(){
    val itemsList = List(50){"Item $it"}

    LazyVerticalGrid(
        columns = GridCells.Fixed(5), // 5 columns in grid
        modifier = Modifier.fillMaxSize()
    ) {
        items(itemsList) { item ->
            GridItem(item)
        }
    }
}

@Composable
fun GridItem(itemText: String) {
    Box(
      modifier = Modifier
          .size(100.dp)
          .background(Color.Gray)
          .border(2.dp, Color.Red),
        contentAlignment = Alignment.Center
    ){
        Text(
            text=itemText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
@Composable
fun MyCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

