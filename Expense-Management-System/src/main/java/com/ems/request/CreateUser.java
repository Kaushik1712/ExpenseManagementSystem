package com.ems.request;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

    private String name;

    private String email;

    private String phone;

}
