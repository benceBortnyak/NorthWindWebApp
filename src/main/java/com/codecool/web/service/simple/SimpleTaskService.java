package com.codecool.web.service.simple;

import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.*;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTaskService implements TaskService {

    private final DataBaseTasksDao dataBaseTasksDao;

    public SimpleTaskService(DataBaseTasksDao dataBaseTasksDao) {
        this.dataBaseTasksDao = dataBaseTasksDao;
    }

    public List<Task1> Task1Service() throws ServiceException {
        try {
            return dataBaseTasksDao.getTask1();
        } catch (SQLException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Task2> Task2Service() throws ServiceException {
        try {
            return dataBaseTasksDao.getTask2();
        } catch (SQLException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Task3> Task3Service() throws ServiceException {
        try {
            return dataBaseTasksDao.getTask3();
        } catch (SQLException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Task4> Task4Service() throws ServiceException {
        try {
            return dataBaseTasksDao.getTask4();
        } catch (SQLException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Task5> Task5Service() throws ServiceException {
        try {
            return dataBaseTasksDao.getTask5();
        } catch (SQLException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
