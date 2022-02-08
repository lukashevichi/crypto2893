package by.maxluxs.domain_repository.mapper

import by.maxluxs.domain_remote.model.response.CryptoCurrencyResponse
import by.maxluxs.domain_repository.model.Currency

object CurrencyMapper {

    private fun responseModelToModel(responseModel: CryptoCurrencyResponse): Currency {
        return Currency(
            id = responseModel.id ?: -1,
            name = responseModel.name ?: "",
            symbol = responseModel.symbol ?: "",
            slug = responseModel.slug ?: "",
            numMarketPairs = responseModel.numMarketPairs.toString(),
            dateAdded = responseModel.dateAdded ?: "",
            platform = responseModel.platform?.name ?: "",
            cmcRank = responseModel.cmcRank.toString(),
            lastUpdated = responseModel.lastUpdated ?: "",
            price = responseModel.quote?.USD?.price?.roundToString() ?: ""
        )
    }

    internal fun responseToModel(response: List<CryptoCurrencyResponse>): List<Currency> =
        response.map { responseModelToModel(it) }

}