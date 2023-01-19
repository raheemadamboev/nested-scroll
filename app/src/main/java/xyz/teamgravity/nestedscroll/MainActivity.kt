package xyz.teamgravity.nestedscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.teamgravity.nestedscroll.ui.theme.NestedScrollTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedScrollTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn {
                        item {
                            SubList1()
                        }

                        Sublist2()

                        item {
                            SubList1()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SubList1() {
    LazyRow {
        items(10) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .background(Color.Red)
            )
        }
    }
}

fun LazyListScope.Sublist2() {
    items(20) { index ->
        Text(
            text = index.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .border(BorderStroke(1.dp, Color.Red))
                .padding(20.dp)
        )
    }
}