package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority

@Composable
fun PrioritySection(
    modifier: Modifier = Modifier,
    selectedPriority: Priority = Priority.NO_PRIORITY,
    onSelect : (Priority) -> Unit
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        RadioButtonElement(
            modifier = Modifier.padding(4.dp),
            text = Priority.IMPORTANT_NOT_URGENT.text,
            selected = selectedPriority == Priority.IMPORTANT_NOT_URGENT,
            onSelect = {
                onSelect(Priority.IMPORTANT_NOT_URGENT)
            }
        )

        RadioButtonElement(
            modifier = Modifier.padding(4.dp),
            text = Priority.IMPORTANT_URGENT.text,
            selected = selectedPriority == Priority.IMPORTANT_URGENT,
            onSelect = {
                onSelect(Priority.IMPORTANT_URGENT)
            }
        )

        RadioButtonElement(
            modifier = Modifier.padding(4.dp),
            text = Priority.NOT_IMPORTANT_NOT_URGENT.text,
            selected = selectedPriority == Priority.NOT_IMPORTANT_NOT_URGENT,
            onSelect = {
                onSelect(Priority.NOT_IMPORTANT_NOT_URGENT)
            }
        )

        RadioButtonElement(
            modifier = Modifier.padding(4.dp),
            text = Priority.NOT_IMPORTANT_URGENT.text,
            selected = selectedPriority == Priority.NOT_IMPORTANT_URGENT,
            onSelect = {
                onSelect(Priority.NOT_IMPORTANT_URGENT)
            }
        )
    }

}

@Preview
@Composable
fun PriorityRadioButtonsPreview() {
    PrioritySection(modifier = Modifier.fillMaxWidth(),
        onSelect = {

        })
}

