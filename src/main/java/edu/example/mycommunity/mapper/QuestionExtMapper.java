package edu.example.mycommunity.mapper;

import edu.example.mycommunity.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}