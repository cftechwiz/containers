FROM ghcr.io/cftechwiz/alpine:3.19.1

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
ARG VERSION
ARG CHANNEL
ARG TARGETARCH
ENV TARGETARCH=${TARGETARCH:-amd64}

ENV RTORRENT__DEFAULT_CONFIG="true" \
    RTORRENT__CONFIG_FILE="/config/rtorrent.rc" \
    RTORRENT__SOCKET="/sock/rtorrent.sock" \
    RTORRENT__BT_PORT="50415"

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates
#hadolint ignore=DL3059
RUN curl -fsSL -o /app/rtorrent \
        "https://github.com/jesec/rtorrent/releases/download/v${VERSION}/rtorrent-linux-${TARGETARCH}" \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && mkdir -p "$(dirname "${RTORRENT__SOCKET}")" \
    && chown -R kah:kah "$(dirname "${RTORRENT__SOCKET}")" \
    && chmod -R 775 "$(dirname "${RTORRENT__SOCKET}")" \
    && rm -rf /tmp/*

USER kah
COPY ./apps/rtorrent/rtorrent.rc /app/rtorrent.rc
COPY ./apps/rtorrent/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/jesec/rtorrent"
