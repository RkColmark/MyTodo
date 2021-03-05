package com.IRonak.MyTodo.Controller;


import com.IRonak.MyTodo.Entity.Todo;
import com.IRonak.MyTodo.Service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

   /* @GetMapping("/hello")
    public String Hello()
    {
        return "welcome";
    }*/
    
    @GetMapping("/")
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		return "welcome";
	}
    
    
    
    @GetMapping("/list")
    public  String showTodos(ModelMap model)
    {
        String name = getLoggedInUserName(model);
        model.put("todos", todoService.getTodosByUser(name));

        return "list";

    }
    
    
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}


    private String getLoggedInUserName(ModelMap model)
    {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principle instanceof UserDetails)
        {
            return ((UserDetails) principle).getUsername();
        }
        return principle.toString();
    }


    @GetMapping("/add")
    public String showAddTodoPage(ModelMap model)
    {
    	
    	Todo todo =new Todo();
    	
    	
        model.addAttribute("todo",todo);
        
        return "todo";
    }


    @GetMapping("/delete")
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);

        return "redirect:/list";
    }

    @GetMapping("/showupdate")
    public String showTodoPage(@RequestParam int id , ModelMap model)
    {
        Todo todo = todoService.getTodoById(id).get();
        model.put("todo",todo);
        
        return "todo";

    }

    @PostMapping("/update")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUser(getLoggedInUserName(model));
        todoService.updateTodo(todo);
        return "redirect:/list";
    }


    @PostMapping("/save")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
        	
        	return "todo";
        }

        todo.setUser(getLoggedInUserName(model));
        todoService.saveTodo(todo);
        return "redirect:/list";
    }
}
