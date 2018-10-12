package com.zzlhr.kblog

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import com.samskivert.mustache.Mustache
import com.zzlhr.kblog.exception.KBlogException
import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@SpringBootApplication
class KblogApplication

fun main(args: Array<String>) {
    runApplication<KblogApplication>(*args)

}

/**
 * 全局异常处理
 */

/**
 * Mustache模板
 */
@Bean
fun mustacheCompiler(loader: Mustache.TemplateLoader?) =
        Mustache.compiler().escapeHTML(false).withLoader(loader)


/**
 * markdown处理
 */
@Service
class MarkdownConverter : (String?) -> String {

    private val parser = Parser.builder().extensions(listOf(AutolinkExtension.create())).build()
    private val renderer = HtmlRenderer.builder().build()

    override fun invoke(input: String?): String {
        if (input == null || input == "") {
            return ""
        }
        return renderer.render(parser.parse(input))
    }
}