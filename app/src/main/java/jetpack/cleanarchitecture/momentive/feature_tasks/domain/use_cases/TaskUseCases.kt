package jetpack.cleanarchitecture.momentive.feature_tasks.domain.use_cases

data class TaskUseCases (
    val upsertTaskUseCases: UpsertTaskUseCases,
    val deleteTaskUseCase: DeleteTaskUseCase,
    val getTaskUseCase: GetTaskUseCase,
    val getTasksUseCase: GetTasksUseCase
)