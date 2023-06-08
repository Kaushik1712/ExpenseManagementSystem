package com.ems.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoleEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
