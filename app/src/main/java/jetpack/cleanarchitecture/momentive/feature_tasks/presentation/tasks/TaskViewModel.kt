package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import kotlinx.coroutines.launch
import java.time.LocalDate

// mutableStateOf -> MutableStateFlow
// State -> StateFlow

@RequiresApi(Build.VERSION_CODES.O)
class TaskViewModel(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    private val _state = mutableStateOf(TaskState())
    val state: State<TaskState> = _state

    init {
        loadTasks()
    }

    fun onEvent(event: TaskEvent) {
        when (event) {
            is TaskEvent.ClickOnMoreActions -> TODO()
            is TaskEvent.EditTask -> TODO()
            is TaskEvent.NewTask -> {}
            is TaskEvent.SelectTask -> TODO()
            else -> {}
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadTasks() {
        viewModelScope.launch {
            taskUseCases.getTasksUseCase().collect { list ->
                    _state.value = state.value.copy(tasksList = list)
            }
        }
    }

}