package jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases

import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

// We may have multiple fun.s depending on the order criteria, priority, name, date

class GetTasksUseCase(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(
        /*Todo : Order Criteria*/
    ) : Flow<List<Task>> {
        return repository.getTasks()
    }

}