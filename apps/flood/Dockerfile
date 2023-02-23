<<<<<<< HEAD
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:2492f776eaca93effc88a54ee36f6b9e9301c41bf3021dee0681f1d5ad28ce23
=======
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:642fefc9a6d83bbcc28e1aa7f17655b790fe806ad43be2ed4167ce01f57e46fd
>>>>>>> fb57d4b (Fix paths)

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
