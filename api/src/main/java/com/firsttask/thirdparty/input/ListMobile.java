package com.firsttask.thirdparty.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListMobile {

    int groupID ;
    boolean isAscending ;
    int limit ;
    int paidType ;
    String transactionId ;

}
