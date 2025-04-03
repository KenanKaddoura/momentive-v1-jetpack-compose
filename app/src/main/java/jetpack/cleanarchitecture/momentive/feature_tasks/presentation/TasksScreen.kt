package jetpack.cleanarchitecture.momentive.feature_tasks.presentation

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import jetpack.cleanarchitecture.momentive.core.presentation.Screen
import jetpack.cleanarchitecture.momentive.feature_tasks.container.TaskContainer
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskViewModel
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.components.TaskCard

@RequiresApi(35)
@Composable
fun TasksScreen(
    viewModel : TaskViewModel = TaskContainer.instance.taskViewModel,
    navController : NavHostController
) {

    val state = viewModel.state.value

    LazyColumn(modifier = Modifier.fillMaxSize().offset(y = 80.dp)) {

        items(state.tasksList) {task ->
            TaskCard(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                title = task.title,
                description = task.description,
                priority = task.priority,
                date = task.date,
                selected = task in state.selectedTasksList,
                onClick = {
                    navController.navigate(Screen.AddEditTaskSheet.route)
                },
                onLongClick = {
                    viewModel.onEvent(TaskEvent.SelectTask(task))
                }
            )

        }
        
    }
    


}