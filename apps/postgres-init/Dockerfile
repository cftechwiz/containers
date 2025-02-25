FROM ghcr.io/cftechwiz/alpine:rolling@sha256:c7f75f888d5c49d66b2aca05b42e596268e2bdb434bb40653d88c9f8322adf09

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
