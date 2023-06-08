package com.ems.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpense {

    private Long expenseId;

    private String name;

    private double amount;

    private Long created_By;
    List<Long> participantsId;
}
