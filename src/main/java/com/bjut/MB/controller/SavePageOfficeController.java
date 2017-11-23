package com.bjut.MB.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/23.
 */
@Controller
public class SavePageOfficeController {
    @RequestMapping(path = {"/savefile"})
    public void saveToFile(String name, HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            java.io.IOException,
            java.lang.Exception{
        FileSaver fs = new FileSaver(request,response);
        // 保存当前文档到服务器文件夹。
        fs.saveToFile(request.getSession().getServletContext().getRealPath("excel") + "/" + fs.getFileName());
        // 文档保存最后需调用 close 方法。
        fs.close();
    }
}
