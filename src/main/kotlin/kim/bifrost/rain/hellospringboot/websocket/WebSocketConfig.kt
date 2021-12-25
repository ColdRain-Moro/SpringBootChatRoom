package kim.bifrost.rain.hellospringboot.websocket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

/**
 * kim.bifrost.rain.hellospringboot.websocket.WebSocketConfig
 * HelloSpringBoot
 *
 * @author 寒雨
 * @since 2021/12/25 14:50
 **/
@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    @Autowired
    private lateinit var chatRoomWsHandler: ChatRoomWsHandler

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(chatRoomWsHandler, "chatroom")
            .setAllowedOrigins("*")
    }
}