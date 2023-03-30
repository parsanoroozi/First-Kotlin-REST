package parsa.kotlin.spring.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import parsa.kotlin.spring.thenewboston.datasource.BankDataSource
import parsa.kotlin.spring.thenewboston.model.Bank

@Repository("mock")
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull(){it.accountNumber == accountNumber}
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if( banks.any {it.accountNumber == bank.accountNumber}){
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        var i = -1
        for (index in banks.indices ){
            if (banks[index].accountNumber == bank.accountNumber){
                banks[index] = bank
                i = index
                break
            }
        }
        if(i==-1){
            throw NoSuchElementException("no matches found for the account number ${bank.accountNumber}")
        }
        return bank
    }

    override fun deleteBank(accountNumber: String): String {
        val bank = banks.firstOrNull{it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("no matches found for the account number $accountNumber")
        banks.remove(bank)
        return "bank $accountNumber has been removed successfully"
    }
}

