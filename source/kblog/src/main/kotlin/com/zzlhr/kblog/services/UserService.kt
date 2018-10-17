package com.zzlhr.kblog.services

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


interface UserService{
    fun makeAuthCode(req: HttpServletRequest, resp: HttpServletResponse)

    fun login(userName: String, password:String, code:String, uid: String)

    fun loginOut(token: String)

}
