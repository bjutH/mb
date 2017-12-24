package com.bjut.MB.service;

import com.bjut.MB.dao.TaskDao;
import com.bjut.MB.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheng on 2017/12/22.
 */
@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

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

    public List<Task> queryTaskAll(){
        List<Task> tasks = new ArrayList<Task>();
        tasks = taskDao.selectAll();
        return tasks;
    }
}
