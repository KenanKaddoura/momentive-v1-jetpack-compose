package jetpack.cleanarchitecture.momentive.feature_tasks.data.data_source

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import jetpack.cleanarchitecture.momentive.feature_tasks.domain.util.Priority
import java.time.LocalDate

// Converts Priority & Date

class TaskConverters {

    // Convert LocalDate to String
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }

    // Convert String to LocalDate
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it) }
    }

    // Convert Priority Enum to String
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name  // Store as Enum name (e.g., "UrgentImportant")
    }

    // Convert String to Priority Enum
    @TypeConverter
    fun toPriority(value: String): Priority {
        return try {
            enumValueOf<Priority>(value) // Convert back to enum safely
        } catch (e: IllegalArgumentException) {
            Priority.NO_PRIORITY // Fallback in case of unexpected values
        }
    }
}