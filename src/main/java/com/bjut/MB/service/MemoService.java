package com.bjut.MB.service;

import com.bjut.MB.dao.YiqiDao;
import com.bjut.MB.model.Memo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */
@Service
public class MemoService {
    private static final Logger logger = LoggerFactory.getLogger(MemoService.class);

    @Autowired
    private YiqiDao yiqiDao;

    /**
     *
     * @param orderNum      产品编号
     * @param process       备忘录名称
     * @param path           文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addMemo(String orderNum,String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "备忘录编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "备忘录路径不能为空！");
            return map;
        }
        try {
            yiqiDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process      备忘录名称
     * @param number    编号
     * @param boardNum  板号
     * @param weld      焊接
     * @param debug     调试
     * @param test      检验
     * @param version   软件版本号
     * @param ps         备注
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateMemo(String orderNum,String process,String number,String boardNum,
                                          String weld,String debug,String test,String version,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "备忘录编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        try {
            yiqiDao.updateItem(orderNum, process, number, boardNum, weld, debug, test, version, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Memo的List集合
     */
    public List<Memo> selectMemo(String orderNum){
        return yiqiDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Memo的process的List集合
     */
    public List<String> selectMemoProcess(String orderNum){
        List<Memo> memos = yiqiDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(Memo memo : memos){
            String string = memo.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   备忘录名称
     * @return          返回一个Memo对象
     */
    public Memo selectMemo(String orderNum, String process){
        return yiqiDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return yiqiDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteMemo(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "备忘录编号不能为空！");
            return map;
        }
        try {
            yiqiDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
