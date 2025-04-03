package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task

// Click on New Task
// Click on Existing Task
// Click on More
// LongClick (Select) on Existing Task
//

sealed class TaskEvent {
    data class SelectTask(val task : Task) : TaskEvent()
    class ClickOnMoreActions() : TaskEvent()
    class NewTask() : TaskEvent()
    class EditTask() : TaskEvent()
}