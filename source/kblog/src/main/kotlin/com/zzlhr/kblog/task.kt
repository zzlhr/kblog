package com.zzlhr.kblog

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap


@Component
class Task{

    /**
     * 登录验证码结果存放数组
     * 例子
     * @code 验证码结果
     * @time 创建时间
     * @pass 是否认证成功
     *
     * {'uuid': {'code':'1234', time:'1539331755123', pass:'0'}}
     *
     */
    var loginCodeMap:HashMap<String, Map<String, String>> = HashMap();

    // 清理登录生成验证码 超过20分钟的验证码
    @Scheduled(fixedRate = 60000)
    fun clearLoginCode(){
        loginCodeMap.forEach { t, u ->
            run {
                val nowTimestamp = Date().time
                val nowTime10 = nowTimestamp.toString().substring(0, 10).toInt()
                val createTime = u["time"]!!.substring(0, 10).toInt()
                if (nowTime10 - createTime > 1200) {
                    // 清理超过20分钟验证码
                    loginCodeMap.remove(t)
                }
                if ("1" == u["pass"]){
                    // 清理已经使用过（通过验证）的验证码
                    loginCodeMap.remove(t)
                }
            }
        }
    }

}