package jetpack.cleanarchitecture.momentive.core.presentation

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.TaskViewModel
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.TasksScreen

@RequiresApi(26)
@Composable
fun NavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
    taskViewModel: TaskViewModel) {

    NavHost(
        navController = navController,
        startDestination = Screen.Tasks.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Tasks.route) {
            TasksScreen(
                navController = navController,
                innerPadding = innerPadding,
                viewModel = taskViewModel
            )

        }
        composable(Screen.Notes.route) { }
        composable(Screen.Profile.route) { }
    }
}