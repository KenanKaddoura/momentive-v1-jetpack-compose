package jetpack.cleanarchitecture.momentive.feature_tasks.domain.util

enum class Priority(val text : String) {
    URGENT_IMPORTANT("Urgent\nImportant"),
    NOT_URGENT_IMPORTANT("Not Urgent\nImportant"),
    URGENT_NOT_IMPORTANT("Urgent\nNot Important"),
    NOT_URGENT_NOT_IMPORTANT("Not Urgent\nNot Important"),
    NO_PRIORITY("No Priority")
}