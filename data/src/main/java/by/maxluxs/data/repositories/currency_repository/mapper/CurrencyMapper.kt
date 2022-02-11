package by.maxluxs.data.repositories.currency_repository.mapper

import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.crypto2893.domain.values.MetaData
import by.maxluxs.data.network.coin_market_cap.model.response.CryptoCurrencyResponse
import by.maxluxs.data.network.coin_market_cap.model.response.DataResponse

object CurrencyMapper {

    private fun responseModelToModel(responseModel: CryptoCurrencyResponse): CryptoCurrency {
        return CryptoCurrency(
            id = responseModel.id ?: -1,
            name = responseModel.name ?: "",
            symbol = responseModel.symbol ?: "",
            data = MetaData(
                slug = responseModel.slug ?: "",
                dateAdded = responseModel.dateAdded ?: "",
                platform = responseModel.platform?.name ?: "",
                cmcRank = responseModel.cmcRank.toString(),
                lastUpdated = responseModel.lastUpdated ?: "",
            ),
            price = responseModel.quote?.USD?.price?.roundToString() ?: ""
        )
    }

    fun responseMetaModelToModel(responseModel: DataResponse, id: Int): CryptoCurrency {
        val response = responseModel.metaData[id]
        return CryptoCurrency(
            id = response?.id ?: -1,
            name = response?.name ?: "",
            symbol = response?.symbol ?: "",
            data = MetaData(
                slug = response?.slug ?: "",
                dateAdded = response?.dateAdded ?: "",
                platform = response?.platform ?: "",
            ),
            price = ""
        )
    }

    internal fun responseToModel(response: List<CryptoCurrencyResponse>): List<CryptoCurrency> =
        response.map { responseModelToModel(it) }

}