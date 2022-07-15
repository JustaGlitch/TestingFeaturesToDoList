package com.qa.todolist.model;

import java.util.ArrayList;

public class TodoList {

	private long idCounter = 1;
	private ArrayList<Todo> todoItems = new ArrayList<>();
	// As Todo is in the same package, we don't need to import it

	// ids and name must be unique
	public boolean add(Todo todo) {
		for (int i = 0; i < todoItems.size(); i++) {
			Todo current = todoItems.get(i);

			if (todo.getId() == current.getId()) {
				// Rule of thumb for equality: only use == for primitive types
				return false;
//			} else if (todo.getName().equals(current.getName())) {
//				//all reference types have a .equals() method on them
//				//-this should be used for comparing them
//				//- == compares the value in the variable, which with reference types is the reference rather than the object itself
//				return false;
				
				//Got rid of equals to name as i wanted multiple tasks possible per user
			} else if (todo.getTask().equals(current.getTask()))
				return false;
		}
		// if we get all the way through the loop, the Todo musn't exist
		todo.setId(idCounter++);
		todoItems.add(todo);
		return true;

	}

	public ArrayList<String> view() {
		// Create new public method that returns an array list of strings

		ArrayList<String> elloList = new ArrayList<String>();
		// declare new list named = elloList

		for (int i = 0; i < todoItems.size(); i++) {
			// loop through todoItems
			Todo current = todoItems.get(i);
			// set current to corresponding todoItem

			String output = "Name: " + current.getName() + " Task: " + current.getTask();
			elloList.add(output);
			// adding string values to new array - eg. "Justin-Clean"
		}
		return elloList;
		// returns the new array
	}

	public String viewUser(String name) {
		
		ArrayList<String> userList = new ArrayList<String>();
		//creating a new list named userList

		for (int i = 0; i < todoItems.size(); i++) {
			//loop through todoItems
			Todo current = todoItems.get(i);
			//set current to corresponding todoItem
			
			if (name.equals(current.getName())) {
				//if name enter matches name in tasks--
				
				String output = " Tasks: " + current.getTask();
				userList.add(output);
				//print all tasks with name = input
			}

				}
			
		
		return userList.toString();
				
	}
	public String removeTask(String task) {
		
		for (int i = 0; i < todoItems.size(); i++) {
			Todo current = todoItems.get(i);
			
			if (task.equals(current.getTask())) {
				todoItems.remove(i);
				System.out.println("Removed task from list!\n");
				}

}
		return task;
	}
}
	

//	public ArrayList<Todo> view() {
//		ArrayList<Todo> newList = new ArrayList<>();
//		return todoItems;
//	}
