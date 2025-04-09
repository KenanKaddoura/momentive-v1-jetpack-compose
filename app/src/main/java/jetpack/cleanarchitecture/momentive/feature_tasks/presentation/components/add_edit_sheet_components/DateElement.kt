package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.components.add_edit_sheet_components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateElement(
    modifier : Modifier = Modifier,
    date: LocalDate = LocalDate.now(),
    onClick : (LocalDate) -> Unit
) {
    TextButton(
        onClick = {
            onClick(date.plusDays(1)) /*Must be the date picked */
        }
    ) {
       Text(
           text = usableDate(date),
           style = MaterialTheme.typography.titleMedium,
           color = MaterialTheme.colorScheme.tertiary,
           overflow = TextOverflow.Ellipsis
       )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun usableDate(date : LocalDate) : String {

    val formatter = DateTimeFormatter.ofPattern("MMM d, yyyy") // You may use Locale para. for arabic in future.

    val todayDate = LocalDate.now()

    return when (date) {
        todayDate -> "Today"
        todayDate.minusDays(1) -> "Yesterday"
        todayDate.plusDays(1) -> "Tomorrow"
        else -> date.format(formatter)
    }
}

