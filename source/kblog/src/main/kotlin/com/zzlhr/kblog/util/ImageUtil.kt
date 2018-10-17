package com.zzlhr.kblog.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.IOException
import java.util.*

import javax.imageio.ImageIO
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author worm0527
 * 2016-03-22 23:15:54
 * 生成验证码
 */
class ImageUtil {

    fun makeCodeImage(resp: HttpServletResponse){
        // 用于绘制图片，设置图片的长宽和图片类型（RGB)
        val bi = BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB)
        // 获取绘图工具
        val graphics = bi.graphics
        graphics.color = Color(100, 230, 200) // 使用RGB设置背景颜色
        graphics.fillRect(0, 0, 100, 30) // 填充矩形区域

        // 验证码中所使用到的字符
        val codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray()
        var captcha = "" // 存放生成的验证码
        val random = Random()
        for (i in 0 until CODE_LEN) { // 循环将每个验证码字符绘制到图片上
            val index = random.nextInt(codeChar.size)
            // 随机生成验证码颜色
            graphics.color = Color(random.nextInt(150), random.nextInt(200), random.nextInt(255))
            // 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
            graphics.drawString(codeChar[index] + "", i * 20 + 15, 20)
            captcha += codeChar[index]
        }
        // 将生成的验证码code放入sessoin中

        val uid = UUID.randomUUID().toString();
        resp.addHeader("uid", uid)


        // 通过ImageIO将图片输出
        ImageIO.write(bi, "JPG", resp.outputStream)
    }

    companion object {
        // 图片高度
        private val IMG_HEIGHT = 100
        // 图片宽度
        private val IMG_WIDTH = 30
        // 验证码长度
        private val CODE_LEN = 4
    }
}