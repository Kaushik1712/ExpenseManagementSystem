package com.ems.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminLogin {
	  private String name;

	    private String email;

	    private String phone;
	    
	    private String password;
}
