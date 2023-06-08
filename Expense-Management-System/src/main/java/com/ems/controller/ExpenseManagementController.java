package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.request.AssignExpense;
import com.ems.request.CreateExpense;
import com.ems.request.CreateGroup;
import com.ems.request.CreateUser;
import com.ems.request.UserAdminLogin;
import com.ems.service.UserService;

public class ExpenseManagementController {
	@Autowired
	UserService userService;

	@PostMapping("/createuser")
	String createUser(@RequestBody CreateUser createUser) {
		userService.createUser(createUser);
		return "Create User Successfully";
	}

	@PostMapping("/creategroup")
	String createGroup(@RequestBody CreateGroup createGroup) {
		userService.createGroup(createGroup);
		return "Create Group Successfully";
	}

	@PostMapping("/createAdmin")
	String createAdmin(@RequestBody UserAdminLogin userAdminLogin) {
		userService.createAdmin(userAdminLogin);
		return "Create Admin Successfully";
	}

	@PostMapping("/addparticipants")
	String addParticipants(@RequestBody CreateGroup createGroup) {
		userService.addParticipants(createGroup);
		return "Add Participants Successfully";
	}

	@PostMapping("/createexpense")
	String createExpense(@RequestBody CreateExpense createExpense) {
		userService.createExpense(createExpense);
		return "Create Expense Successfully";
	}

	@PostMapping("/createparticipantsexpense")
	String addParticipantsExpense(@RequestBody CreateExpense createExpense) {
		userService.addExpenseParticipants(createExpense);
		return "Create Participant Expense Successfully";
	}

	@PostMapping("/assignexpense")
	String assignExpenseToGroup(@RequestBody AssignExpense assignExpense) {
		userService.assignExpense(assignExpense);
		return "Asssign Expense Successfully";
	}

	@GetMapping("/splittamount/{split}")
	double splitamount(@PathVariable Long expenseId) {
		double split = userService.divideExpense(expenseId);
		return split;
	}
}
