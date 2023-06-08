package com.ems.service;

import com.ems.request.AssignExpense;
import com.ems.request.CreateExpense;
import com.ems.request.CreateGroup;
import com.ems.request.CreateUser;
import com.ems.request.UserAdminLogin;

public interface UserService {
	
    String createUser(CreateUser createUser);
    String createGroup(CreateGroup createGroup);
    String createAdmin(UserAdminLogin userAdminLogin);

    String addParticipants(CreateGroup createGroup);

    String createExpense(CreateExpense createExpense);

    String addExpenseParticipants(CreateExpense createExpense);

    String assignExpense(AssignExpense assignExpense);

    double divideExpense(Long expenseId);

}
