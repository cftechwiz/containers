FROM ghcr.io/cftechwiz/alpine:3.19.6@sha256:18ee0c39afdc94ed876d12104c10d0880eb0b6840d165552e78884ccb3e7576b

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates pigz rclone~"${VERSION}" tar zstd
#hadolint ignore=DL3059
RUN chown -R root:root /usr/bin/rclone \
    && chmod -R 755 /usr/bin/rclone \
    && ln -s /usr/bin/rclone /app/rclone \
    && rm -rf /tmp/*

CMD ["/app/rclone"]

LABEL org.opencontainers.image.source="https://github.com/rclone/rclone"
