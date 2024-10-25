// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olcut_proto.proto

// Protobuf Java Version: 3.25.5
package com.oracle.labs.mlrg.olcut.config.protobuf.protos;

public interface PropertyListProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:olcut.PropertyListProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated string item = 2;</code>
   * @return A list containing the item.
   */
  java.util.List<java.lang.String>
      getItemList();
  /**
   * <code>repeated string item = 2;</code>
   * @return The count of item.
   */
  int getItemCount();
  /**
   * <code>repeated string item = 2;</code>
   * @param index The index of the element to return.
   * @return The item at the given index.
   */
  java.lang.String getItem(int index);
  /**
   * <code>repeated string item = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the item at the given index.
   */
  com.google.protobuf.ByteString
      getItemBytes(int index);

  /**
   * <code>repeated string type = 3;</code>
   * @return A list containing the type.
   */
  java.util.List<java.lang.String>
      getTypeList();
  /**
   * <code>repeated string type = 3;</code>
   * @return The count of type.
   */
  int getTypeCount();
  /**
   * <code>repeated string type = 3;</code>
   * @param index The index of the element to return.
   * @return The type at the given index.
   */
  java.lang.String getType(int index);
  /**
   * <code>repeated string type = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the type at the given index.
   */
  com.google.protobuf.ByteString
      getTypeBytes(int index);
}
