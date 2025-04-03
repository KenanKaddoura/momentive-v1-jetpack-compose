package jetpack.cleanarchitecture.tasknote.core.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import jetpack.cleanarchitecture.momentive.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    modifier: Modifier = Modifier,
    title: String,
    onSettingsClick: () -> Unit,
    onMoreClick: () -> Unit
) {

    TopAppBar(
        title = { Text(
            text = title,
            fontSize = 25.sp
        ) },
        navigationIcon = { IconButton(onClick = {  }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
                contentDescription = "Settings")
        }},
        actions = {
            IconButton(onClick = {  }) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_more),
                    contentDescription = "more")
            }
        }
    )

}
