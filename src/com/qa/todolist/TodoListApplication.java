package com.qa.todolist;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import com.qa.todolist.model.Todo;
import com.qa.todolist.model.TodoList;

public class TodoListApplication {
	
	private TodoList todoList;
	private Scanner sc;

	public void run() {
		//Our todo list application starts here
		todoList = new TodoList();
		sc = new Scanner(System.in);
		boolean isRunning = true;
		
		//Setup a REPL
		//- Read, Eval, Print, Loop
		//1. Read in an instruction from the console
		//2. Evaluate the instruction
		//3. Print the result to the console
		//4. Repeat steps 1-3
		do {
			System.out.println("=== TodoList Application Menu===\n");
			System.out.println("(1) Add a new task");
			System.out.println("(2) Review current list of all tasks");
			System.out.println("(3) Filter tasks by name");
			System.out.println("(4) Delete a task");
			System.out.println("(5) Exit");
			
			//get input
			System.out.println("> ");
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				//get info for the new todo item
				System.out.println("Name: ");
				String todoName = sc.nextLine();
				System.out.println("Task: ");
				String todoTask = sc.nextLine();
				System.out.println("Due (yyyy-mm-dd: ");
				String date = sc.nextLine();
				
				//add the todo item to the list
				Todo todo = new Todo();
				todo.setName(todoName);
				todo.setTask(todoTask);
				todo.setDueDate(LocalDate.parse(date));
				boolean didAdd = todoList.add(todo);
				
				
				//confirm if this occured or not to the user
				if (didAdd) System.out.println("New todo item addedd successfully");
				else System.out.println("New todo item could not be added, does it already exist?");
				break;
				
			case "2":
				System.out.println("The current tasks are: \n");
				System.out.println(todoList.view());
				System.out.println("\n");
				
			break;
			case "3":
				System.out.println("Enter the name of the user you wish to inspect");
				String name = sc.nextLine();
				System.out.println(todoList.viewUser(name));	
				break;
				
			case "4":
			System.out.println("Enter the name of the user: ");
			String nameSearch = sc.nextLine();
			System.out.println(todoList.viewUser(nameSearch));
			System.out.println("Enter the name of the task you wish to remove: ");
			String taskRemove = sc.nextLine();
			System.out.println(todoList.removeTask(taskRemove));
			
			break;
			case "5":
				System.out.println("You have exited the app, see you next time!");
				isRunning = false;
				break;
			default:
				System.out.println("\nPlease enter a valid option\n");
			}
			
		} while (isRunning == true);		
		
	}

}
