package eu.frlab.metrics

interface MessageService {

    fun postMessage(message: String): Boolean

    fun getMessages(): List<String>

}