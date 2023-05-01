package com.thebackendguy.leetcodeapi.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
@Slf4j
public class HttpUtil {

    @Autowired
    private RestTemplate restTemplate;

    public String makePostCall(Map<String, Object> requestMap, String url) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestMap, headers);

        String response = null;
        try {
            log.info("Making API call to URL : " + url);
            ResponseEntity<String> httpResponse = restTemplate.postForEntity(url, request, String.class);
            log.info("Successfully received response with status : " + httpResponse.getStatusCode());
            response = httpResponse.getBody();
        }
        catch (Exception e){
            log.info("Failed to fetch data from API : " + e.getMessage(), e);
            throw new Exception("Failed to fetch data from API");
        }

        if(StringUtils.isNotEmpty(response))
            return response;
        else
            throw new Exception("Empty Response Received Exception");
    }
}
