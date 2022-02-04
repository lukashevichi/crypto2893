package by.maxluxs.domain_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.maxluxs.domain_local.dao.ConcurrencyDao
import by.maxluxs.domain_local.model.ConcurrencyLocal

@Database(
    entities = [
        ConcurrencyLocal::class,
    ],
    exportSchema = false,
    version = 1
)
abstract class ConcurrencyDataBase: RoomDatabase() {
        abstract fun authorityDao(): ConcurrencyDao
}

