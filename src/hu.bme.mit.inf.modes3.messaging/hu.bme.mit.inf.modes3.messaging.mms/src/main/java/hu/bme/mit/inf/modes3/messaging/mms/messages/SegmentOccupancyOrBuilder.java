// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SegmentOccupancy.proto

package hu.bme.mit.inf.modes3.messaging.mms.messages;

public interface SegmentOccupancyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:SegmentOccupancy)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint32 segmentID = 1;</code>
   */
  int getSegmentID();

  /**
   * <code>optional .SegmentOccupancyValue state = 2;</code>
   */
  int getStateValue();
  /**
   * <code>optional .SegmentOccupancyValue state = 2;</code>
   */
  hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue getState();
}
