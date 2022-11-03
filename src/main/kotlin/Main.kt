import abi.ExchangeRate
import org.web3j.abi.EventEncoder
import org.web3j.abi.EventValues
import org.web3j.abi.FunctionReturnDecoder
import org.web3j.abi.datatypes.Event
import org.web3j.protocol.admin.Admin
import org.web3j.protocol.websocket.WebSocketService
import org.web3j.protocol.websocket.events.Log

/**
 *@author Said Ibragimov on 03.11.2022 23:10
 */

fun main() {
    val service = WebSocketService(Config.nodeUrl, false).apply {
        connect()
    }
    val web3j = Admin.build(service)

    web3j.blockFlowable(false).subscribe { block ->
        Logger.logNewBlock(block)
    }

    val topic = listOf(EventEncoder.encode(ExchangeRate.ANSWERUPDATED_EVENT))
    Config.oracles.forEach { (token, address) ->
        web3j.logsNotifications(
            listOf(address),
            topic
        ).subscribe { log ->
            val values = extractEventParameters(ExchangeRate.ANSWERUPDATED_EVENT, log.params.result)
            values?.let {
                Logger.logContractUpdated(
                    token,
                    values
                )
            }
        }
    }
}

fun extractEventParameters(event: Event, log: Log): EventValues? {
    val topics = log.topics

    if (topics.isEmpty() || topics.first() != EventEncoder.encode(event)) {
        return null
    }

    val indexedValues = buildList {
        event.indexedParameters.forEachIndexed { index, typeReference ->
            val value = FunctionReturnDecoder.decodeIndexedValue(
                topics[index + 1], typeReference
            )
            add(value)
        }
    }
    val nonIndexedValues = FunctionReturnDecoder.decode(log.data, event.nonIndexedParameters)

    return EventValues(indexedValues, nonIndexedValues)
}
