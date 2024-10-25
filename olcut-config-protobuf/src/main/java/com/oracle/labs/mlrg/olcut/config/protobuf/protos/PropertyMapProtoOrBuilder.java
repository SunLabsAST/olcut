// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olcut_proto.proto

// Protobuf Java Version: 3.25.5
package com.oracle.labs.mlrg.olcut.config.protobuf.protos;

public interface PropertyMapProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:olcut.PropertyMapProto)
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
   * <code>map&lt;string, string&gt; elements = 2;</code>
   */
  int getElementsCount();
  /**
   * <code>map&lt;string, string&gt; elements = 2;</code>
   */
  boolean containsElements(
      java.lang.String key);
  /**
   * Use {@link #getElementsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getElements();
  /**
   * <code>map&lt;string, string&gt; elements = 2;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getElementsMap();
  /**
   * <code>map&lt;string, string&gt; elements = 2;</code>
   */
  /* nullable */
java.lang.String getElementsOrDefault(
      java.lang.String key,
      /* nullable */
java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; elements = 2;</code>
   */
  java.lang.String getElementsOrThrow(
      java.lang.String key);
}
