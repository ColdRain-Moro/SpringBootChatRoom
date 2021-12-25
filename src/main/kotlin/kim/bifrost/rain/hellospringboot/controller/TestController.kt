package kim.bifrost.rain.hellospringboot.controller

import kim.bifrost.rain.hellospringboot.controller.bean.BaseResponseBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * kim.bifrost.rain.hellospringboot.controller.Example
 * HelloSpringBoot
 *
 * @author 寒雨
 * @since 2021/12/25 1:33
 **/
@RestController
class TestController {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = BaseResponseBean("Hello $name")

}