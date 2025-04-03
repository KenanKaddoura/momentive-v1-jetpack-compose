package jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.repository.TaskRepository

class GetTaskUseCase(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(id : Int) : Task? {
        return repository.getTaskById(id)
    }

}