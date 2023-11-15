package com.firsttask.thirdparty.service;

import com.firsttask.thirdparty.input.ListMobile;
import com.firsttask.thirdparty.output.PostofficeResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {
    public PostofficeResponse fetchPostofficeDetail(ListMobile listMobile);
}
