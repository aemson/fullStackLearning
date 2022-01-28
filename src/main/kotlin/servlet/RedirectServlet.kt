package com.fsl.servlet

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/tracking/*"], loadOnStartup = 1)
class RedirectServlet: HttpServlet() {

    @Throws(IOException::class, ServletException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse?) {
        doGet(request, response)
    }

    @Throws(IOException::class, ServletException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse?) {
        val dispatcher = servletContext
            .getRequestDispatcher(request.requestURI.split("/tracking")[1])
        dispatcher.forward(request, response)
    }
}