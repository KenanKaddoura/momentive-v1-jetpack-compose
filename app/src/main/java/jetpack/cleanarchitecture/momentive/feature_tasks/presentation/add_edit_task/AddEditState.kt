package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task

import android.os.Build
import androidx.annotation.RequiresApi
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
data class AddEditState(
    val titleFieldText : String = "",
    val titleFieldFocus : Boolean = false,
    val descriptionFieldText : String = "",
    val descriptionFieldFocus: Boolean = false,
    val priorityChosen : Priority = Priority.NO_PRIORITY,
    val date : LocalDate = LocalDate.now()
)