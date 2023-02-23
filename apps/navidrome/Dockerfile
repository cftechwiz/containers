FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:90fecdee8541cd88de5d51c23dd9778216e5952c0d72bc43c38167f4c4b4def0

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

ENV ND_MUSICFOLDER=/music \
    ND_DATAFOLDER=/config \
    ND_SCANINTERVAL=1m \
    ND_TRANSCODINGCACHESIZE=100MB \
    ND_SESSIONTIMEOUT=30m \
    ND_LOGLEVEL=info \
    ND_PORT=4533

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates ffmpeg
#hadolint ignore=DL3059
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') export ARCH='x86_64' ;; \
        'linux/arm64') export ARCH='arm64' ;; \
    esac \
    && \
    curl -fsSL "https://github.com/navidrome/navidrome/releases/download/v${VERSION}/navidrome_${VERSION}_Linux_${ARCH}.tar.gz" \
        | tar xzf - -C /app \
    && rm /app/LICENSE /app/README.md \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

USER kah
COPY ./apps/navidrome/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/navidrome/navidrome"
