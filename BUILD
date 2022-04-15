load(
  "@bazel_tools//tools/jdk:default_java_toolchain.bzl",
  "default_java_toolchain", "DEFAULT_TOOLCHAIN_CONFIGURATION", "BASE_JDK9_JVM_OPTS", "DEFAULT_JAVACOPTS"
)
load("@rules_antlr//antlr:antlr4.bzl", "antlr")

default_java_toolchain(
  name = "repository_default_toolchain",
  configuration = DEFAULT_TOOLCHAIN_CONFIGURATION,
  java_runtime = "@bazel_tools//tools/jdk:remotejdk_17",
  jvm_opts = BASE_JDK9_JVM_OPTS + ["--enable-preview"],
  javacopts = DEFAULT_JAVACOPTS + ["--enable-preview"],
  source_version = "17",
  target_version = "17",
)

antlr(
    name = "example_antlr",
    srcs = ["Example.g4"],
    package = "example",
    visitor = True,
)
