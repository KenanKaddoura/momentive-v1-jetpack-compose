package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.tasks_components

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.states.AddEditState
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.DateElement
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.PrioritySection
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.TransparentHintTextField

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditSheet(
    sheetStates: AddEditState,
    onSheetEvent: (AddEditEvent) -> Unit
) {

    val sheetState = rememberModalBottomSheetState()

    LaunchedEffect(sheetStates.isSheetVisible) {
        if(sheetStates.isSheetVisible) {
            sheetState.show()
        }
        else {
            sheetState.hide()
        }
    }

    if (sheetStates.isSheetVisible) {
        ModalBottomSheet(
            sheetState = sheetState, // State
            onDismissRequest = {
                onSheetEvent(AddEditEvent.CloseSheet)
            },
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            dragHandle = {/* The purpose of this: Removing the handle symbol at top */ },
            shape = RoundedCornerShape(12.dp)
        ) {

            // Sheet's content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TransparentHintTextField(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f),
                        text = sheetStates.titleTextField.text,
                        textStyle = MaterialTheme.typography.titleLarge,
                        textColor = MaterialTheme.colorScheme.onSurface,
                        isHintVisible = sheetStates.titleTextField.isHintVisible,
                        hint = sheetStates.titleTextField.hint,
                        onValueChange = {
                            onSheetEvent(AddEditEvent.EnterTitleText(it))
                        },
                        onFocusChange = {
                            onSheetEvent(AddEditEvent.ChangeTitleFocus(it))
                        },
                        singleLine = true
                    )

                    TextButton(onClick = {
                        onSheetEvent(AddEditEvent.SaveTask)
                    }) {
                        Text(text = "Done")
                    }
                }


                TransparentHintTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = sheetStates.descriptionTextField.text, // State
                    textStyle = MaterialTheme.typography.bodyLarge,
                    textColor = MaterialTheme.colorScheme.onSurface,
                    isHintVisible = sheetStates.descriptionTextField.isHintVisible,
                    hint = sheetStates.descriptionTextField.hint, // State
                    onValueChange = {
                        onSheetEvent(AddEditEvent.EnterDescriptionText(it))
                    },
                    onFocusChange = {
                        onSheetEvent(AddEditEvent.ChangeDescriptionFocus(it))
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
                        onSelect = {
                            onSheetEvent(AddEditEvent.ChoosePriority(it))
                        },
                        selectedPriority = sheetStates.priorityChosen // State
                    )

                    VerticalDivider(
                        Modifier
                            .width(2.dp)
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    DateElement(
                        onClick = {
                            onSheetEvent(AddEditEvent.ChooseDate(it))
                        },
                        date = sheetStates.date // State
                    )

                    Spacer(modifier = Modifier.weight(1f))

                }

            }


        }
    }

}
