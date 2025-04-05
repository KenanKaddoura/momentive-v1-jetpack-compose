package jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

// Use LocalDateTime = Date + Time (Hours & Minutes)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    priority: Priority,
    date: LocalDate,
    selected : Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {

    Card(
        modifier = modifier
            .combinedClickable(
                onClick = {onClick()},
                onLongClick = {onLongClick()}
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(modifier.padding(8.dp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )


                Text(
                    text = priority.text,
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    text = description,
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = date.toString(),
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TaskCardPreview() {
    TaskCard(
        title = "Task Title ..",
        description = "Description .. ",
        priority = Priority.NOT_IMPORTANT_URGENT,
        date = LocalDate.of(2025, 2, 1),
        selected = false,
        onClick = {},
        onLongClick = {}
    )
}