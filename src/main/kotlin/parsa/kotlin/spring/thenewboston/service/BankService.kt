package parsa.kotlin.spring.thenewboston.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import parsa.kotlin.spring.thenewboston.datasource.BankDataSource
import parsa.kotlin.spring.thenewboston.model.Bank

@Service
class BankService(@Qualifier("mock") private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)
    fun deleteBank(accountNumber: String): String = dataSource.deleteBank(accountNumber)
}