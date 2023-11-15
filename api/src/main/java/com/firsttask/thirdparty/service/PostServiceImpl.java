package com.firsttask.thirdparty.service;

import com.firsttask.thirdparty.input.ListMobile;
import com.firsttask.thirdparty.output.PostofficeDetail;
import com.firsttask.thirdparty.output.PostofficeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService{

    @Autowired
    RestTemplate restTemplate;
    @Override
    public PostofficeResponse fetchPostofficeDetail(ListMobile listMobile) {

        String url = "https://apigw.salammobile.sa:8081/api/uil/bss/mobile-number/list-mobile-numbers";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.add("x-api-key", "R0FURVdBWV9DSEFOTkVMOkRNUw==");
        headers.add("Content-Type" ,"application/json");
        HttpEntity<Object> entity = new HttpEntity<>(listMobile, headers);

        log.info("List Mobile :"+ listMobile.toString());

        listMobile.setGroupID(listMobile.getGroupID());
        listMobile.setLimit(listMobile.getLimit());
        listMobile.setAscending(listMobile.isAscending());
        listMobile.setPaidType(listMobile.getPaidType());
        listMobile.setTransactionId(listMobile.getTransactionId());

        ResponseEntity<PostofficeResponse> object = restTemplate.exchange(url, HttpMethod.POST, entity, PostofficeResponse.class, new HashMap<String, String>());

        PostofficeResponse body = object.getBody();
        List<PostofficeDetail> details = body.getData().getReferences().stream().filter(x-> x.getState().equals("1")).collect(Collectors.toList());
        body.getData().setReferences(details);


        return body;
    }
}
