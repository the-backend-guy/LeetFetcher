package com.thebackendguy.leetcodeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private int acRate;
    private String difficulty;
    private String title;
    private String titleSlug;
    private String frontendQuestionId;
    private List<TopicTag> topicTags;
}
