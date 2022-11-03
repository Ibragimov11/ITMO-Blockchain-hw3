import org.web3j.abi.EventValues
import org.web3j.protocol.core.methods.response.EthBlock
import java.math.BigInteger

/**
 *@author Said Ibragimov on 04.11.2022 03:29
 */

object Logger {
    fun logNewBlock(block: EthBlock) {
        System.out.printf(
            "New block: ts=%d, number=%d, hash=%s \n",
            block.block.timestamp,
            block.block.number,
            block.block.hash
        )
    }

    fun logContractUpdated(token: String, values: EventValues) {
        val current = values.indexedValues[0].value as BigInteger
        val roundId = values.indexedValues[1].value as BigInteger
        val updatedAt = values.nonIndexedValues[0].value as BigInteger

        System.out.printf(
            "Contract %s is updated: ts=%d, current=%d, roundId=%d \n",
            token,
            updatedAt,
            current,
            roundId
        )
    }
}