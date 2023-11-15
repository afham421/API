package com.firsttask.thirdparty.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostofficeDetail {


    @JsonProperty("paidType")
    String paidType ;
    @JsonProperty("identifier")
    String identifier ;
    @JsonProperty("feeAmount")
    String feeAmount;
    @JsonProperty("groupID")
    String groupID ;
    @JsonProperty("technology")
    String technology ;
    @JsonProperty("state")
    String state ;
    @JsonProperty("spid")
    String spid;

}
