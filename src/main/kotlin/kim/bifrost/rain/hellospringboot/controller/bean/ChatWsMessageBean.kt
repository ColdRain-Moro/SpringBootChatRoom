package kim.bifrost.rain.hellospringboot.controller.bean

import org.springframework.web.socket.WebSocketMessage

/**
 * kim.bifrost.rain.hellospringboot.controller.bean.ChatWsMessageBean
 * HelloSpringBoot
 *
 * @author 寒雨
 * @since 2021/12/25 14:16
 **/
data class ChatWsMessageBean(
    val type: String,
    val username: String,
    val data: String?,
    val avatar: String
)

object WebSocketMessageType {
    const val OPEN = "OPEN"
    const val CLOSE = "CLOSE"
    const val MESSAGE = "MESSAGE"
}