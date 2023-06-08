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
@Table(name = "grp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupMemberEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @ManyToMany
	    @JoinTable(name = "grp_participants", joinColumns = @JoinColumn(name = "grp_id"),
	            inverseJoinColumns = @JoinColumn(name = "participants_id"))
	    private List<UserEntity> usergroupEntityList;

	    @ManyToOne
	    @JoinColumn(name = "created_by")
	    private UserEntity userEntity;

	    @OneToOne
	    @JoinColumn(name = "expense_id")
	    private ExpenseAmountEntity expense;
}
