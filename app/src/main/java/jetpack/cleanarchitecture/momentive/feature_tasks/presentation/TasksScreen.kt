package jetpack.cleanarchitecture.momentive.feature_tasks.presentation

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.TaskEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.tasks_components.AddEditSheet
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.tasks_components.TaskCard
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import kotlinx.coroutines.flow.collectLatest

@RequiresApi(26)
@Composable
fun TasksScreen(
    navController : NavHostController,
    viewModel: TaskViewModel,
    innerPadding: PaddingValues
) {

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->

            when(event) {
                is TaskViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
            }

        }
    }

    val taskState = viewModel.taskState.value

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {

        items(taskState.tasksList) { task ->
            TaskCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                title = task.title,
                description = task.description,
                priority = task.priority,
                date = task.date,
                selected = task in taskState.selectedTasksList,
                onClick = {
                    viewModel.onSheetEvent(AddEditEvent.OpenSheet(taskId = task.id))
                },
                onLongClick = {
                    viewModel.onTaskEvent(TaskEvent.SelectTask(task))
                }
            )

        }
        
    }


//    Conditionally State Bottom Sheet
    AddEditSheet(
        sheetStates = viewModel.sheetStates.value,
        onSheetEvent = viewModel::onSheetEvent
    )

}

