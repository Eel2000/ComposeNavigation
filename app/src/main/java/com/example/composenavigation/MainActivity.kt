package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenavigation.destinations.HelpScreenDestination
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                    DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

@Composable
fun ApplicationMain(){

}

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
){
    Scaffold(
        topBar = {
            TopAppBar (
                title = { Text(text = "Home")},
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Toggle menu" )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More")
                    }
                },
                elevation = 15.dp
            )
        }
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Home page")
            Button(onClick = {
                navigator.navigate(
                    HelpScreenDestination()
                )
            }) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Help")
            }
        }
    }
}

@Destination
@Composable
fun HelpScreen(
    navigator: DestinationsNavigator
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Helps")},
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back ")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Share, contentDescription = "share this content")
                    }
                },
                elevation = 17.dp,
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Help page",
                color = Color.Black
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNavigationTheme {
        Greeting("Android")
    }
}

/*@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    ComposeNavigationTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HelpScreenPreview(){
    ComposeNavigationTheme {
        HelpScreen()
    }
}*/