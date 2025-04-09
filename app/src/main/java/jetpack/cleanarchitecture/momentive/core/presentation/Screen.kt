package jetpack.cleanarchitecture.momentive.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import jetpack.cleanarchitecture.momentive.R

sealed class Screen(val route: String) {
    object Tasks : Screen(route = "tasks")
    object Notes : Screen(route = "notes")
    object Profile : Screen(route = "profiles")
}