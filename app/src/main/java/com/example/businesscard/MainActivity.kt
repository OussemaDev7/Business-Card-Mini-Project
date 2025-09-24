package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Theme toggle state
            var isDarkTheme by remember { mutableStateOf(false) }

            BusinessCardTheme(darkTheme = isDarkTheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(
                        modifier = Modifier.padding(innerPadding),
                        isDarkTheme = isDarkTheme,
                        onToggleTheme = { isDarkTheme = !isDarkTheme }
                    )
                }
            }
        }
    }
}
@Composable
fun Card(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    onToggleTheme: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(
            onClick = onToggleTheme,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Text(
                text = if (isDarkTheme) "Dark" else "Light"
            )
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 125.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ana),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = if (isDarkTheme) Color.White else Color.Black,
                        shape = CircleShape
                    )
                    .shadow(
                        elevation = 8.dp,
                        shape = CircleShape
                    )
            )
            Text(
                text = "Dakhlaoui Oussema",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .sizeIn(minWidth = 60.dp, minHeight = 20.dp),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = if (isDarkTheme) Color.White else Color.Black,
                    fontSize = 24.sp
                ))
            Text(
                text = "A programmer in the making (hopefully) .",
                modifier = Modifier
                    .sizeIn(minWidth = 40.dp, minHeight = 15.dp),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    color = if (isDarkTheme) Color.White else Color.Black,
                    fontSize = 16.sp
            ))
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "phone Icon",
                        modifier = Modifier.size(40.dp),
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                    Text(
                        text = "+216 58 926 450",
                        modifier = Modifier.padding(start = 15.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (isDarkTheme) Color.White else Color.Black
                        )
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "email Icon",
                        modifier = Modifier.size(40.dp),
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                    Text(
                        text = "oussemadq3@gmail.com",
                        modifier = Modifier.padding(start = 15.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (isDarkTheme) Color.White else Color.Black
                        )
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "github Icon",
                        modifier = Modifier.size(40.dp),
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                    Text(
                        text = "OussemaDev7",
                        modifier = Modifier.padding(start = 15.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (isDarkTheme) Color.White else Color.Black
                        )
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "linkedin Icon",
                        modifier = Modifier.size(40.dp),
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                    Text(
                        text = "Oussema Dq",
                        modifier = Modifier.padding(start = 15.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (isDarkTheme) Color.White else Color.Black
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}
