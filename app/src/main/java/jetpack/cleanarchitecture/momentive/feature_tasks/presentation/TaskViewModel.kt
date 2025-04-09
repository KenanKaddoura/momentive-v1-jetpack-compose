package jetpack.cleanarchitecture.momentive.feature_tasks.presentation

import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.TaskEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.states.AddEditState
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.states.TaskState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

// mutableStateOf -> MutableStateFlow
// State -> StateFlow

@RequiresApi(26)
class TaskViewModel(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    private val _taskState = mutableStateOf(TaskState())
    val taskState: State<TaskState> = _taskState

    private val _sheetStates = mutableStateOf(AddEditState())
    val sheetStates: State<AddEditState> = _sheetStates

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        loadTasks()
    }

    fun onTaskEvent(event: TaskEvent) {
        when (event) {
            is TaskEvent.ClickOnMoreActions -> TODO()
            is TaskEvent.EditTask -> {
            }
            is TaskEvent.NewTask -> {

            }
            is TaskEvent.SelectTask -> {
                _taskState.value = taskState.value.copy(
                    selectedTasksList = taskState.value.selectedTasksList + event.task
                )
            }
        }
    }


    fun onSheetEvent(event: AddEditEvent) {
        when(event) {
            is AddEditEvent.EnterTitleText -> {
                _sheetStates.value = sheetStates.value.copy(
                    titleTextField = sheetStates.value.titleTextField.copy(
                        text = event.text
                    )
                )
            }
            is AddEditEvent.EnterDescriptionText -> {
                _sheetStates.value = sheetStates.value.copy(
                    descriptionTextField = sheetStates.value.descriptionTextField.copy(
                        text = event.text
                    )
                )
            }
            is AddEditEvent.ChangeTitleFocus -> {
                _sheetStates.value = sheetStates.value.copy(
                    titleTextField = sheetStates.value.titleTextField.copy(
                        isHintVisible = !event.focusState.isFocused &&
                                sheetStates.value.titleTextField.text.isBlank()
                    )
                )
            }
            is AddEditEvent.ChangeDescriptionFocus -> {
                _sheetStates.value = sheetStates.value.copy(
                    descriptionTextField = sheetStates.value.descriptionTextField.copy(
                        isHintVisible = !event.focusState.isFocused &&
                                sheetStates.value.descriptionTextField.text.isBlank()
                    )
                )
            }
            is AddEditEvent.ChoosePriority -> {
                _sheetStates.value = sheetStates.value.copy(
                    priorityChosen = event.priority
                )
            }
            is AddEditEvent.ChooseDate -> {
                _sheetStates.value = sheetStates.value.copy(
                    date = event.date
                )
            }
            is AddEditEvent.OpenSheet -> {

                // taskId has  three cases: 1) null = error, 2) 0 = new task, 3) >= 1 = overwrite and existing task.

                if (event.taskId == 0) { // create a new task

                    // The sheet states's must have a new initialisation, empty fields ..

                    _sheetStates.value = mutableStateOf(AddEditState(
                        isSheetVisible = true
                    )).value


                } else if (event.taskId!! >= 1) { // Edit an existing task

                    viewModelScope.launch {

                        // Populate the sheet with crossponding task's informaion

                        taskUseCases.getTaskUseCase(id = event.taskId)?.let {task ->

                            _sheetStates.value = sheetStates.value.copy(
                                currentTaskId = task.id!!,
                                titleTextField = sheetStates.value.titleTextField.copy(
                                    text = task.title,
                                    isHintVisible = task.title == ""
                                ),
                                descriptionTextField = sheetStates.value.descriptionTextField.copy(
                                    text = task.description,
                                    isHintVisible = task.description == ""
                                ),
                                priorityChosen = task.priority,
                                date = task.date,
                                isSheetVisible = true
                            )
                        }

                    }

                }
                else {
                    viewModelScope.launch {
                        _eventFlow.emit(UiEvent.ShowSnackbar("Could not open the sheet !, hint: taskId == null !"))
                    }
                }



            }
            is AddEditEvent.CloseSheet -> {
                _sheetStates.value = sheetStates.value.copy(
                    isSheetVisible = false
                )
            }
            is AddEditEvent.SaveTask -> {

                viewModelScope.launch {

                    taskUseCases.upsertTaskUseCases(
                        Task(
                            id = sheetStates.value.currentTaskId,
                            title = sheetStates.value.titleTextField.text,
                            description = sheetStates.value.descriptionTextField.text,
                            priority = sheetStates.value.priorityChosen,
                            date = sheetStates.value.date
                        )
                    )
                }
            }
        }
    }

    @RequiresApi(26)
    fun loadTasks() {
        viewModelScope.launch {
            taskUseCases.getTasksUseCase().collect { list ->
                    _taskState.value = taskState.value.copy(tasksList = list)
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message : String) : UiEvent()
    }

}