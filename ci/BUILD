package(default_visibility = ["//visibility:public"])

load("@build_bazel_rules_nodejs//:index.bzl", "nodejs_binary")

nodejs_binary(
    name = "alter_service_config",
    entry_point = "alter_service_config.js",
    data = [
        ":service_configs.bzl"
    ]
)