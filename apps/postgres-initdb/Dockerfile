FROM ghcr.io/cfallwell/alpine:rolling@sha256:c44e5947041c28d862dddcee3129114de08ed74bdb3771a86304b4aa6e712b97

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
