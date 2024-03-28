FROM ghcr.io/cftechwiz/ubuntu:jammy-20230126@sha256:52a6dd1ffd7942a96ec548a83c44063c586d46ba8e79d838931fa43909014be1

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
ARG VERSION
ARG CHANNEL

ENV \
    SONARR__INSTANCE_NAME="Sonarr" \
    SONARR__BRANCH="${CHANNEL}" \
    SONARR__PORT="8989" \
    SONARR__ANALYTICS_ENABLED="False"

# hadolint ignore=DL3008,DL3015,SC2086
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') export ARCH='x64' ;; \
        'linux/arm64') export ARCH='arm64' ;; \
    esac \
    && \
    apt-get -qq update \
    && apt-get -qq install -y gnupg \
    && \
    apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 3FA7E0328081BFF6A14DA29AA6A19B38D3D831EF \
    && echo "deb https://download.mono-project.com/repo/ubuntu stable-focal main" | tee /etc/apt/sources.list.d/mono-official.list \
    && apt-get -qq update \
    && \
    apt-get -qq install -y \
        ca-certificates \
        mono-complete \
        ca-certificates-mono \
        libmediainfo0v5 \
        xmlstarlet \
    && \
    curl -fsSL "https://services.sonarr.tv/v1/download/main/${SONARR__BRANCH}?version=${VERSION}&os=linux&arch=${ARCH}" \
        | tar xzf - -C /app --strip-components=1 \
    && \
    printf "UpdateMethod=docker\nBranch=%s\nPackageVersion=%s\nPackageAuthor=[cftechwiz](https://github.com/cftechwiz)\n" "${SONARR__BRANCH}" "${VERSION}" > /app/package_info \
    && \
    gpgconf --kill all \
    && apt-get remove -y gnupg \
    && apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false \
    && apt-get autoremove -y \
    && apt-get clean \
    && \
    rm -rf \
        /app/Sonarr.Update \
        /tmp/* \
        /var/lib/apt/lists/* \
        /var/tmp/ \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && printf "umask %d\n" "${UMASK}" >> /etc/bash.bashrc

USER kah

COPY ./apps/sonarr/config.xml.tmpl /app/config.xml.tmpl
COPY ./apps/sonarr/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/Sonarr/Sonarr"
