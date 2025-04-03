package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskState
@RequiresApi(Build.VERSION_CODES.O)
class AddEditViewModel(
    private val taskUseCases: TaskUseCases
) {

    private val _state = mutableStateOf(AddEditState())
    val state: State<AddEditState> = _state

    init {
        onEvent(AddEditEvent.focusOnTitleField)
    }

    fun onEvent(event: AddEditEvent) {
        when(event) {
            is AddEditEvent.chooseDate -> {
                _state.value = state.value.copy(
                    date = event.date
                )
            }
            is AddEditEvent.choosePriority -> {
                _state.value = state.value.copy(
                    priorityChosen = event.priority
                )
            }
            AddEditEvent.focusOnDecriptionField -> {
                _state.value = state.value.copy(
                    descriptionFieldFocus = true,
                    titleFieldFocus = false
                )
            }
            AddEditEvent.focusOnTitleField -> {
                _state.value = state.value.copy(
                    descriptionFieldFocus = false,
                    titleFieldFocus = true
                )
            }
            is AddEditEvent.enterDescriptionText -> {
                _state.value = state.value.copy(
                    descriptionFieldText = event.text
                )
            }
            is AddEditEvent.enterTitleText -> {
                _state.value = state.value.copy(
                    titleFieldText = event.text
                )
            }
        }
    }

}



