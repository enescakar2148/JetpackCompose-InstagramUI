package com.example.instagramclone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    //Full sayfa 
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "enescakar2148",
            modifier = Modifier.padding(10.dp)
        )
        //Boşluk
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        Buttons(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        StarStories(
            stories = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.story1),
                    text = "Me <3"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.stroy2),
                    text = "Motocyle"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.story3),
                    text = "Motocyle 2"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.story4),
                    text = ":)"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.story1),
                    painterResource(id = R.drawable.stroy2),
                    painterResource(id = R.drawable.story3),
                    painterResource(id = R.drawable.story4),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post6),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


//TopBar
@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    //Topbar items
    //Row
    Row(
        //Vertical ortalama
        verticalAlignment = Alignment.CenterVertically,
        //CSS'teki SpaceAroud
        horizontalArrangement = Arrangement.SpaceAround,

        //Modifier
        modifier = modifier
            .fillMaxWidth()

    ) {
        //Icon
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(25.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(25.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(25.dp)
        )
    }

}


//Profile Details
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Pp(
                image = painterResource(id = R.drawable.pp),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Counts(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        ProfileDescription(
            displayName = "enescakar2148",
            description = "Hi, I'm Enes! I have been developing software \n" +
                    "for 4 years. And I've been developing" +
                    " Android apps for 2 years.",
            url = "https://github.com/enescakar2148",
            followedBy = listOf("marceliinek", "prometheus"),
            otherCount = 16
        )
    }
}

//Pp Component
@Composable
fun Pp(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "Profile Photo",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

//Posts, Followers, Following Container
@Composable
fun Counts(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStatusTexts(numberText = "9", text = "Posts")
        ProfileStatusTexts(numberText = "393", text = "Followers")
        ProfileStatusTexts(numberText = "169", text = "Following")

    }
}

//Posts, Followers, Following Texts
@Composable
fun ProfileStatusTexts(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = text)
    }
}

//Bio
@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        //Eğer takip edilenler listesi boş değil ise
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    //HTML'deki span yapısı
                    //Burada span'a ait stil kodları değişkene atandı
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, followed ->
                        //Span style'nı atamak, göndermek
                        pushStyle(boldStyle)

                        //takip edilen kullanıcı ismini spana eklemek
                        append(followed)

                        //Bunu tam olarak anlamadım fakat anladığım kadarıyla
                        //gelen listedeki kelimenin bitip bitmediğini kontrol ediyor
                        pop()
                        if (index < followedBy.size - 1) {
                            append(" , ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }

}

//Buttons
@Composable
fun Buttons(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        CustomButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        CustomButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )

        CustomButton(
            text = "E-mail",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
        )

        CustomButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(height)
        )
    }
}

//Button
@Composable
fun CustomButton(
    text: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }

}

//Star Stories
@Composable
fun StarStories(
    modifier: Modifier = Modifier,
    stories: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(stories.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                Pp(
                    image = stories[it].image,
                    modifier = Modifier.size(70.dp)
                )

                Text(
                    text = stories[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

//TabView
@Composable
fun TabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}