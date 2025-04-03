package jetpack.cleanarchitecture.tasknote.core.presentation.util

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)