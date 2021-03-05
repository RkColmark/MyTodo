package com.IRonak.MyTodo.Service;

import com.IRonak.MyTodo.Entity.Todo;
import com.IRonak.MyTodo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {


    @Autowired
    private TodoRepository todoRepository;

	public List<Todo> getTodosByUser(String user) {
		return todoRepository.findByUser(user);
	}

	public Optional<Todo> getTodoById(int id) {
		return todoRepository.findById(id);
	}

	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
		
	}

	public void addTodo(String user, String desc, Date date) {
		
		todoRepository.save(new Todo(user, desc, date));
		
	}

	public void deleteTodo(int id) {
		
		Optional<Todo> todo =todoRepository.findById(id);
        if(todo.isPresent())
        {
            todoRepository.deleteById(id);
        }

		
	}

	public void saveTodo(Todo todo) {

		todoRepository.save(todo);
		
		
	}

   
}
