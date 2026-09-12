FROM mcr.microsoft.com/devcontainers/base:ubuntu-22.04

ARG ANDROID_CMDLINE_TOOLS_VERSION=11076708
ARG ANDROID_PLATFORM=34
ARG ANDROID_BUILD_TOOLS=34.0.0
ARG GRADLE_VERSION=8.0.2

ENV DEBIAN_FRONTEND=noninteractive \
    ANDROID_HOME=/opt/android-sdk \
    ANDROID_SDK_ROOT=/opt/android-sdk \
    GRADLE_HOME=/opt/gradle/gradle-${GRADLE_VERSION} \
    PATH=/opt/android-sdk/cmdline-tools/latest/bin:/opt/android-sdk/platform-tools:/opt/gradle/gradle-${GRADLE_VERSION}/bin:${PATH}

RUN apt-get update \
    && apt-get install --yes --no-install-recommends \
        ca-certificates \
        git \
        openjdk-17-jdk \
        unzip \
        wget \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir -p "${ANDROID_HOME}/cmdline-tools" /opt/gradle \
    && wget --quiet \
        "https://dl.google.com/android/repository/commandlinetools-linux-${ANDROID_CMDLINE_TOOLS_VERSION}_latest.zip" \
        -O /tmp/android-command-line-tools.zip \
    && unzip -q /tmp/android-command-line-tools.zip -d /tmp/android-command-line-tools \
    && mv /tmp/android-command-line-tools/cmdline-tools "${ANDROID_HOME}/cmdline-tools/latest" \
    && wget --quiet \
        "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
        -O /tmp/gradle.zip \
    && unzip -q /tmp/gradle.zip -d /opt/gradle \
    && rm -rf /tmp/android-command-line-tools /tmp/android-command-line-tools.zip /tmp/gradle.zip \
    && yes | sdkmanager --licenses >/dev/null 2>&1

RUN sdkmanager \
        "platform-tools" \
        "platforms;android-${ANDROID_PLATFORM}" \
        "build-tools;${ANDROID_BUILD_TOOLS}" \
    && chmod -R a+rX "${ANDROID_HOME}" /opt/gradle

USER vscode

