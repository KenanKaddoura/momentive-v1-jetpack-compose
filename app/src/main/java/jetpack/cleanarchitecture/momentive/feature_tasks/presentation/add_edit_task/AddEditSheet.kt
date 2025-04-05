package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import jetpack.cleanarchitecture.momentive.feature_tasks.container.TaskContainer
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.components.DateElement
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.components.PrioritySection
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.components.TransparentHintTextField
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditSheet(
    navController : NavHostController
) {
    // View Model Initialisation ...
    val context = LocalContext.current.applicationContext as TaskContainer
    val viewModel: AddEditViewModel = viewModel(
        factory = viewModelFactory { AddEditViewModel(context.useCases) }
    )

    val state = viewModel.state.value

    ModalBottomSheet(
        sheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Expanded
        ),
        onDismissRequest = { },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        dragHandle = {/* The purpose of this: Removing the handle symbol at top */},
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            TransparentHintTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "state.titleFieldText",
                textStyle = MaterialTheme.typography.titleMedium,
                isHintVisible = false,
                hint = "",
                onValueChange = {
                    // ViewModel
                },
                onFocusChange = {
                    // ViewModel

                },
                singleLine = true
            )

            TransparentHintTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "state.descriptionFieldText",
                textStyle = MaterialTheme.typography.bodyMedium,
                isHintVisible = false,
                hint = "",
                onValueChange = {
                    // ViewModel
                },
                onFocusChange = {
                    // ViewModel
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                PrioritySection(
                    onSelect = {}
                )

                VerticalDivider(
                    Modifier
                        .width(2.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))

                DateElement(
                    onClick = {}
                )
            }

        }


    }
//
//    LaunchedEffect(Unit) {
//        sheetState.show()
//    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun AddEditSheetPreview() {
    AddEditSheet(navController = rememberNavController())
}

