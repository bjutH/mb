package com.bjut.MB.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/23.
 */

/**
 * pageoffice在线修改后保存
 */
@Controller
public class SavePageOfficeController {

    private static final Logger logger = LoggerFactory.getLogger(SavePageOfficeController.class);

    @RequestMapping(path = {"/savefile"})
    public void saveToFile(String name, HttpServletRequest request, HttpServletResponse response)
                            throws ServletException,java.io.IOException,java.lang.Exception{
        FileSaver fs = new FileSaver(request,response);
        // 保存当前文档到服务器文件夹。
        fs.saveToFile(request.getSession().getServletContext().getRealPath("excel") + "/" + fs.getFileName());
        // 文档保存最后需调用 close 方法。
        fs.close();
    }
}
