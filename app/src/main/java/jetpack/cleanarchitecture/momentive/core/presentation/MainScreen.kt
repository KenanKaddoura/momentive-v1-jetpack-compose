package jetpack.cleanarchitecture.momentive.core.presentation

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import jetpack.cleanarchitecture.momentive.core.presentation.components.BottomNavBar
import jetpack.cleanarchitecture.tasknote.core.presentation.components.TopNavBar

@RequiresApi(35)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { TopNavBar(title = "Tasks", onSettingsClick = { /*TODO*/ }, onMoreClick = {}) },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddEditTaskSheet.route) },
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.tertiary) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) {
        NavGraph(navController)
    }
}

@RequiresApi(35)
@Preview()
@Composable
fun Preview()  {
    MainScreen()
}
