# SpringBootChatRoom

> 了解了一下Spring Boot，想写个项目练手
>
> 于是写了个路姐姐的聊天室后端Spring Boot实现，代码量非常少

## Usage

**返回信息Bean类**

~~~kotlin
data class ChatWsMessageBean(
    val type: String,
    val username: String,
    val data: String?,
    val avatar: String
)
~~~

**json信息格式**

type: 类型 (OPEN/CLOSE/MESSAGE)

username: 用户名参数

data: 聊天信息

avatar: 头像url参数

~~~json
{
  "type": "OPEN",
  "username": "unnamed",
  "data": null,
  "avatar": "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"
}
~~~

**网页前端连接WebSocket示例**

127.0.0.1:8080改为部署的服务器地址

可填参数: username(default = "unnamed"), avatar(default = "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp")

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        const ws = new WebSocket(`ws://127.0.0.1:8080/chatroom?username=Rain`)
        ws.onmessage = (event) => {
            console.log(event.data)
        }
        setTimeout(() => {
            ws.send("Test")
        }, 5000)
    </script>
</body>
</html>
~~~