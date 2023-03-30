package parsa.kotlin.spring.thenewboston.datasource.network.dto

import parsa.kotlin.spring.thenewboston.model.Bank

data class BankList (
    val results: Collection<Bank>
)