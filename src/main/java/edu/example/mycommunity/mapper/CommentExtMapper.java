package edu.example.mycommunity.mapper;


import edu.example.mycommunity.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}