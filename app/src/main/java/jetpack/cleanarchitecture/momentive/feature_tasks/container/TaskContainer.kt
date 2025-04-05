package jetpack.cleanarchitecture.momentive.feature_tasks.container

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import jetpack.cleanarchitecture.momentive.feature_tasks.data.data_source.TaskDatabase
import jetpack.cleanarchitecture.momentive.feature_tasks.data.repository.TaskRepositoryImpl
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.repository.TaskRepository
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.DeleteTaskUseCase
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.GetTaskUseCase
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.GetTasksUseCase
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.TaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases.UpsertTaskUseCases
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.add_edit_task.AddEditViewModel
import jetpack.cleanarchitecture.momentive.feature_tasks.presentation.tasks.TaskViewModel

@RequiresApi(Build.VERSION_CODES.O)
class TaskContainer : Application() {

    companion object {
        lateinit var instance:TaskContainer
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private val database : TaskDatabase by lazy {
        TaskDatabase.getDatabaseInstance(applicationContext)
    }

    private val repository : TaskRepository by lazy {
        TaskRepositoryImpl(database.dao)
    }

    val useCases : TaskUseCases by lazy {
        TaskUseCases(
            upsertTaskUseCases = UpsertTaskUseCases(repository),
            deleteTaskUseCase = DeleteTaskUseCase(repository),
            getTaskUseCase = GetTaskUseCase(repository),
            getTasksUseCase = GetTasksUseCase(repository)
        )
    }


}