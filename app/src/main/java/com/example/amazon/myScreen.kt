import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amazon.R
import com.example.amazon.allcat
import com.example.amazon.myProducts
import com.example.amazon.ui.theme.Purple
import com.example.amazon.ui.theme.deepSky
import com.example.amazon.ui.theme.lightPurple

class myScreen {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Preview
    @Composable
    fun MyScreen() {
        val lazyliststate= rememberLazyListState()
        var searchText by remember { mutableStateOf("") }
        val bottomBarHeight = 48.dp
        val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
        val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

        // Connection to the nested scroll system and listen to the scroll
        // happening inside child LazyColumn
        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    val delta = available.y
                    val newOffset = bottomBarOffsetHeightPx.value + delta
                    bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                    return Offset.Zero
                }
            }
        }
        //var bottomBarHeight by remember { mutableStateOf(56.dp) }
        val bottomAppBarColor = MaterialTheme.colorScheme.surface.copy(alpha = 1 - (-bottomBarOffsetHeightPx.value / bottomBarHeightPx))
        Scaffold(
            Modifier.nestedScroll(nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {},
                    actions = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                        ) {
                            OutlinedTextField(
                                value = searchText,
                                onValueChange = { searchText = it },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                placeholder = {
                                    Row {
                                        Icon(Icons.Default.Search, contentDescription = "Search")
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(text = "Search Amazon.in")
                                        Spacer(modifier = Modifier.weight(1f)) // Adjust the weight as needed for spacing
                                        Image(
                                            painter = painterResource(id = R.drawable.lens), // Replace 'menu_icon' with your actual image resource
                                            contentDescription = "Menu",
                                            modifier = Modifier
                                                .size(30.dp)
                                                .clickable { /* Handle navigation icon click */ }
                                        )
                                    }
                                },
                                singleLine = true,
                                colors = TextFieldDefaults.textFieldColors(
                                    //backgroundColor = Color.Transparent,
                                    containerColor = Color.White,
                                    cursorColor = MaterialTheme.colorScheme.onSurface,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                )
                            )
                        }
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Purple
                    ),
                    modifier = Modifier.height(100.dp) // Adjust the height of the TopAppBar
                )
            },
            bottomBar = {

                BottomAppBar(modifier = Modifier
                    .animateContentSize(animationSpec = tween(durationMillis = 300))
                    .height(height = if (lazyliststate.isScrollInProgress) 0.dp else 48.dp),
                    containerColor = Purple
                    ) {
                    IconButton(
                        onClick = {
                            //coroutineScope.launch { scaffoldState.drawerState.open()
                            //coroutineScope.launch{}
                        },
                        modifier=Modifier.weight(1f)
                    ) {
                        Icon(Icons.Outlined.Home, contentDescription = "Localized description", tint = Color.White)
                    }
                    IconButton(
                        onClick = {
                            //coroutineScope.launch { scaffoldState.drawerState.open()
                            //coroutineScope.launch{}
                        },
                        modifier=Modifier.weight(1f)
                    ) {
                        Icon(Icons.Outlined.Person, contentDescription = "Localized description",tint = Color.White)
                    }
                    IconButton(
                        onClick = {
                            //coroutineScope.launch { scaffoldState.drawerState.open()
                            //coroutineScope.launch{}
                        },
                        modifier=Modifier.weight(1f)
                    ) {
                        Icon(Icons.Outlined.ShoppingCart, contentDescription = "Localized description",tint = Color.White)
                    }
                    IconButton(
                        onClick = {
                            //coroutineScope.launch { scaffoldState.drawerState.open()
                            //coroutineScope.launch{}
                        },
                        modifier=Modifier.weight(1f)
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description",tint = Color.White)
                    }
                }
            }
        ) { innerPadding ->
            // Main content of the screen
            LazyColumn(content = {
                item {
                    Row(
                        modifier = Modifier
                            .background(lightPurple)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.weight(1f),
                            tint = Color.White
                        )
                        Text(
                            text = "Delivering to Kolkata 700014-Update location",
                            modifier = Modifier.weight(5f),
                            fontSize = 13.sp,
                            color = Color.White
                        )
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "bottom bar",
                            modifier = Modifier.weight(1f),
                            tint = Color.White
                        )
                    }
                }
                //chil/card start
                item {
                    LazyRow(
                        content = {
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.mobile),
                                    text = "Mobiles"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.electronics),
                                    text = "Electrical"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.pan),
                                    text = "Grocery"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.garments),
                                    text = "Fashion"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.boot),
                                    text = "Home"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.mobile),
                                    text = "MiniTV"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.mobile),
                                    text = "Mobiles"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.mobile),
                                    text = "Deals"
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            item {
                                typeChip(
                                    image = painterResource(id = R.drawable.mobile),
                                    text = "Books"
                                )
                            }

                        },
                        modifier = Modifier.padding(5.dp)
                    )
                }
                item {
                    photoChange()
                }
                item {
                    LazyRow(content = {
                        item {
                            card2(
                                myimage1 = painterResource(id = R.drawable.amazonpay),
                                myimage2 = painterResource(id = R.drawable.sendmoney) ,
                                myimage3 = painterResource(id = R.drawable.scanner2),
                                myimage4 = painterResource(id = R.drawable.recharge),
                                text1 = "Amazon Pay",
                                text2 = "Send Money",
                                text3 = "Scan any QR",
                                text4 ="Recharge & Bills"
                            )
                        }
                        item {
                            card3("55% off", painterResource(id = R.drawable.banner1))
                        }
                        item {
                            card3("70% off", painterResource(id = R.drawable.tea2))
                        }
                        item {
                            card2(
                                myimage1 = painterResource(id = R.drawable.earbud),
                                myimage2 = painterResource(id = R.drawable.mobile2) ,
                                myimage3 = painterResource(id = R.drawable.smartwatch),
                                myimage4 = painterResource(id = R.drawable.keyboard),
                                text1 = "Starting 99",
                                text2 = "Starting 5000",
                                text3 = "Under 999",
                                text4 ="Under 499"
                            )
                        }
                        item {
                            card3("40% off", painterResource(id = R.drawable.tea3))
                        }
                        item {
                            card3("20% off", painterResource(id = R.drawable.tea5))
                        }
                    }
                    )
                }
                item {
                    Row(modifier=Modifier.fillMaxWidth()) {
                        Row (modifier= Modifier
                            .weight(1f)
                            .clickable { }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                            Image(
                                painter = painterResource(id = R.drawable.selection), // Replace 'menu_icon' with your actual image resource
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .clickable { /* Handle navigation icon click */ }
                            )
                            Text(text = "Wide Selection", fontSize = 12.sp)
                        }
                        Row (modifier= Modifier
                            .weight(1f)
                            .clickable { }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                            Image(
                                painter = painterResource(id = R.drawable.cashondelivary), // Replace 'menu_icon' with your actual image resource
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .clickable { /* Handle navigation icon click */ }
                            )
                            Text(text = "Pay On Delivary", fontSize = 12.sp)
                        }
                        Row (modifier= Modifier
                            .weight(1f)
                            .clickable { }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                            Image(
                                painter = painterResource(id = R.drawable.easyreturns), // Replace 'menu_icon' with your actual image resource
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .clickable { /* Handle navigation icon click */ }
                            )
                            Text(text = "Easy Return", fontSize = 12.sp)
                        }
                    }
                }
                item {
                    Text(text =
                    "Unlock a world of benefits with Amazon Prime! Enjoy unlimited fast, free shipping on millions of items, exclusive access to movies, TV shows, ad-free music streaming, unlimited photo storage, and so much more. Try Amazon Prime today and experience the convenience, savings, and entertainment it offers. Start your free trial now!",
                        maxLines = 1,
                        modifier = Modifier.basicMarquee(),
                        color = deepSky,
                        fontWeight = FontWeight.Bold)
                }
                item {
                    Divider(modifier= Modifier
                        .fillMaxWidth()
                        .height(2.dp), color = Color.LightGray)
                }
                item {
                    Image(painter = painterResource(id = R.drawable.ad), contentDescription = "ad")
                }
                item {
                    Divider(modifier= Modifier
                        .fillMaxWidth()
                        .height(2.dp), color = Purple)
                }
                item {
                    Text(text = "Up to 60% off | 4 star rated products from great bands", fontWeight = FontWeight.Bold,color= Purple, fontSize = 14.sp, lineHeight = 16.sp, modifier = Modifier.padding(6.dp))
                    myProducts().products()
                }
                item {
                    myProducts().products()
                }
                item {
                    myProducts().products()
                }
                item {
                    myProducts().products()
                }
                item {
                    myProducts().products()
                }
                item {
                    allcat().allcategories()
                }

            }, modifier = Modifier.padding(innerPadding),
                state = lazyliststate)
        }
    }
}

@Composable
fun typeChip(image: Painter, text: String) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .width(65.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp, start = 8.dp)
        ) {
            Image(
                painter = image,
                contentDescription = text,
                modifier = Modifier.size(50.dp)
            )
            Text(text = text)
        }
    }
}

@Composable
fun photoChange() {
    var index by remember { mutableStateOf(0) }
    val imageList = listOf(
        painterResource(id = R.drawable.banner5),
        painterResource(id = R.drawable.banner2),
        painterResource(id = R.drawable.banner6)
    )

    Image(
        painter = imageList[index],
        contentDescription = "",
        modifier = Modifier
            .height(200.dp)
            .width(400.dp)
            .clickable {
                // Update the index when the image is clicked
                index = (index + 1) % imageList.size
            }
    )
}

@Composable
fun card2(myimage1:Painter,myimage2:Painter,myimage3:Painter,myimage4:Painter,text1:String,text2:String,text3:String,text4:String) {
    ElevatedCard(modifier= Modifier
        .size(180.dp)
        .padding(10.dp),colors = CardDefaults.cardColors(Color.White), ) {
        Column(modifier=Modifier.weight(1f)) {
            Row(modifier=Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp, start = 8.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = myimage1, // Replace 'menu_icon' with your actual image resource
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle navigation icon click */ }
                    )
                    Text(text = text1, fontSize = 10.sp)
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp, start = 8.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = myimage2, // Replace 'menu_icon' with your actual image resource
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle navigation icon click */ }
                    )
                    Text(text = text2,fontSize = 10.sp)
                }
            }
            Row(modifier=Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp, start = 8.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = myimage3, // Replace 'menu_icon' with your actual image resource
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle navigation icon click */ }
                    )
                    Text(text = text3,fontSize = 10.sp)
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp, start = 8.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = myimage4, // Replace 'menu_icon' with your actual image resource
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable { /* Handle navigation icon click */ }
                    )
                    Text(text = text4,fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun card3(customText:String,myimage:Painter) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 10.dp) // Background color of the card
    ) {
        // Add your image content here
        Image(
            painter = myimage, // Replace with your image resource
            contentDescription = null, // Content description for accessibility
            contentScale = ContentScale.Crop, // Adjust the content scale as needed
            modifier = Modifier
                .width(110.dp)
                .height(150.dp)// Occupy the entire space of the Box
        )
        // Add any other content you want on top of the image
        Card(modifier=Modifier.align(Alignment.TopEnd), colors = CardDefaults.cardColors(Color.Red)) {
            Text(
                text = customText,
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(2.dp),
                fontWeight = FontWeight.Bold
            )
        }
}
}



