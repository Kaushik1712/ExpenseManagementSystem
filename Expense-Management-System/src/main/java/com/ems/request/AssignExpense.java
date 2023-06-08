package com.ems.request;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignExpense {

    private Long groupId;

    private Long expenseId;
}
