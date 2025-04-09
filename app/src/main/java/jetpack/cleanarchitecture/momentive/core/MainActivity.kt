package jetpack.cleanarchitecture.momentive.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import jetpack.cleanarchitecture.momentive.core.presentation.MainScreen
import jetpack.cleanarchitecture.momentive.core.presentation.NavGraph
import jetpack.cleanarchitecture.momentive.core.presentation.components.BottomNavBar
import jetpack.cleanarchitecture.momentive.ui.theme.MomentiveTheme
import jetpack.cleanarchitecture.tasknote.core.presentation.components.TopNavBar


class MainActivity : ComponentActivity() {

    @RequiresApi(26)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MomentiveTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}



