FROM ghcr.io/cftechwiz/alpine:rolling@sha256:18ee0c39afdc94ed876d12104c10d0880eb0b6840d165552e78884ccb3e7576b

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
