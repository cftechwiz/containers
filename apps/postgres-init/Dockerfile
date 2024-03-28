FROM ghcr.io/cftechwiz/alpine:rolling@sha256:3eaee8b2beb9139e09d80bbf5842fa747042bcd67e91100c9dc44e5b367f069f

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
