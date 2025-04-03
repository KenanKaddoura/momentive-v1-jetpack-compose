package jetpack.cleanarchitecture.momentive.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import jetpack.cleanarchitecture.momentive.R
import jetpack.cleanarchitecture.momentive.core.presentation.Screen
import jetpack.cleanarchitecture.tasknote.core.presentation.util.BottomNavItem

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = Screen.Profile.route
        ),
        BottomNavItem(
            title = "Tasks",
            icon = ImageVector.vectorResource(R.drawable.ic_tasks),
            route = Screen.Tasks.route
            ),
        BottomNavItem(
            title = "Notes",
            icon = ImageVector.vectorResource(R.drawable.ic_notes),
            route = Screen.Notes.route
        )
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(containerColor = MaterialTheme.colorScheme.onTertiary) {
        items.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { navController.navigate(navItem.route) },
                icon = { Icon(navItem.icon, contentDescription = navItem.title, tint = MaterialTheme.colorScheme.tertiary) },
                label = { Text(text = navItem.title, color = MaterialTheme.colorScheme.tertiary) }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarNavPreview() {
    BottomNavBar(rememberNavController())
}

