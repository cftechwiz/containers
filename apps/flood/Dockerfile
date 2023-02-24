FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:4e256e77366cbea00404a0e79831fc902cfb3c1c8d913f45a3fe0293c885acc3

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

ENV FLOOD_OPTION_rundir="/config" \
    FLOOD_OPTION_host="0.0.0.0" \
    FLOOD_OPTION_port="3000"
    # For use with rtorrent
    # FLOOD_OPTION_allowedpath="/config,/sock,/rc"
    # FLOOD_OPTION_rtsocket="/sock/rtorrent.sock"
    # FLOOD_OPTION_rtconfig="/rc/rtorrent.rc"

#hadolint ignore=DL3018
RUN \
    apk add --no-cache ca-certificates \
    && apk add --no-cache --repository http://dl-cdn.alpinelinux.org/alpine/edge/community mediainfo
#hadolint ignore=DL3059
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') export ARCH='x64' ;; \
        'linux/arm64') export ARCH='arm64' ;; \
    esac \
    && \
    curl -fsSL -o /app/flood \
        "https://github.com/jesec/flood/releases/download/v${VERSION}/flood-linux-${ARCH}" \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

USER kah
COPY ./apps/flood/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/jesec/flood"
