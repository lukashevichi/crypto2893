package by.maxluxs.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.maxluxs.data.local.dao.ConcurrencyDao
import by.maxluxs.data.local.model.ConcurrencyLocal

@Database(
    entities = [
        ConcurrencyLocal::class,
    ],
    exportSchema = false,
    version = 1
)
abstract class CurrencyDataBase : RoomDatabase() {
    abstract fun authorityDao(): ConcurrencyDao
}

