import { User } from "./user";
import { Elder } from  "./elder";


export class Comment {
  id: number;
title: string;
description: string;
createDate: Date;
CommentAuthor: User;
elder: Elder;
parentComment: Comment;
replies: Comment;

constructor(
  id: number = 0,
  title: string = "",
  description: string = "",
  createDate: Date = new Date(),
   CommentAuthor: User = new User(),
  elder: Elder = new Elder(),
  replies: Comment = new Comment(),
  parentComment: Comment  = new Comment()

  ){
    this.id = id;
    this.title = title;
    this.description = description;
    this.createDate = createDate;
    this.CommentAuthor = CommentAuthor;
    this.elder = elder;
    this.replies = replies;
    this.parentComment = parentComment;
  }
}
