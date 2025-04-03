package jetpack.cleanarchitecture.momentive.feature_tasks.domain.repository

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasks() : Flow<List<Task>>

    suspend fun getTaskById(id : Int) : Task?

    suspend fun deleteTask(task: Task)

    suspend fun upsertTask(task: Task)

}