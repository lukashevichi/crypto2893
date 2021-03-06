package by.maxluxs.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.maxluxs.data.local.Contract.CONCURRENCY_TABLE_NAME

@Entity(tableName = CONCURRENCY_TABLE_NAME)
data class ConcurrencyLocal(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: String,
    @ColumnInfo(name = "NAME")
    val name: String,
    @ColumnInfo(name = "PRICE")
    val price: String
)