// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olcut_proto.proto

// Protobuf Java Version: 3.25.5
package com.oracle.labs.mlrg.olcut.config.protobuf.protos;

public interface ComponentProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:olcut.ComponentProto)
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
   * <code>optional string type = 2;</code>
   * @return Whether the type field is set.
   */
  boolean hasType();
  /**
   * <code>optional string type = 2;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <code>optional string type = 2;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  int getPropertiesCount();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  boolean containsProperties(
      java.lang.String key);
  /**
   * Use {@link #getPropertiesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getProperties();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getPropertiesMap();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  /* nullable */
java.lang.String getPropertiesOrDefault(
      java.lang.String key,
      /* nullable */
java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  java.lang.String getPropertiesOrThrow(
      java.lang.String key);

  /**
   * <code>repeated .olcut.PropertyListProto list_property = 4;</code>
   */
  java.util.List<com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyListProto> 
      getListPropertyList();
  /**
   * <code>repeated .olcut.PropertyListProto list_property = 4;</code>
   */
  com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyListProto getListProperty(int index);
  /**
   * <code>repeated .olcut.PropertyListProto list_property = 4;</code>
   */
  int getListPropertyCount();
  /**
   * <code>repeated .olcut.PropertyListProto list_property = 4;</code>
   */
  java.util.List<? extends com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyListProtoOrBuilder> 
      getListPropertyOrBuilderList();
  /**
   * <code>repeated .olcut.PropertyListProto list_property = 4;</code>
   */
  com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyListProtoOrBuilder getListPropertyOrBuilder(
      int index);

  /**
   * <code>repeated .olcut.PropertyMapProto map_property = 5;</code>
   */
  java.util.List<com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyMapProto> 
      getMapPropertyList();
  /**
   * <code>repeated .olcut.PropertyMapProto map_property = 5;</code>
   */
  com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyMapProto getMapProperty(int index);
  /**
   * <code>repeated .olcut.PropertyMapProto map_property = 5;</code>
   */
  int getMapPropertyCount();
  /**
   * <code>repeated .olcut.PropertyMapProto map_property = 5;</code>
   */
  java.util.List<? extends com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyMapProtoOrBuilder> 
      getMapPropertyOrBuilderList();
  /**
   * <code>repeated .olcut.PropertyMapProto map_property = 5;</code>
   */
  com.oracle.labs.mlrg.olcut.config.protobuf.protos.PropertyMapProtoOrBuilder getMapPropertyOrBuilder(
      int index);

  /**
   * <code>optional string override = 6;</code>
   * @return Whether the override field is set.
   */
  boolean hasOverride();
  /**
   * <code>optional string override = 6;</code>
   * @return The override.
   */
  java.lang.String getOverride();
  /**
   * <code>optional string override = 6;</code>
   * @return The bytes for override.
   */
  com.google.protobuf.ByteString
      getOverrideBytes();

  /**
   * <code>optional bool exportable = 7;</code>
   * @return Whether the exportable field is set.
   */
  boolean hasExportable();
  /**
   * <code>optional bool exportable = 7;</code>
   * @return The exportable.
   */
  boolean getExportable();

  /**
   * <code>optional bool importable = 8;</code>
   * @return Whether the importable field is set.
   */
  boolean hasImportable();
  /**
   * <code>optional bool importable = 8;</code>
   * @return The importable.
   */
  boolean getImportable();

  /**
   * <code>optional int64 leaseTime = 9;</code>
   * @return Whether the leaseTime field is set.
   */
  boolean hasLeaseTime();
  /**
   * <code>optional int64 leaseTime = 9;</code>
   * @return The leaseTime.
   */
  long getLeaseTime();

  /**
   * <code>optional string serialized = 10;</code>
   * @return Whether the serialized field is set.
   */
  boolean hasSerialized();
  /**
   * <code>optional string serialized = 10;</code>
   * @return The serialized.
   */
  java.lang.String getSerialized();
  /**
   * <code>optional string serialized = 10;</code>
   * @return The bytes for serialized.
   */
  com.google.protobuf.ByteString
      getSerializedBytes();

  /**
   * <code>optional string entries = 11;</code>
   * @return Whether the entries field is set.
   */
  boolean hasEntries();
  /**
   * <code>optional string entries = 11;</code>
   * @return The entries.
   */
  java.lang.String getEntries();
  /**
   * <code>optional string entries = 11;</code>
   * @return The bytes for entries.
   */
  com.google.protobuf.ByteString
      getEntriesBytes();
}
