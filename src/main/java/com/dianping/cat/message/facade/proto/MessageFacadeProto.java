// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_facade.proto

package com.dianping.cat.message.facade.proto;

public final class MessageFacadeProto {
  private MessageFacadeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChannelHealthCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChannelHealthCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChannelHealthCheckResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChannelHealthCheckResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CatMessageData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CatMessageData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CatMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CatMessageRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024message_facade.proto\".\n\031ChannelHealthC" +
      "heckRequest\022\021\n\tclient_ip\030\001 \001(\t\"?\n\032Channe" +
      "lHealthCheckResponse\022\016\n\006enable\030\001 \001(\010\022\021\n\t" +
      "timestamp\030\002 \001(\003\" \n\016CatMessageData\022\016\n\006per" +
      "iod\030\001 \001(\003\"Z\n\021CatMessageRequest\022\016\n\006period" +
      "\030\001 \001(\003\022\"\n\tdata_list\030\002 \003(\0132\017.CatMessageDa" +
      "ta\022\021\n\ttimestamp\030\003 \001(\0032e\n\031ChannelHealthCh" +
      "eckService\022H\n\013HealthCheck\022\032.ChannelHealt" +
      "hCheckRequest\032\033.ChannelHealthCheckRespon" +
      "se\"\000B=\n%com.dianping.cat.message.facade." +
      "protoB\022MessageFacadeProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ChannelHealthCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChannelHealthCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChannelHealthCheckRequest_descriptor,
        new java.lang.String[] { "ClientIp", });
    internal_static_ChannelHealthCheckResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ChannelHealthCheckResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChannelHealthCheckResponse_descriptor,
        new java.lang.String[] { "Enable", "Timestamp", });
    internal_static_CatMessageData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CatMessageData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CatMessageData_descriptor,
        new java.lang.String[] { "Period", });
    internal_static_CatMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_CatMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CatMessageRequest_descriptor,
        new java.lang.String[] { "Period", "DataList", "Timestamp", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
