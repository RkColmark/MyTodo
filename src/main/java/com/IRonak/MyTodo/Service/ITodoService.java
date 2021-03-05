package com.IRonak.MyTodo.Service;

import com.IRonak.MyTodo.Entity.Todo;

import java.util.Date;

import java.util.List;
import java.util.Optional;



public interface ITodoService {

    List<Todo> getTodosByUser(String user);

    Optional<Todo> getTodoById(int id);

    void updateTodo(Todo todo);

    void addTodo(String user, String desc, Date date);

    void deleteTodo(int id);

    void saveTodo(Todo todo);

}
