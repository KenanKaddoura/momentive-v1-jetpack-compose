package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task

data class TaskState(
    val tasksList : List<Task> = emptyList(),
    val selectedTasksList : List<Task> = emptyList(),
    val isSelectionMode : Boolean = false,
    val isMoreActionsClicked : Boolean = false,
    val sheetState : Boolean = false
)