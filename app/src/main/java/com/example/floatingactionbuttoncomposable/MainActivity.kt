package com.example.floatingactionbuttoncomposable

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.floatingactionbuttoncomposable.ui.theme.FloatingactionbuttoncomposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloatingactionbuttoncomposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyUi()
                }
            }
        }
    }
}

@Composable
fun MyUi() {
    // A FAB performs the most common actions on a screen.
    val context = LocalContext.current.applicationContext
    Box {
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.BottomEnd),
            shape = CircleShape,
            onClick = {
                Toast.makeText(context, "You clicked the fab", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Note "
            )

        }
    }
// Through this EAB we can get first text label and then icon in EAB
    Box(modifier = Modifier.fillMaxSize()){
       ExtendedFloatingActionButton(
           modifier = Modifier.align(Alignment.BottomStart),
           onClick = {
           Toast.makeText(context, "You clicked on Extended Floating Action Button", Toast.LENGTH_SHORT).show()
       }) {
           Text(text = "Search")
           Icon(imageVector = Icons.Filled.Search, contentDescription = "Add Note")
       }
    }

// Through this EAB we can get first icon and then Text horizontally

    Box(modifier = Modifier.fillMaxSize()){
        ExtendedFloatingActionButton(
            text = { Text(text = "Search") },
            icon = { Icon(imageVector = Icons.Filled.Search, contentDescription ="Add Note") },
            onClick = {
                Toast.makeText(context, "You clicked on Extended Floating Action Button", Toast.LENGTH_SHORT).show()
            })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FloatingactionbuttoncomposableTheme {
        MyUi()
    }
}