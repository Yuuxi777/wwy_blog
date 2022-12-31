// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BlogService.proto

package com.example.wwy_blog.grpc.blog;

/**
 * Protobuf type {@code proto.BlogsResponse}
 */
public  final class BlogsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.BlogsResponse)
    BlogsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BlogsResponse.newBuilder() to construct.
  private BlogsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BlogsResponse() {
    blogs_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BlogsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              blogs_ = new java.util.ArrayList<com.example.wwy_blog.grpc.blog.BlogResponse>();
              mutable_bitField0_ |= 0x00000001;
            }
            blogs_.add(
                input.readMessage(com.example.wwy_blog.grpc.blog.BlogResponse.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        blogs_ = java.util.Collections.unmodifiableList(blogs_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.wwy_blog.grpc.blog.BlogProto.internal_static_proto_BlogsResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.wwy_blog.grpc.blog.BlogProto.internal_static_proto_BlogsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.wwy_blog.grpc.blog.BlogsResponse.class, com.example.wwy_blog.grpc.blog.BlogsResponse.Builder.class);
  }

  public static final int BLOGS_FIELD_NUMBER = 1;
  private java.util.List<com.example.wwy_blog.grpc.blog.BlogResponse> blogs_;
  /**
   * <code>repeated .proto.BlogResponse blogs = 1;</code>
   */
  public java.util.List<com.example.wwy_blog.grpc.blog.BlogResponse> getBlogsList() {
    return blogs_;
  }
  /**
   * <code>repeated .proto.BlogResponse blogs = 1;</code>
   */
  public java.util.List<? extends com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder> 
      getBlogsOrBuilderList() {
    return blogs_;
  }
  /**
   * <code>repeated .proto.BlogResponse blogs = 1;</code>
   */
  public int getBlogsCount() {
    return blogs_.size();
  }
  /**
   * <code>repeated .proto.BlogResponse blogs = 1;</code>
   */
  public com.example.wwy_blog.grpc.blog.BlogResponse getBlogs(int index) {
    return blogs_.get(index);
  }
  /**
   * <code>repeated .proto.BlogResponse blogs = 1;</code>
   */
  public com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder getBlogsOrBuilder(
      int index) {
    return blogs_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < blogs_.size(); i++) {
      output.writeMessage(1, blogs_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < blogs_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, blogs_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.wwy_blog.grpc.blog.BlogsResponse)) {
      return super.equals(obj);
    }
    com.example.wwy_blog.grpc.blog.BlogsResponse other = (com.example.wwy_blog.grpc.blog.BlogsResponse) obj;

    boolean result = true;
    result = result && getBlogsList()
        .equals(other.getBlogsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getBlogsCount() > 0) {
      hash = (37 * hash) + BLOGS_FIELD_NUMBER;
      hash = (53 * hash) + getBlogsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.wwy_blog.grpc.blog.BlogsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.wwy_blog.grpc.blog.BlogsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.BlogsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.BlogsResponse)
      com.example.wwy_blog.grpc.blog.BlogsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.wwy_blog.grpc.blog.BlogProto.internal_static_proto_BlogsResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.wwy_blog.grpc.blog.BlogProto.internal_static_proto_BlogsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.wwy_blog.grpc.blog.BlogsResponse.class, com.example.wwy_blog.grpc.blog.BlogsResponse.Builder.class);
    }

    // Construct using com.example.wwy_blog.grpc.blog.BlogsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getBlogsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (blogsBuilder_ == null) {
        blogs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        blogsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.wwy_blog.grpc.blog.BlogProto.internal_static_proto_BlogsResponse_descriptor;
    }

    public com.example.wwy_blog.grpc.blog.BlogsResponse getDefaultInstanceForType() {
      return com.example.wwy_blog.grpc.blog.BlogsResponse.getDefaultInstance();
    }

    public com.example.wwy_blog.grpc.blog.BlogsResponse build() {
      com.example.wwy_blog.grpc.blog.BlogsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.example.wwy_blog.grpc.blog.BlogsResponse buildPartial() {
      com.example.wwy_blog.grpc.blog.BlogsResponse result = new com.example.wwy_blog.grpc.blog.BlogsResponse(this);
      int from_bitField0_ = bitField0_;
      if (blogsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          blogs_ = java.util.Collections.unmodifiableList(blogs_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.blogs_ = blogs_;
      } else {
        result.blogs_ = blogsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.wwy_blog.grpc.blog.BlogsResponse) {
        return mergeFrom((com.example.wwy_blog.grpc.blog.BlogsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.wwy_blog.grpc.blog.BlogsResponse other) {
      if (other == com.example.wwy_blog.grpc.blog.BlogsResponse.getDefaultInstance()) return this;
      if (blogsBuilder_ == null) {
        if (!other.blogs_.isEmpty()) {
          if (blogs_.isEmpty()) {
            blogs_ = other.blogs_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureBlogsIsMutable();
            blogs_.addAll(other.blogs_);
          }
          onChanged();
        }
      } else {
        if (!other.blogs_.isEmpty()) {
          if (blogsBuilder_.isEmpty()) {
            blogsBuilder_.dispose();
            blogsBuilder_ = null;
            blogs_ = other.blogs_;
            bitField0_ = (bitField0_ & ~0x00000001);
            blogsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getBlogsFieldBuilder() : null;
          } else {
            blogsBuilder_.addAllMessages(other.blogs_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.wwy_blog.grpc.blog.BlogsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.wwy_blog.grpc.blog.BlogsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.example.wwy_blog.grpc.blog.BlogResponse> blogs_ =
      java.util.Collections.emptyList();
    private void ensureBlogsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        blogs_ = new java.util.ArrayList<com.example.wwy_blog.grpc.blog.BlogResponse>(blogs_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.wwy_blog.grpc.blog.BlogResponse, com.example.wwy_blog.grpc.blog.BlogResponse.Builder, com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder> blogsBuilder_;

    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public java.util.List<com.example.wwy_blog.grpc.blog.BlogResponse> getBlogsList() {
      if (blogsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(blogs_);
      } else {
        return blogsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public int getBlogsCount() {
      if (blogsBuilder_ == null) {
        return blogs_.size();
      } else {
        return blogsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public com.example.wwy_blog.grpc.blog.BlogResponse getBlogs(int index) {
      if (blogsBuilder_ == null) {
        return blogs_.get(index);
      } else {
        return blogsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder setBlogs(
        int index, com.example.wwy_blog.grpc.blog.BlogResponse value) {
      if (blogsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBlogsIsMutable();
        blogs_.set(index, value);
        onChanged();
      } else {
        blogsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder setBlogs(
        int index, com.example.wwy_blog.grpc.blog.BlogResponse.Builder builderForValue) {
      if (blogsBuilder_ == null) {
        ensureBlogsIsMutable();
        blogs_.set(index, builderForValue.build());
        onChanged();
      } else {
        blogsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder addBlogs(com.example.wwy_blog.grpc.blog.BlogResponse value) {
      if (blogsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBlogsIsMutable();
        blogs_.add(value);
        onChanged();
      } else {
        blogsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder addBlogs(
        int index, com.example.wwy_blog.grpc.blog.BlogResponse value) {
      if (blogsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBlogsIsMutable();
        blogs_.add(index, value);
        onChanged();
      } else {
        blogsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder addBlogs(
        com.example.wwy_blog.grpc.blog.BlogResponse.Builder builderForValue) {
      if (blogsBuilder_ == null) {
        ensureBlogsIsMutable();
        blogs_.add(builderForValue.build());
        onChanged();
      } else {
        blogsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder addBlogs(
        int index, com.example.wwy_blog.grpc.blog.BlogResponse.Builder builderForValue) {
      if (blogsBuilder_ == null) {
        ensureBlogsIsMutable();
        blogs_.add(index, builderForValue.build());
        onChanged();
      } else {
        blogsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder addAllBlogs(
        java.lang.Iterable<? extends com.example.wwy_blog.grpc.blog.BlogResponse> values) {
      if (blogsBuilder_ == null) {
        ensureBlogsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, blogs_);
        onChanged();
      } else {
        blogsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder clearBlogs() {
      if (blogsBuilder_ == null) {
        blogs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        blogsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public Builder removeBlogs(int index) {
      if (blogsBuilder_ == null) {
        ensureBlogsIsMutable();
        blogs_.remove(index);
        onChanged();
      } else {
        blogsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public com.example.wwy_blog.grpc.blog.BlogResponse.Builder getBlogsBuilder(
        int index) {
      return getBlogsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder getBlogsOrBuilder(
        int index) {
      if (blogsBuilder_ == null) {
        return blogs_.get(index);  } else {
        return blogsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public java.util.List<? extends com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder> 
         getBlogsOrBuilderList() {
      if (blogsBuilder_ != null) {
        return blogsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(blogs_);
      }
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public com.example.wwy_blog.grpc.blog.BlogResponse.Builder addBlogsBuilder() {
      return getBlogsFieldBuilder().addBuilder(
          com.example.wwy_blog.grpc.blog.BlogResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public com.example.wwy_blog.grpc.blog.BlogResponse.Builder addBlogsBuilder(
        int index) {
      return getBlogsFieldBuilder().addBuilder(
          index, com.example.wwy_blog.grpc.blog.BlogResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.BlogResponse blogs = 1;</code>
     */
    public java.util.List<com.example.wwy_blog.grpc.blog.BlogResponse.Builder> 
         getBlogsBuilderList() {
      return getBlogsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.wwy_blog.grpc.blog.BlogResponse, com.example.wwy_blog.grpc.blog.BlogResponse.Builder, com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder> 
        getBlogsFieldBuilder() {
      if (blogsBuilder_ == null) {
        blogsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.example.wwy_blog.grpc.blog.BlogResponse, com.example.wwy_blog.grpc.blog.BlogResponse.Builder, com.example.wwy_blog.grpc.blog.BlogResponseOrBuilder>(
                blogs_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        blogs_ = null;
      }
      return blogsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proto.BlogsResponse)
  }

  // @@protoc_insertion_point(class_scope:proto.BlogsResponse)
  private static final com.example.wwy_blog.grpc.blog.BlogsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.wwy_blog.grpc.blog.BlogsResponse();
  }

  public static com.example.wwy_blog.grpc.blog.BlogsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BlogsResponse>
      PARSER = new com.google.protobuf.AbstractParser<BlogsResponse>() {
    public BlogsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BlogsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BlogsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BlogsResponse> getParserForType() {
    return PARSER;
  }

  public com.example.wwy_blog.grpc.blog.BlogsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
