FROM ghcr.io/cftechwiz/alpine:3.19.1@sha256:3eaee8b2beb9139e09d80bbf5842fa747042bcd67e91100c9dc44e5b367f069f

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
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
