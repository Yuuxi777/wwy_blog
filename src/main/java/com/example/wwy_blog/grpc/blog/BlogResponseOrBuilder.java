// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BlogService.proto

package com.example.wwy_blog.grpc.blog;

public interface BlogResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:BlogResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>string title = 2;</code>
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 2;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string category = 3;</code>
   */
  java.lang.String getCategory();
  /**
   * <code>string category = 3;</code>
   */
  com.google.protobuf.ByteString
      getCategoryBytes();

  /**
   * <code>string context = 4;</code>
   */
  java.lang.String getContext();
  /**
   * <code>string context = 4;</code>
   */
  com.google.protobuf.ByteString
      getContextBytes();

  /**
   * <code>string createTime = 5;</code>
   */
  java.lang.String getCreateTime();
  /**
   * <code>string createTime = 5;</code>
   */
  com.google.protobuf.ByteString
      getCreateTimeBytes();
}