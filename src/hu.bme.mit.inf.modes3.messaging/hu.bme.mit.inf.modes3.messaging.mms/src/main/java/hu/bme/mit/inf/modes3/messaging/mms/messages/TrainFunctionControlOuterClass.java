// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrainFunctionControl.proto

package hu.bme.mit.inf.modes3.messaging.mms.messages;

public final class TrainFunctionControlOuterClass {
  private TrainFunctionControlOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TrainFunctionControl_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TrainFunctionControl_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032TrainFunctionControl.proto\"W\n\024TrainFun" +
      "ctionControl\022\017\n\007trainID\030\001 \001(\r\022\027\n\017registe" +
      "rAddress\030\002 \001(\r\022\025\n\rregisterValue\030\003 \001(\rB0\n" +
      ",hu.bme.mit.inf.modes3.messaging.mms.mes" +
      "sagesP\001b\006proto3"
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
    internal_static_TrainFunctionControl_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TrainFunctionControl_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TrainFunctionControl_descriptor,
        new java.lang.String[] { "TrainID", "RegisterAddress", "RegisterValue", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}