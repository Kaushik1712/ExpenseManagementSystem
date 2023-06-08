package com.ems.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expenseamount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseAmountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private double amount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@ManyToMany
	@JoinTable(name = "participants_expense", joinColumns = @JoinColumn(name = "expense_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<UserEntity> userEntityList;

	@OneToOne(mappedBy = "expense")
	private GroupMemberEntity group;
}
