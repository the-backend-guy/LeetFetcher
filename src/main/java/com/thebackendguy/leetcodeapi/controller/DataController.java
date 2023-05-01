package com.thebackendguy.leetcodeapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thebackendguy.leetcodeapi.exception.DataFetchFailedException;
import com.thebackendguy.leetcodeapi.model.DataResponse;
import com.thebackendguy.leetcodeapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/problemSet")
    public DataResponse problemSet() throws DataFetchFailedException, JsonProcessingException {
        return dataRepository.problemSet();
    }

}
