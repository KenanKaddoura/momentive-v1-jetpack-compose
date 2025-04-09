package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components

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
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.events.AddEditEvent
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FakeSheet() {

    val sheetState = rememberModalBottomSheetState()

    if (true) {

        ModalBottomSheet(
            sheetState = sheetState, // State
            onDismissRequest = {

            },
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            dragHandle = {/* The purpose of this: Removing the handle symbol at top */ },
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
                    text = "My Title Task",
                    textStyle = MaterialTheme.typography.titleLarge,
                    textColor = MaterialTheme.colorScheme.onSurface,
                    isHintVisible = false,
                    hint = "Hint",
                    onValueChange = {
                    },
                    onFocusChange = {
                    },
                    singleLine = true
                )

                TransparentHintTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "My Description Task", // State
                    textStyle = MaterialTheme.typography.bodyLarge,
                    textColor = MaterialTheme.colorScheme.onSurface,
                    isHintVisible = false,
                    hint = "Hint", // State
                    onValueChange = {
                    },
                    onFocusChange = {
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
                        },
                        selectedPriority = Priority.NO_PRIORITY // State
                    )

                    VerticalDivider(
                        Modifier
                            .width(2.dp)
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(30.dp))

                    DateElement(
                        onClick = {
                        },
                        date = LocalDate.now() // State
                    )
                }

            }


        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun FakeSheetPreview() {
    FakeSheet()
}