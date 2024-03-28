FROM ghcr.io/cftechwiz/alpine:rolling@sha256:b6206e3f8bc7dec38e3d2e8503fcc439425b56a34584e26f97a5da6faf093b76

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

ENV \
    PROWLARR__INSTANCE_NAME="Prowlarr" \
    PROWLARR__BRANCH="${CHANNEL}" \
    PROWLARR__PORT="9696" \
    PROWLARR__ANALYTICS_ENABLED="False"

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates icu-libs libintl sqlite-libs xmlstarlet
#hadolint ignore=DL3059
RUN \
    case "${TARGETPLATFORM}" in \
    'linux/amd64') export ARCH='x64' ;; \
    'linux/arm64') export ARCH='arm64' ;; \
    esac \
    && \
    mkdir -p /app/bin \
    && \
    curl -fsSL "https://prowlarr.servarr.com/v1/update/${PROWLARR__BRANCH}/updatefile?version=${VERSION}&os=linuxmusl&runtime=netcore&arch=${ARCH}" \
    | tar xzf - -C /app/bin --strip-components=1 \
    && \
    rm -rf \
    /app/bin/Prowlarr.Update \
    && \
    printf "UpdateMethod=docker\nBranch=%s\nPackageVersion=%s\nPackageAuthor=[cftechwiz](https://github.com/cftechwiz)\n" "${PROWLARR__BRANCH}" "${VERSION}" > /app/package_info \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

USER kah
COPY ./apps/prowlarr/config.xml.tmpl /app/config.xml.tmpl
COPY ./apps/prowlarr/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/Prowlarr/Prowlarr"
