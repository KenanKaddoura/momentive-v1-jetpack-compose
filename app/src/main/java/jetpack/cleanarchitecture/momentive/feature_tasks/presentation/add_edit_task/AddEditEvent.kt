package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

sealed class AddEditEvent {
    class choosePriority(val priority: Priority) : AddEditEvent()
    class chooseDate(val date : LocalDate) : AddEditEvent()
    object focusOnTitleField : AddEditEvent()
    object focusOnDecriptionField : AddEditEvent()
    class enterTitleText(val text : String) : AddEditEvent()
    class enterDescriptionText(val text : String) : AddEditEvent()
}