package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.GroupMemberEntity;


public interface GroupRepository extends JpaRepository<GroupMemberEntity,Long> {

}
