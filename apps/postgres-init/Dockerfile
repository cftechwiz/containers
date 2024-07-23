FROM ghcr.io/cftechwiz/alpine:rolling@sha256:44f72e9dc33eb2aa711138f0108a43fdea6d9c0472e6a9c84ac01863ddece33a

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
