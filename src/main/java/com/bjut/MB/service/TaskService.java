package com.bjut.MB.service;

import com.bjut.MB.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheng on 2017/12/22.
 */
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    public void addTask(String name, String task){
        taskDao.addTask(name, task);
    }

    public void deleteTask(String name, String task){
        taskDao.deleteOneTask(name, task);
    }

    public void deleteAllTask(String name){
        taskDao.deleteAll(name);
    }

    public List<String> queryTask(String name){
        List<String> tasks = new ArrayList<String>();
        tasks = taskDao.selectByName(name);
        return tasks;
    }
}
