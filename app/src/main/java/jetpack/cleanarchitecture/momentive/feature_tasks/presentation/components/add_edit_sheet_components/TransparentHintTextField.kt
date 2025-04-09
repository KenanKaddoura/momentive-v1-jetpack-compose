package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle,
    textColor : Color,
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = text,
            textStyle = TextStyle(
                fontStyle = textStyle.fontStyle,
                color = textColor
            ),
            onValueChange = onValueChange,
            singleLine = singleLine,
            modifier = Modifier
                .onFocusChanged {
                    onFocusChange(it)
                }
        )

        if (isHintVisible) {
            Text(
                text = hint,
                style = textStyle.copy(color = textStyle.color.copy(alpha = 0.5f))
            )
        }
    }
}