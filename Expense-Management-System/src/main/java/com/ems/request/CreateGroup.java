package com.ems.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroup {

    private Long groupId;

    private String name;

    private Long created_By;

    List<Long> participantsId;

}
