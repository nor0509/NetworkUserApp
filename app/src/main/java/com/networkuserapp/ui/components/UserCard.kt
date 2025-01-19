package com.networkuserapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.ui.theme.Ivory
import com.networkuserapp.ui.theme.Pewter

@Composable
fun UserCard(
    user: UserEntity,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable(onClick = { /*todo*/ })
            .background(
                color = Ivory,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(84.dp)
                .weight(1f)
                .background(
                    color = Pewter,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person Icon",
                tint = Ivory,
                modifier = Modifier.size(48.dp)
            )
        }
        Row(
            modifier = Modifier.weight(4f)
        ) {
            Column(modifier = Modifier.padding(12.dp).weight(3f)) {
                Text(
                    text = user.name,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "@${user.username}",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                )
                HorizontalDivider()
                Text(
                    text = "Based in ${user.city}",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                )
            }

            Box(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .weight(1.5f)
                    .clickable(onClick = { /*todo*/ })
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Connect",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        color = Ivory
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserCard() {
    val sampleUser = UserEntity(
        id = 435,
        name = "Anthony Johnson",
        username = "patriciagarcia",
        email = "johnbecker@hotmail.com",
        street = "Erin Centers",
        suite = "Apt. 206",
        city = "West Sarahchester",
        zipcode = "30538",
        geoLat = "40.0868375",
        geoLng = "4.377411",
        phone = "001-914-774-1641",
        website = "https://burton.info/",
        companyName = "Joseph Ltd",
        companyCatchPhrase = "Intuitive intermediate moderator",
        companyBs = "synergize 24/365 e-commerce"
    )

    UserCard(
        user = sampleUser,
    )
}
