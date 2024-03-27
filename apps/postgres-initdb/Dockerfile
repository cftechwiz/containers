FROM ghcr.io/cftechwiz/alpine:rolling@sha256:e6547db8e9fcd506d930729d15c06aefdbac83759cd41967d35e0484ef96f3a2

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
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
