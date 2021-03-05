package com.IRonak.MyTodo.Repository;

import com.IRonak.MyTodo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findByUser(String user);
}
