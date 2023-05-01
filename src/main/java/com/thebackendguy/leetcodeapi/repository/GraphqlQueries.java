package com.thebackendguy.leetcodeapi.repository;

public class GraphqlQueries {

    public static String graphqlUrl = "https://leetcode.com/graphql/";

    public static String problemSetQuery = "query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\n" +
            "  problemsetQuestionList: questionList(\n" +
            "    categorySlug: $categorySlug\n" +
            "    limit: $limit\n" +
            "    skip: $skip\n" +
            "    filters: $filters\n" +
            "  ) {\n" +
            "    total: totalNum\n" +
            "    questions: data {\n" +
            "      acRate\n" +
            "      difficulty\n" +
            "      freqBar\n" +
            "      frontendQuestionId: questionFrontendId\n" +
            "      isFavor\n" +
            "      paidOnly: isPaidOnly\n" +
            "      status\n" +
            "      title\n" +
            "      titleSlug\n" +
            "      topicTags {\n" +
            "        name\n" +
            "        id\n" +
            "        slug\n" +
            "      }\n" +
            "      hasSolution\n" +
            "      hasVideoSolution\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public static String variablesJson = "{\n" +
            "  \"categorySlug\": \"\",\n" +
            "  \"skip\": 0,\n" +
            "  \"limit\": 50,\n" +
            "  \"filters\": {}\n" +
            "}";
}
