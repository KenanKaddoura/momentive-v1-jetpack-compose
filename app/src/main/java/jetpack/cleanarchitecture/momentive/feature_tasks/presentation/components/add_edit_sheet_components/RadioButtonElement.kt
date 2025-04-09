package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@Composable
fun RadioButtonElement(
    modifier : Modifier = Modifier,
    text : String,
    selected : Boolean = false,
    onSelect : () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 8.sp,
            lineHeight = 8.2.sp // fontSize * 1.2f (by default)
        )

        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.tertiary,
                unselectedColor = MaterialTheme.colorScheme.onTertiary,
                disabledSelectedColor = Color.Gray,
                disabledUnselectedColor = Color.Gray
            ),
        )
    }
}


