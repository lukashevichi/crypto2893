package by.maxluxs.domain_local.model

import androidx.room.Entity
import by.maxluxs.domain_local.Contract.ConcurrencyTableName

@Entity(tableName = ConcurrencyTableName)
data class ConcurrencyLocal(
    val name: String,
    val price: String
)