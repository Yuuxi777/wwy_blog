package com.example.wwy_blog.grpc.blog;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: BlogService.proto")
public final class BlogServiceGrpc {

  private BlogServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.BlogService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBlogByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogRequest,
      com.example.wwy_blog.grpc.blog.BlogResponse> METHOD_GET_BLOG_BY_ID = getGetBlogByIdMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogRequest,
      com.example.wwy_blog.grpc.blog.BlogResponse> getGetBlogByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogRequest,
      com.example.wwy_blog.grpc.blog.BlogResponse> getGetBlogByIdMethod() {
    return getGetBlogByIdMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogRequest,
      com.example.wwy_blog.grpc.blog.BlogResponse> getGetBlogByIdMethodHelper() {
    io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogRequest, com.example.wwy_blog.grpc.blog.BlogResponse> getGetBlogByIdMethod;
    if ((getGetBlogByIdMethod = BlogServiceGrpc.getGetBlogByIdMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getGetBlogByIdMethod = BlogServiceGrpc.getGetBlogByIdMethod) == null) {
          BlogServiceGrpc.getGetBlogByIdMethod = getGetBlogByIdMethod = 
              io.grpc.MethodDescriptor.<com.example.wwy_blog.grpc.blog.BlogRequest, com.example.wwy_blog.grpc.blog.BlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.BlogService", "GetBlogById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.wwy_blog.grpc.blog.BlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.wwy_blog.grpc.blog.BlogResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("GetBlogById"))
                  .build();
          }
        }
     }
     return getGetBlogByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllBlogsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogsRequest,
      com.example.wwy_blog.grpc.blog.BlogsResponse> METHOD_GET_ALL_BLOGS = getGetAllBlogsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogsRequest,
      com.example.wwy_blog.grpc.blog.BlogsResponse> getGetAllBlogsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogsRequest,
      com.example.wwy_blog.grpc.blog.BlogsResponse> getGetAllBlogsMethod() {
    return getGetAllBlogsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogsRequest,
      com.example.wwy_blog.grpc.blog.BlogsResponse> getGetAllBlogsMethodHelper() {
    io.grpc.MethodDescriptor<com.example.wwy_blog.grpc.blog.BlogsRequest, com.example.wwy_blog.grpc.blog.BlogsResponse> getGetAllBlogsMethod;
    if ((getGetAllBlogsMethod = BlogServiceGrpc.getGetAllBlogsMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getGetAllBlogsMethod = BlogServiceGrpc.getGetAllBlogsMethod) == null) {
          BlogServiceGrpc.getGetAllBlogsMethod = getGetAllBlogsMethod = 
              io.grpc.MethodDescriptor.<com.example.wwy_blog.grpc.blog.BlogsRequest, com.example.wwy_blog.grpc.blog.BlogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.BlogService", "GetAllBlogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.wwy_blog.grpc.blog.BlogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.wwy_blog.grpc.blog.BlogsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("GetAllBlogs"))
                  .build();
          }
        }
     }
     return getGetAllBlogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlogServiceStub newStub(io.grpc.Channel channel) {
    return new BlogServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BlogServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BlogServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BlogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBlogById(com.example.wwy_blog.grpc.blog.BlogRequest request,
        io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlogByIdMethodHelper(), responseObserver);
    }

    /**
     */
    public void getAllBlogs(com.example.wwy_blog.grpc.blog.BlogsRequest request,
        io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllBlogsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBlogByIdMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.wwy_blog.grpc.blog.BlogRequest,
                com.example.wwy_blog.grpc.blog.BlogResponse>(
                  this, METHODID_GET_BLOG_BY_ID)))
          .addMethod(
            getGetAllBlogsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.wwy_blog.grpc.blog.BlogsRequest,
                com.example.wwy_blog.grpc.blog.BlogsResponse>(
                  this, METHODID_GET_ALL_BLOGS)))
          .build();
    }
  }

  /**
   */
  public static final class BlogServiceStub extends io.grpc.stub.AbstractStub<BlogServiceStub> {
    private BlogServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceStub(channel, callOptions);
    }

    /**
     */
    public void getBlogById(com.example.wwy_blog.grpc.blog.BlogRequest request,
        io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlogByIdMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllBlogs(com.example.wwy_blog.grpc.blog.BlogsRequest request,
        io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllBlogsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlogServiceBlockingStub extends io.grpc.stub.AbstractStub<BlogServiceBlockingStub> {
    private BlogServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.wwy_blog.grpc.blog.BlogResponse getBlogById(com.example.wwy_blog.grpc.blog.BlogRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBlogByIdMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.example.wwy_blog.grpc.blog.BlogsResponse getAllBlogs(com.example.wwy_blog.grpc.blog.BlogsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllBlogsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlogServiceFutureStub extends io.grpc.stub.AbstractStub<BlogServiceFutureStub> {
    private BlogServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.wwy_blog.grpc.blog.BlogResponse> getBlogById(
        com.example.wwy_blog.grpc.blog.BlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlogByIdMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.wwy_blog.grpc.blog.BlogsResponse> getAllBlogs(
        com.example.wwy_blog.grpc.blog.BlogsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllBlogsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BLOG_BY_ID = 0;
  private static final int METHODID_GET_ALL_BLOGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BLOG_BY_ID:
          serviceImpl.getBlogById((com.example.wwy_blog.grpc.blog.BlogRequest) request,
              (io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_BLOGS:
          serviceImpl.getAllBlogs((com.example.wwy_blog.grpc.blog.BlogsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.wwy_blog.grpc.blog.BlogsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.wwy_blog.grpc.blog.BlogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlogService");
    }
  }

  private static final class BlogServiceFileDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier {
    BlogServiceFileDescriptorSupplier() {}
  }

  private static final class BlogServiceMethodDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BlogServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlogServiceFileDescriptorSupplier())
              .addMethod(getGetBlogByIdMethodHelper())
              .addMethod(getGetAllBlogsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
