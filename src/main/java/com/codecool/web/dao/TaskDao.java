package com.codecool.web.dao;

import com.codecool.web.model.*;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {


    List<Task1> getTask1() throws SQLException;

    List<Task2> getTask2() throws SQLException;

    List<Task3> getTask3() throws SQLException;

    List<Task4> getTask4() throws SQLException;

    List<Task5> getTask5() throws SQLException;


}
