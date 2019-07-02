package com.codecool.web.service;

import com.codecool.web.model.*;
import com.codecool.web.service.exception.ServiceException;

import java.util.List;

public interface TaskService {

    List<Task1> Task1Service() throws ServiceException;

    List<Task2> Task2Service() throws ServiceException;

    List<Task3> Task3Service() throws ServiceException;

    List<Task4> Task4Service() throws ServiceException;

    List<Task5> Task5Service() throws ServiceException;
}

