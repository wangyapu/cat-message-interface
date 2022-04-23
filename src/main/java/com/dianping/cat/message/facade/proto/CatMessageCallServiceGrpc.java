package com.dianping.cat.message.facade.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: message_facade.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CatMessageCallServiceGrpc {

  private CatMessageCallServiceGrpc() {}

  public static final String SERVICE_NAME = "CatMessageCallService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.CatMessageRequest,
      com.dianping.cat.message.facade.proto.CatMessageResponse> getOnMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessage",
      requestType = com.dianping.cat.message.facade.proto.CatMessageRequest.class,
      responseType = com.dianping.cat.message.facade.proto.CatMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.CatMessageRequest,
      com.dianping.cat.message.facade.proto.CatMessageResponse> getOnMessageMethod() {
    io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.CatMessageRequest, com.dianping.cat.message.facade.proto.CatMessageResponse> getOnMessageMethod;
    if ((getOnMessageMethod = CatMessageCallServiceGrpc.getOnMessageMethod) == null) {
      synchronized (CatMessageCallServiceGrpc.class) {
        if ((getOnMessageMethod = CatMessageCallServiceGrpc.getOnMessageMethod) == null) {
          CatMessageCallServiceGrpc.getOnMessageMethod = getOnMessageMethod =
              io.grpc.MethodDescriptor.<com.dianping.cat.message.facade.proto.CatMessageRequest, com.dianping.cat.message.facade.proto.CatMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dianping.cat.message.facade.proto.CatMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dianping.cat.message.facade.proto.CatMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatMessageCallServiceMethodDescriptorSupplier("OnMessage"))
              .build();
        }
      }
    }
    return getOnMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatMessageCallServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceStub>() {
        @java.lang.Override
        public CatMessageCallServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatMessageCallServiceStub(channel, callOptions);
        }
      };
    return CatMessageCallServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatMessageCallServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceBlockingStub>() {
        @java.lang.Override
        public CatMessageCallServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatMessageCallServiceBlockingStub(channel, callOptions);
        }
      };
    return CatMessageCallServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CatMessageCallServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatMessageCallServiceFutureStub>() {
        @java.lang.Override
        public CatMessageCallServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatMessageCallServiceFutureStub(channel, callOptions);
        }
      };
    return CatMessageCallServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CatMessageCallServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void onMessage(com.dianping.cat.message.facade.proto.CatMessageRequest request,
        io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.CatMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.dianping.cat.message.facade.proto.CatMessageRequest,
                com.dianping.cat.message.facade.proto.CatMessageResponse>(
                  this, METHODID_ON_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class CatMessageCallServiceStub extends io.grpc.stub.AbstractAsyncStub<CatMessageCallServiceStub> {
    private CatMessageCallServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatMessageCallServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatMessageCallServiceStub(channel, callOptions);
    }

    /**
     */
    public void onMessage(com.dianping.cat.message.facade.proto.CatMessageRequest request,
        io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.CatMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CatMessageCallServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CatMessageCallServiceBlockingStub> {
    private CatMessageCallServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatMessageCallServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatMessageCallServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dianping.cat.message.facade.proto.CatMessageResponse onMessage(com.dianping.cat.message.facade.proto.CatMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CatMessageCallServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CatMessageCallServiceFutureStub> {
    private CatMessageCallServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatMessageCallServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatMessageCallServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dianping.cat.message.facade.proto.CatMessageResponse> onMessage(
        com.dianping.cat.message.facade.proto.CatMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CatMessageCallServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CatMessageCallServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_MESSAGE:
          serviceImpl.onMessage((com.dianping.cat.message.facade.proto.CatMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.CatMessageResponse>) responseObserver);
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

  private static abstract class CatMessageCallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatMessageCallServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dianping.cat.message.facade.proto.MessageFacadeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatMessageCallService");
    }
  }

  private static final class CatMessageCallServiceFileDescriptorSupplier
      extends CatMessageCallServiceBaseDescriptorSupplier {
    CatMessageCallServiceFileDescriptorSupplier() {}
  }

  private static final class CatMessageCallServiceMethodDescriptorSupplier
      extends CatMessageCallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CatMessageCallServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CatMessageCallServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatMessageCallServiceFileDescriptorSupplier())
              .addMethod(getOnMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
