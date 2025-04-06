package jetpack.cleanarchitecture.momentive.feature_tasks.container

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.AddEditViewModel
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskViewModel

@RequiresApi(Build.VERSION_CODES.O)

class AddEditViewModelFactory(
    private val taskUseCases: TaskUseCases
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddEditViewModel::class.java)) {
            return AddEditViewModel(taskUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}