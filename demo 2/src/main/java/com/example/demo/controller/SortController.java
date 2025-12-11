package com.example.demo.controller;

import com.example.demo.dto.CustomRequest;
import com.example.demo.service.SortService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/sort")//path
public class SortController {

    @Autowired
    SortService service;

    @PostMapping("/insertion")//endpoint
    public int[] postMethodName(@RequestBody CustomRequest request) {
        //TODO: process POST request

        String requestData = request.getData();
        String[] stringData = requestData.split(",");
        int[] arrNum = new int[stringData.length];
        for (int i = 0; i < stringData.length; i++) {
            arrNum[i] = Integer.parseInt(stringData[i]);
        }
        return service.sort(arrNum);
    }
}
