package jetpack.cleanarchitecture.momentive.feature_tasks.data.repository

import jetpack.cleanarchitecture.momentive.feature_tasks.data.data_source.TaskDao
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao
)  : TaskRepository {

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

    override suspend fun getTaskById(id: Int): Task? {
        return dao.getTaskById(id)
    }

    override suspend fun upsertTask(task: Task) {
        dao.upsertTask(task)
    }

    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
    }
}