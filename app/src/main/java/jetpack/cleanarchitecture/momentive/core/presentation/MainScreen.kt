package jetpack.cleanarchitecture.momentive.core.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import jetpack.cleanarchitecture.momentive.core.presentation.components.BottomNavBar
import jetpack.cleanarchitecture.momentive.feature_tasks.container.TaskContainer
import jetpack.cleanarchitecture.momentive.feature_tasks.container.TaskViewModelFactory
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.TaskViewModel
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import jetpack.cleanarchitecture.tasknote.core.presentation.components.TopNavBar

@RequiresApi(26)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(TaskContainer.instance.useCases)
    )

    Scaffold(
        topBar = { TopNavBar(title = "Tasks", onSettingsClick = { /*TODO*/ }, onMoreClick = {}) },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          taskViewModel.onSheetEvent(AddEditEvent.OpenSheet(0))
                },
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.tertiary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
            }
        }
    ) {innerPadding ->

        NavGraph(
            navController = navController,
            innerPadding = innerPadding,
            taskViewModel = taskViewModel
        )
    }


}
