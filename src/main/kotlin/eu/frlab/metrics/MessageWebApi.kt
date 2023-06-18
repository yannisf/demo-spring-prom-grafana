package eu.frlab.metrics

import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageWebApi(private val messageService: MessageService) {

    @GetMapping("/message/{message}") //Should be POST, using GET just for the sake of simplicity
    @Timed("business.addMessage")
    fun addMessage(@PathVariable("message") message: String): Boolean =
        runCatching { messageService.postMessage(message) }.getOrDefault(false)

    @GetMapping("/message/all")
    @Timed("business.getMessages")
    fun allMessages(): List<String> = messageService.getMessages()

}
