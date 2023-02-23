FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:2492f776eaca93effc88a54ee36f6b9e9301c41bf3021dee0681f1d5ad28ce23

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
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
