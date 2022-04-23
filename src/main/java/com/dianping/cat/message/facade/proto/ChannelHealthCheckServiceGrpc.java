package com.dianping.cat.message.facade.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: message_facade.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChannelHealthCheckServiceGrpc {

  private ChannelHealthCheckServiceGrpc() {}

  public static final String SERVICE_NAME = "ChannelHealthCheckService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest,
      com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest.class,
      responseType = com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest,
      com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest, com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = ChannelHealthCheckServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (ChannelHealthCheckServiceGrpc.class) {
        if ((getHealthCheckMethod = ChannelHealthCheckServiceGrpc.getHealthCheckMethod) == null) {
          ChannelHealthCheckServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest, com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChannelHealthCheckServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChannelHealthCheckServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceStub>() {
        @java.lang.Override
        public ChannelHealthCheckServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChannelHealthCheckServiceStub(channel, callOptions);
        }
      };
    return ChannelHealthCheckServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChannelHealthCheckServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceBlockingStub>() {
        @java.lang.Override
        public ChannelHealthCheckServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChannelHealthCheckServiceBlockingStub(channel, callOptions);
        }
      };
    return ChannelHealthCheckServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChannelHealthCheckServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChannelHealthCheckServiceFutureStub>() {
        @java.lang.Override
        public ChannelHealthCheckServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChannelHealthCheckServiceFutureStub(channel, callOptions);
        }
      };
    return ChannelHealthCheckServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChannelHealthCheckServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void healthCheck(com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHealthCheckMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest,
                com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse>(
                  this, METHODID_HEALTH_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class ChannelHealthCheckServiceStub extends io.grpc.stub.AbstractAsyncStub<ChannelHealthCheckServiceStub> {
    private ChannelHealthCheckServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelHealthCheckServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChannelHealthCheckServiceStub(channel, callOptions);
    }

    /**
     */
    public void healthCheck(com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChannelHealthCheckServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChannelHealthCheckServiceBlockingStub> {
    private ChannelHealthCheckServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelHealthCheckServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChannelHealthCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse healthCheck(com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChannelHealthCheckServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChannelHealthCheckServiceFutureStub> {
    private ChannelHealthCheckServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChannelHealthCheckServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChannelHealthCheckServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse> healthCheck(
        com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH_CHECK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChannelHealthCheckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChannelHealthCheckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.dianping.cat.message.facade.proto.ChannelHealthCheckResponse>) responseObserver);
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

  private static abstract class ChannelHealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChannelHealthCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dianping.cat.message.facade.proto.MessageFacadeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChannelHealthCheckService");
    }
  }

  private static final class ChannelHealthCheckServiceFileDescriptorSupplier
      extends ChannelHealthCheckServiceBaseDescriptorSupplier {
    ChannelHealthCheckServiceFileDescriptorSupplier() {}
  }

  private static final class ChannelHealthCheckServiceMethodDescriptorSupplier
      extends ChannelHealthCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChannelHealthCheckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChannelHealthCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChannelHealthCheckServiceFileDescriptorSupplier())
              .addMethod(getHealthCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
