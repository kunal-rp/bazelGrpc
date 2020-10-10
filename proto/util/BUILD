package(default_visibility = ["//visibility:public"])

load("@rules_proto//proto:defs.bzl", "proto_library")
load("@rules_java//java:defs.bzl", "java_proto_library")
load("@rules_proto_grpc//java:defs.bzl", "java_grpc_library")


proto_library(
    name = "service_uri_proto",
    srcs = ["service_uri.proto"],
)

java_proto_library(
    name = "service_uri_java_proto",
    deps = [":service_uri_proto"],
)