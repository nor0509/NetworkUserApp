package com.networkuserapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.networkuserapp.data.local.entity.UserEntity


@Composable
fun UserList(
    users: List<UserEntity>,
    onCardClick: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users.size) { index ->
            UserCard(
                user = users[index],
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onCardClick(users[index].id.toString()) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserList() {
    val sampleUsers = listOf(
        UserEntity(
            id = 1,
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
        ),
        UserEntity(
            id = 2,
            name = "Jane Smith",
            username = "janesmith",
            email = "janesmith@example.com",
            street = "Pine Road",
            suite = "Suite 101",
            city = "East Springfield",
            zipcode = "45678",
            geoLat = "35.176545",
            geoLng = "3.234500",
            phone = "001-123-456-7890",
            website = "https://janesmith.com",
            companyName = "TechCorp",
            companyCatchPhrase = "Innovating technology solutions",
            companyBs = "cutting-edge IT services"
        )
    )

    UserList(
        users = sampleUsers,
        onCardClick = { userId -> println("Card clicked for user: $userId") }
    )
}