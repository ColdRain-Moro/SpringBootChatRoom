package kim.bifrost.rain.hellospringboot.controller.bean

/**
 * kim.bifrost.rain.hellospringboot.controller.bean.BaseResponseBean
 * HelloSpringBoot
 *
 * @author 寒雨
 * @since 2021/12/25 13:34
 **/
data class BaseResponseBean<T>(
    val data: T?,
    val errorCode: Int = 0,
    val errorMsg: String = ""
)