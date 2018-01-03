// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TrainFunctionCommand.proto

#ifndef PROTOBUF_TrainFunctionCommand_2eproto__INCLUDED
#define PROTOBUF_TrainFunctionCommand_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3004000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3004000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/unknown_field_set.h>
#include "Enums.pb.h"
// @@protoc_insertion_point(includes)
namespace modes3 {
namespace protobuf {
class TrainFunctionCommand;
class TrainFunctionCommandDefaultTypeInternal;
extern TrainFunctionCommandDefaultTypeInternal _TrainFunctionCommand_default_instance_;
}  // namespace protobuf
}  // namespace modes3

namespace modes3 {
namespace protobuf {

namespace protobuf_TrainFunctionCommand_2eproto {
// Internal implementation detail -- do not call these.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[];
  static const ::google::protobuf::uint32 offsets[];
  static const ::google::protobuf::internal::FieldMetadata field_metadata[];
  static const ::google::protobuf::internal::SerializationTable serialization_table[];
  static void InitDefaultsImpl();
};
void AddDescriptors();
void InitDefaults();
}  // namespace protobuf_TrainFunctionCommand_2eproto

// ===================================================================

class TrainFunctionCommand : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.TrainFunctionCommand) */ {
 public:
  TrainFunctionCommand();
  virtual ~TrainFunctionCommand();

  TrainFunctionCommand(const TrainFunctionCommand& from);

  inline TrainFunctionCommand& operator=(const TrainFunctionCommand& from) {
    CopyFrom(from);
    return *this;
  }
  #if LANG_CXX11
  TrainFunctionCommand(TrainFunctionCommand&& from) noexcept
    : TrainFunctionCommand() {
    *this = ::std::move(from);
  }

  inline TrainFunctionCommand& operator=(TrainFunctionCommand&& from) noexcept {
    if (GetArenaNoVirtual() == from.GetArenaNoVirtual()) {
      if (this != &from) InternalSwap(&from);
    } else {
      CopyFrom(from);
    }
    return *this;
  }
  #endif
  static const ::google::protobuf::Descriptor* descriptor();
  static const TrainFunctionCommand& default_instance();

  static inline const TrainFunctionCommand* internal_default_instance() {
    return reinterpret_cast<const TrainFunctionCommand*>(
               &_TrainFunctionCommand_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    0;

  void Swap(TrainFunctionCommand* other);
  friend void swap(TrainFunctionCommand& a, TrainFunctionCommand& b) {
    a.Swap(&b);
  }

  // implements Message ----------------------------------------------

  inline TrainFunctionCommand* New() const PROTOBUF_FINAL { return New(NULL); }

  TrainFunctionCommand* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const TrainFunctionCommand& from);
  void MergeFrom(const TrainFunctionCommand& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(TrainFunctionCommand* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // uint32 trainID = 1;
  void clear_trainid();
  static const int kTrainIDFieldNumber = 1;
  ::google::protobuf::uint32 trainid() const;
  void set_trainid(::google::protobuf::uint32 value);

  // uint32 functionID = 2;
  void clear_functionid();
  static const int kFunctionIDFieldNumber = 2;
  ::google::protobuf::uint32 functionid() const;
  void set_functionid(::google::protobuf::uint32 value);

  // .modes3.protobuf.TrainFunctionValue trainFunctionValue = 3;
  void clear_trainfunctionvalue();
  static const int kTrainFunctionValueFieldNumber = 3;
  ::modes3::protobuf::TrainFunctionValue trainfunctionvalue() const;
  void set_trainfunctionvalue(::modes3::protobuf::TrainFunctionValue value);

  // @@protoc_insertion_point(class_scope:modes3.protobuf.TrainFunctionCommand)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::uint32 trainid_;
  ::google::protobuf::uint32 functionid_;
  int trainfunctionvalue_;
  mutable int _cached_size_;
  friend struct protobuf_TrainFunctionCommand_2eproto::TableStruct;
};
// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
// TrainFunctionCommand

// uint32 trainID = 1;
inline void TrainFunctionCommand::clear_trainid() {
  trainid_ = 0u;
}
inline ::google::protobuf::uint32 TrainFunctionCommand::trainid() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.TrainFunctionCommand.trainID)
  return trainid_;
}
inline void TrainFunctionCommand::set_trainid(::google::protobuf::uint32 value) {
  
  trainid_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.TrainFunctionCommand.trainID)
}

// uint32 functionID = 2;
inline void TrainFunctionCommand::clear_functionid() {
  functionid_ = 0u;
}
inline ::google::protobuf::uint32 TrainFunctionCommand::functionid() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.TrainFunctionCommand.functionID)
  return functionid_;
}
inline void TrainFunctionCommand::set_functionid(::google::protobuf::uint32 value) {
  
  functionid_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.TrainFunctionCommand.functionID)
}

// .modes3.protobuf.TrainFunctionValue trainFunctionValue = 3;
inline void TrainFunctionCommand::clear_trainfunctionvalue() {
  trainfunctionvalue_ = 0;
}
inline ::modes3::protobuf::TrainFunctionValue TrainFunctionCommand::trainfunctionvalue() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.TrainFunctionCommand.trainFunctionValue)
  return static_cast< ::modes3::protobuf::TrainFunctionValue >(trainfunctionvalue_);
}
inline void TrainFunctionCommand::set_trainfunctionvalue(::modes3::protobuf::TrainFunctionValue value) {
  
  trainfunctionvalue_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.TrainFunctionCommand.trainFunctionValue)
}

#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)


}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_TrainFunctionCommand_2eproto__INCLUDED
