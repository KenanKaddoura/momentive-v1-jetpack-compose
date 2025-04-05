package jetpack.cleanarchitecture.momentive.core.presentation

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.TasksScreen
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.AddEditSheet

@RequiresApi(35)
@Composable
fun NavGraph(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Tasks.route,
    ) {
        composable(Screen.Tasks.route) {
            TasksScreen(navController = navController)
        }
        composable(Screen.AddEditTaskSheet.route) {
            AddEditSheet(navController = navController)
        }
        composable(Screen.Notes.route) { }
        composable(Screen.Profile.route) { }
    }
}