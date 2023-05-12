FROM ghcr.io/cfallwell/alpine:rolling@sha256:b7eba74c519b3320d12b72981b94b43d620630e9ec31c6cbb0865d27bb01ffcc

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

ENV POSTGRES_SUPER_USER="postgres" \
    POSTGRES_RESET="false" \
    POSTGRES_USER_RESET="false" \
    POSTGRES_RESET_CONFIRM="NO"

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql14-client~"${VERSION}"

USER kah

COPY ./apps/postgres-initdb/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
