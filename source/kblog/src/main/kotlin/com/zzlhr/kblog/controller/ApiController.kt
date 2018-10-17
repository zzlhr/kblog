package com.zzlhr.kblog.controller

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.zzlhr.kblog.services.ArticleService
import com.zzlhr.kblog.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


/**
 * api接口控制器
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
class ApiController
@Autowired constructor(private val articleService: ArticleService) {

    private var resultVO: ResultVO = ResultVO()


    @PostMapping("/articles")
    fun articles(@RequestParam(defaultValue = "")keyword: String,
                 @RequestParam(defaultValue = "0")author: Int,
                 @RequestParam(defaultValue = "0")status: Int,
                 @RequestParam(defaultValue = "1")page: Long,
                 @RequestParam(defaultValue = "10")pageSize: Long): String{

        resultVO.data = articleService.getArticleList(
                keyword, "", author, status, page, pageSize)
        return resultVO.getJSON(resultVO)
    }






}