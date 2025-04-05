package jetpack.cleanarchitecture.momentive.feature_tasks.domain.util

enum class Priority(val text : String) {
    IMPORTANT_URGENT("Important\nUrgent"),
    IMPORTANT_NOT_URGENT("Important\nNot Urgent"),
    NOT_IMPORTANT_URGENT("Not Important\nUrgent"),
    NOT_IMPORTANT_NOT_URGENT("Not Important\nNot Urgent"),
    NO_PRIORITY("No Priority")
}