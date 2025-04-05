package jetpack.cleanarchitecture.momentive.feature_tasks.container

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskViewModel

@RequiresApi(Build.VERSION_CODES.O)
class TaskViewModelFactory(
    private val useCases: TaskUseCases
) : ViewModelProvider.Factory {

    // This is for a TaskViewModel specifically
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(useCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


    // This is a generic helper for any viewModel, but it does not support more parameters.
    inline fun <VM : ViewModel> viewModelFactory(crossinline create: () -> VM): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T = create() as T
        }

}
