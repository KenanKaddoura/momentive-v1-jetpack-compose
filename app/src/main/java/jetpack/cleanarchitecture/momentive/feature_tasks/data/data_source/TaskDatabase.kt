
package jetpack.cleanarchitecture.momentive.feature_tasks.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.model.Task
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TaskConverters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract val dao : TaskDao

    companion object {
        const val db_name = "TASK_DATABASE"

        @Volatile
        private var DatabaseInstance : TaskDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabaseInstance(context : Context) : TaskDatabase {
            return DatabaseInstance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    TaskDatabase.db_name
                ).build()
                DatabaseInstance = instance
                instance
            }
        }
    }

}