package com.thebackendguy.leetcodeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private ProblemsetQuestionList problemsetQuestionList;

}
