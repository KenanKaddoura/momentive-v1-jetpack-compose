package jetpack.cleanarchitecture.momentive.feature_tasks.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Upsert
    suspend fun upsertTask(task : Task)

    @Delete
    suspend fun deleteTask(task : Task)

    @Query("SELECT * FROM Task WHERE id = :id")
    suspend fun getTaskById(id : Int) : Task?

    @Query("SELECT * FROM TASK")
    fun getTasks() : Flow<List<Task>>
}