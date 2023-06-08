package com.ems.serviceImpl;

import com.ems.entity.ExpenseAmountEntity;
import com.ems.entity.GroupMemberEntity;
import com.ems.entity.UserEntity;
import com.ems.repository.ExpenseRepository;
import com.ems.repository.GroupRepository;
import com.ems.repository.UserRepository;
import com.ems.request.AssignExpense;
import com.ems.request.CreateExpense;
import com.ems.request.CreateGroup;
import com.ems.request.CreateUser;
import com.ems.request.UserAdminLogin;
import com.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public String createUser(CreateUser createUser) {
        UserEntity userEntity = UserEntity.builder()
                .email(createUser.getEmail())
                .name(createUser.getName())
                .phone(createUser.getPhone())
                .build();
        userRepository.save(userEntity);
        return "User Created";
    }
    @Override
	public String createAdmin(UserAdminLogin userAdminLogin) {
    	UserEntity admin=UserEntity.builder().email(userAdminLogin.getEmail())
    	.name(userAdminLogin.getName()).phone(userAdminLogin.getPhone()).password(userAdminLogin.getPassword()).build();
    	userRepository.save(admin);
    	return "Admin Created";
	}


    @Override
    public String createGroup(CreateGroup createGroup) {
        UserEntity userEntity = convertToEntity(createGroup.getCreated_By());
        List<UserEntity> participants = createGroup.getParticipantsId().stream().map(this::convertToEntity).collect(Collectors.toList());
        GroupMemberEntity group = GroupMemberEntity.builder()
                .name(createGroup.getName())
                .userEntity(userEntity)
                .usergroupEntityList(participants)
                .build();
        groupRepository.save(group);
        return "Group Created";
    }

    @Override
    public String addParticipants(CreateGroup createGroup) {
        GroupMemberEntity group = groupRepository.findById(createGroup.getGroupId()).orElseThrow(null);
        createGroup.getParticipantsId().addAll(group.getUsergroupEntityList().stream().map(UserEntity::getId).collect(Collectors.toList()));
        List<UserEntity> participants = createGroup.getParticipantsId().stream().map(this::convertToEntity).collect(Collectors.toList());
        group.setUsergroupEntityList(participants);
        groupRepository.save(group);
        return "Participants add in existing groups";
    }

    public UserEntity convertToEntity(Long id){
      return userRepository.findById(id).orElseThrow(null);

    }
    @Override
    public String createExpense(CreateExpense createExpense) {
        UserEntity userEntity = convertToEntity(createExpense.getCreated_By());
        List<UserEntity> participants = createExpense.getParticipantsId().stream().map(this::convertToEntity).collect(Collectors.toList());
        ExpenseAmountEntity expense = ExpenseAmountEntity.builder()
                .userEntity(userEntity)
                .amount(createExpense.getAmount())
                .name(createExpense.getName())
                .userEntityList(participants)
                .build();
        expenseRepository.save(expense);
        return null;
    }

    @Override
    public String addExpenseParticipants(CreateExpense createExpense) {
    	ExpenseAmountEntity expense = expenseRepository.findById(createExpense.getExpenseId()).orElseThrow(null);
        createExpense.getParticipantsId().addAll(expense.getUserEntityList().stream().map(UserEntity::getId).collect(Collectors.toList()));
        List<UserEntity> participants = createExpense.getParticipantsId().stream().map(this::convertToEntity).collect(Collectors.toList());
        expense.setUserEntityList(participants);
        expenseRepository.save(expense);
        return null;
    }

    @Override
    public String assignExpense(AssignExpense assignExpense) {
    	ExpenseAmountEntity expense = expenseRepository.findById(assignExpense.getExpenseId()).orElseThrow(null);
        GroupMemberEntity group = groupRepository.findById(assignExpense.getGroupId()).orElseThrow(null);
       group.setExpense(expense);
       groupRepository.save(group);
        return null;
    }

    @Override
    public double divideExpense(Long expenseId) {
    	ExpenseAmountEntity expense = expenseRepository.findById(expenseId).orElseThrow(null);
        if(expense.getGroup() != null){
            GroupMemberEntity groupEntity = expense.getGroup();
           return expense.getAmount()/groupEntity.getUsergroupEntityList().size();
        }else {
            List<UserEntity> userEntity = expense.getUserEntityList();
            return expense.getAmount()/userEntity.size();
        }
    }

	
}
