package com.odhiambodevelopers.shopping

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odhiambodevelopers.shopping.ui.theme.Orange
import com.odhiambodevelopers.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        ToolBar()

                    }
                }
            }
        }
    }
}

@Composable
fun ToolBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Shopping Bag",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = Color.White,
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        },
        actions = {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
        }
    )
}

@Composable
fun CartItem(
    // declaring card item modifier
    modifier: Modifier = Modifier
) {
    //wraping composables in a card
    Card(
        modifier = modifier
            .height(130.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    )
    {
        //using row layout to arrange the elements
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f)
                    .clip(shape = RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.pic),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.9f),

                ) {
                Text(
                    text = "Cotton Dress",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$250.00",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "1",
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                }
            }
            // using column layout to arrange the elements
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "B", fontSize = 16.sp)
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }

        }
    }

}

@Composable
fun PromoCard(
    modifier: Modifier = Modifier
) {
    Card(
        //setting card properties
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.LightGray,
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        // arranging elements in row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 8.dp),
                text = "Promo Code",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.6f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(text = "Apply", color = Color.White)
            }
        }
    }
}

@Composable
fun CartList() {
    LazyColumn {
        items(3) {
            CartItem(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun OtherDetails() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "Sub Total  -------------------------------------------",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier
                    .padding(end = 16.dp),
                text = "$250.00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "Shipping  -------------------------------------------",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier
                    .padding(end = 16.dp),
                text = "$4.00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "Bag Total  -------------------------------------------",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier
                    .padding(end = 16.dp),
                text = "$250.00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Orange
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Orange)
        ) {
            Text(text = "Proceed to checkout", color = Color.White, fontSize = 16.sp)
        }
    }
}



@Preview(name = "Light Mode",showBackground = true,
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ShoppingTheme {
        Column {
            ToolBar()
            CartList()
            PromoCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OtherDetails()

        }
    }
}