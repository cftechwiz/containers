FROM ghcr.io/cftechwiz/alpine:rolling@sha256:5e4c3d60e12e02aec17ad61f20543438c219e5ddef72a2313ee3a6e820cd9519

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
