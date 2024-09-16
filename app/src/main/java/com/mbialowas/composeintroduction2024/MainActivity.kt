package com.mbialowas.composeintroduction2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbialowas.composeintroduction2024.ui.theme.ComposeIntroduction2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeIntroduction2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Counter(modifier = Modifier.padding(innerPadding))
                        Switcher()
                        CustomList(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun Counter(modifier:Modifier = Modifier){
//    var counter = 0
    var counter by remember {
        mutableStateOf(99)
    }
    Button(
        modifier = modifier,
        onClick = {
            counter += 1
        }
    ){
      Text(text="This button has been clicked $counter times.")
    }
}

@Composable
fun Switcher(){
    var checked = remember {
        mutableStateOf(false)
    }
    Column{
        Switch(
            checked = checked.value,
            onCheckedChange = {checked.value = it }
        )
        if(checked.value){
            Text(text = "Switch is checked")
        }else{
            Text(text = "Switch is not checked")
        }
    }
}

@Composable
fun CustomList(modifier: Modifier = Modifier){
    modifier.border(width=2.dp, color= Color.Green)
        .padding(16.dp)
    var itemsList = List(20){"Control: $it"}

    LazyColumn(modifier = modifier){
        items(itemsList){item ->
            Text(text = item, modifier = modifier)
        }
    }
}

