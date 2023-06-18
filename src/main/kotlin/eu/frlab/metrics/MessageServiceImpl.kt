package eu.frlab.metrics

import io.micrometer.core.annotation.Counted
import org.springframework.stereotype.Service

@Service()
class MessageServiceImpl : MessageService {

    private val messages = GreedyBlockingQueue<String>(10)

    @Counted("business.messagesSubmitted")
    override fun postMessage(message: String): Boolean =
        if (message == "error") throw RuntimeException() else messages.add(message)


    override fun getMessages(): List<String> = messages.toList()

}
