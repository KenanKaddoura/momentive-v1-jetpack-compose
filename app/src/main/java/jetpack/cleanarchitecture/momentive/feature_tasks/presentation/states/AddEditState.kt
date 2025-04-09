package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.states

import androidx.annotation.RequiresApi
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.util.TaskTextFieldState
import java.time.LocalDate

@RequiresApi(26)
data class AddEditState(
    val titleTextField : TaskTextFieldState = TaskTextFieldState(
        hint = "Task Title ..."
    ),
    val descriptionTextField : TaskTextFieldState = TaskTextFieldState(
        hint = "Description ..."
    ),
    val priorityChosen : Priority = Priority.NO_PRIORITY,
    val date : LocalDate = LocalDate.now(),
    val currentTaskId : Int = 0,
    val isSheetVisible : Boolean = false
)