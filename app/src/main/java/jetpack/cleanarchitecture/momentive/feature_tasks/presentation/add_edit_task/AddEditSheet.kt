package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jetpack.cleanarchitecture.momentive.feature_tasks.container.TaskContainer
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.components.TransparentHintTextField

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditSheet(
    viewModel: AddEditViewModel = TaskContainer.instance.addEditViewModel
) {

    val state = viewModel.state.value
    ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {
        TransparentHintTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.titleFieldText,
            textStyle = MaterialTheme.typography.bodyMedium,
            isHintVisible = false,
            hint = "",
            onValueChange = {},
            onFocusChange = {}
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun AddEditSheetPreview() {
    AddEditSheet()
}