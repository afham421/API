package com.firsttask.thirdparty.controller;


import com.firsttask.thirdparty.input.ListMobile;
import com.firsttask.thirdparty.output.PostofficeResponse;
import com.firsttask.thirdparty.service.PostServiceImpl;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/get")
@Slf4j
public class ThirdPartyController {

    @Autowired
    private PostServiceImpl postService;
    @PostMapping(path = "/listMobile", consumes = MediaType.ALL_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public PostofficeResponse getData(@Valid  @RequestBody ListMobile listMobile ){

        log.info("Controller List Mobile  "  + listMobile.toString());
        PostofficeResponse postofficeResponse = postService.fetchPostofficeDetail(listMobile);
        return postofficeResponse;
    }
}
