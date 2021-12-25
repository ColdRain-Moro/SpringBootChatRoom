package kim.bifrost.rain.hellospringboot.websocket

import com.fasterxml.jackson.databind.ObjectMapper
import kim.bifrost.rain.hellospringboot.controller.bean.ChatWsMessageBean
import kim.bifrost.rain.hellospringboot.controller.bean.WebSocketMessageType
import org.springframework.stereotype.Component
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler

/**
 * kim.bifrost.rain.hellospringboot.websocket.ChatRoomWsHandler
 * HelloSpringBoot
 *
 * @author 寒雨
 * @since 2021/12/25 13:59
 **/
@Component
class ChatRoomWsHandler : TextWebSocketHandler() {

    private val objectMapper = ObjectMapper()
    private val connectedSessions = arrayListOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        connectedSessions.add(session)
        val username = session.attributes["username"] ?: "unnamed"
        val avatar = session.attributes["avatar"] ?: "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"
        connectedSessions.forEach { it.sendMessage(TextMessage(ChatWsMessageBean(WebSocketMessageType.OPEN, username.toString(), null, avatar.toString()).stringify())) }
        println("[ChatRoom] $username connect with avatar $avatar")
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val username = session.attributes["username"] ?: "unnamed"
        val avatar = session.attributes["avatar"] ?: "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"
        connectedSessions.forEach {
            it.sendMessage(TextMessage(ChatWsMessageBean(WebSocketMessageType.MESSAGE, username.toString(),
                message.payload, avatar.toString()).stringify()))
        }
        println("[ChatRoom] $username send message ${message.payload} with avatar $avatar")
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        connectedSessions.remove(session)
        val username = session.attributes["username"] ?: "unnamed"
        val avatar = session.attributes["avatar"] ?: "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"
        connectedSessions.forEach { it.sendMessage(TextMessage(ChatWsMessageBean(WebSocketMessageType.CLOSE, username.toString(), null, avatar.toString()).stringify())) }
        println("[ChatRoom] $username disconnect with avatar $avatar")
    }

    private fun ChatWsMessageBean.stringify() = objectMapper.writeValueAsString(this)
}