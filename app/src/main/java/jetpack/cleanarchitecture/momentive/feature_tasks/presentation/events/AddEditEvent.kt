package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events

import androidx.compose.ui.focus.FocusState
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

sealed class AddEditEvent {
    class EnterTitleText(val text : String) : AddEditEvent()
    class EnterDescriptionText(val text : String) : AddEditEvent()
    class ChangeTitleFocus(val focusState: FocusState) : AddEditEvent()
    class ChangeDescriptionFocus(val focusState: FocusState) : AddEditEvent()
    class ChoosePriority(val priority: Priority) : AddEditEvent()
    class ChooseDate(val date : LocalDate) : AddEditEvent()
    class OpenSheet(val taskId: Int?) : AddEditEvent()
    object CloseSheet : AddEditEvent()

    object SaveTask: AddEditEvent()




}