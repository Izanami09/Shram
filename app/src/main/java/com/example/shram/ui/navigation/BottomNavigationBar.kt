package com.example.shram.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shram.ui.presenation.ShramViewModel
import com.google.android.gms.wallet.Wallet

data class BottomNavigation(
    val title: String,
    val icon: ImageVector
)
val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavigation(
        title = "Feed",
        icon = Icons.Rounded.LocationOn
    ),

    BottomNavigation(
        title = "LeaderBoard",
        icon = Icons.TwoTone.Face
    ),

    BottomNavigation(
        title = "User",
        icon = Icons.Rounded.AccountCircle
    )
)
@Composable
fun BottomNavigationBar(
    navController: NavController,
    viewModel: ShramViewModel
) {
    NavigationBar {
        var selectedTabIndex by remember { mutableStateOf(0) }
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {

            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                        navigateToDestination(navController, index, viewModel)
                              },
                    icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = if (index == selectedTabIndex) {
                                    MaterialTheme.colorScheme.primary // Change the tint for the selected icon
                                } else {
                                    MaterialTheme.colorScheme.onBackground
                                }
                            )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }

        }
    }
}

private fun navigateToDestination(navController: NavController, index: Int, viewModel: ShramViewModel) {
    when (index) {
        0 -> navController.navigate(Screen.HomeScreen.name)
        1 -> {
            navController.navigate(Screen.ShramFeed.name)
            viewModel.getAllShram()
        }
        2 -> navController.navigate(Screen.MapScreen.name)
        3 -> navController.navigate(Screen.Register.name)
        // Add more cases as needed
    }
}