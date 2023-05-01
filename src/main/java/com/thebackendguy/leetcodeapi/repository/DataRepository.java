package com.thebackendguy.leetcodeapi.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thebackendguy.leetcodeapi.exception.DataFetchFailedException;
import com.thebackendguy.leetcodeapi.model.DataResponse;
import com.thebackendguy.leetcodeapi.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class DataRepository {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HttpUtil httpUtil;

    public DataResponse problemSet() throws DataFetchFailedException, JsonProcessingException {
        log.info("Problem Set Data Fetch Start");

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("query", GraphqlQueries.problemSetQuery);
        requestMap.put("variables", GraphqlQueries.variablesJson);

        String graphqlResponse = null;
        try {
            graphqlResponse = httpUtil.makePostCall(requestMap, GraphqlQueries.graphqlUrl);
            log.info("Problem Set Data Fetch Successful");
        }
        catch (Exception e){
            log.info("Problem Set Data Fetch Failed : " + e.getMessage(), e);
            throw new DataFetchFailedException(e.getMessage());
        }

        DataResponse dataResponse = objectMapper.readValue(graphqlResponse, DataResponse.class);

        return dataResponse;
    }

}
