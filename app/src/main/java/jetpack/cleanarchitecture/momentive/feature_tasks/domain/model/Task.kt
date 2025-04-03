package jetpack.cleanarchitecture.momentive.feature_tasks.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val title : String,
    val description : String,
    val priority: Priority,
    val date : LocalDate
)
