FROM ghcr.io/cftechwiz/alpine:rolling@sha256:65afc7f60c380125cc0b9ca808f9ab2fecdf99142b7ff385958a2e963e8351a6

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates postgresql16-client~"${VERSION}"

USER kah

COPY ./apps/postgres-init/entrypoint.sh /entrypoint.sh

CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/postgres/postgres"
