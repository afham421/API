
package com.firsttask.thirdparty.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.firsttask.thirdparty.input.ListMobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostofficeResponse {
    @JsonProperty("uilTransactionId")
    String uilTransactionId ;
    @JsonProperty("data")
    private com.firsttask.thirdparty.output.Data data ;



}
