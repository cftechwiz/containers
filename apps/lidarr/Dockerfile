FROM ghcr.io/cftechwiz/alpine:rolling@sha256:65afc7f60c380125cc0b9ca808f9ab2fecdf99142b7ff385958a2e963e8351a6

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

ENV \
    LIDARR__INSTANCE_NAME="Lidarr" \
    LIDARR__BRANCH="${CHANNEL}" \
    LIDARR__PORT="8686" \
    LIDARR__ANALYTICS_ENABLED="False"

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates chromaprint ffmpeg icu-libs libintl sqlite-libs xmlstarlet
#hadolint ignore=DL3059
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') export ARCH='x64' ;; \
        'linux/arm64') export ARCH='arm64' ;; \
    esac \
    && \
    mkdir -p /app/bin \
    && \
    curl -fsSL "https://lidarr.servarr.com/v1/update/${LIDARR__BRANCH}/updatefile?version=${VERSION}&os=linuxmusl&runtime=netcore&arch=${ARCH}" \
        | tar xzf - -C /app/bin --strip-components=1 \
    && \
    rm -rf \
        /app/bin/Lidarr.Update \
        /app/bin/fpcalc \
    && \
    printf "UpdateMethod=docker\nBranch=%s\nPackageVersion=%s\nPackageAuthor=[cftechwiz](https://github.com/cftechwiz)\n" "${LIDARR__BRANCH}" "${VERSION}" > /app/package_info \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

USER kah

COPY ./apps/lidarr/config.xml.tmpl /app/config.xml.tmpl
COPY ./apps/lidarr/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/Lidarr/Lidarr"
