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

java_library(
    name = "guava",
    exports = ["@maven//:com_google_guava_guava"],
)

java_library(
    name = "repro",
    srcs = ["Repro.java"],
    deps = [":guava"],
)

# Having a library depend on another library that leverages Java 17 language features
# causes a compiler failure when .bazelrc has:
# build --java_language_version=17
# build --java_runtime_version=remotejdk_17
# 
# Repro.java:1: error: could not locate class file for java.lang.Record
# public record Repro(int value) {
#
# Attempting to add "build --tool_java_runtime_version=remotejdk_17" to .bazelrc
# causes an exception within ErrorProne coming from the rules_antlr library. :(
java_library(
    name = "other",
    srcs = ["Other.java"],
    deps = [":repro"],
)

antlr(
    name = "example_antlr",
    srcs = ["Example.g4"],
    package = "example",
    visitor = True,
)
