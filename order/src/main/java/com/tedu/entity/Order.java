package com.tedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private User user;
    private Menu menu;
    private Admin amin;
    private Date date;
    private int state;
}
