package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.preview

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.states.AddEditState
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.DateElement
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.PrioritySection
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components.TransparentHintTextField
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.util.TaskTextFieldState
import jetpack.cleanarchitecture.momentive.ui.theme.MomentiveTheme
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEditSheetContent(
    sheetStates: AddEditState,
    onSheetEvent: (AddEditEvent) -> Unit
) {
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

            TextButton(onClick = {}) {
                Text(text = "Done")
            }
        }



        TransparentHintTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = sheetStates.descriptionTextField.text,
            textStyle = MaterialTheme.typography.bodyLarge,
            textColor = MaterialTheme.colorScheme.onSurface,
            isHintVisible = sheetStates.descriptionTextField.isHintVisible,
            hint = sheetStates.descriptionTextField.hint,
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
                selectedPriority = sheetStates.priorityChosen
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
                date = sheetStates.date
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)@Composable
fun AddEditSheetPreview() {
    val fakeState = AddEditState(
        titleTextField = TaskTextFieldState(
            text = "Buy groceries",
            hint = "Title",
            isHintVisible = false
        ),
        descriptionTextField = TaskTextFieldState(
            text = "Milk, Eggs, Bread",
            hint = "Description",
            isHintVisible = false
        ),
        priorityChosen = Priority.NOT_IMPORTANT_URGENT,
        date = LocalDate.of(2025, 12, 30),
        isSheetVisible = true
    )

    // Fake sheetState to force it open
    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Expanded
    )

    MomentiveTheme {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {},
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            dragHandle = {},
            shape = RoundedCornerShape(12.dp)
        ) {
            AddEditSheetContent(
                sheetStates = fakeState,
                onSheetEvent = {}
            )
        }
    }
}