FROM ghcr.io/cftechwiz/alpine:3.17.7@sha256:2c14ad54c4d7c770f319263f3f7b7e32d2d044e17fed9bf744987f1eb4be2079

ARG TARGETPLATFORM
ARG TARGETARCH
ARG TARGETVARIANT
ARG TARGETOS
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
ARG VERSION
ARG CHANNEL

ENV \
    SONARR__INSTANCE_NAME="Sonarr" \
    SONARR__BRANCH="${CHANNEL}" \
    SONARR__PORT="8989" \
    SONARR__ANALYTICS_ENABLED="False"

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates icu-libs libintl sqlite-libs xmlstarlet
#hadolint ignore=DL3059
RUN \
    case '${TARGETPLATFORM}' in \
        'linux/amd64') 'export BUILD_ARCH=x64' ;; \
        'linux/arm64') 'export BUILD_ARCH=arm64' ;; \
         echo "I'm building for $TARGETPLATFORM" \
         echo "I detect targetarch as $TARGETARCH" \
         echo "I detect targetos as $TARGETOS" \
         echo "I detect targetarch as $TARGETARCH"
         echo "I am resolving BUILD_ARCH as $BUILD_ARCH" \
    esac; \
    echo "I'm building for $TARGETPLATFORM" \
    echo "I am resolving Arch to $BUILD_ARCH" \
    && curl -fsSL "https://github.com/Sonarr/Sonarr/releases/download/${VERSION}/Sonarr.${SONARR__BRANCH}.${VERSION}.linux-musl-${ARCH}.tar.gz" \
        | tar xzf - -C /app --strip-components=1 \
    && \
    rm -rf \
        /app/Sonarr.Update \
    && \
    printf "UpdateMethod=docker\nBranch=%s\nPackageVersion=%s\nPackageAuthor=[cftechwiz](https://github.com/cftechwiz)\n" "${SONARR__BRANCH}" "${VERSION}" > /app/package_info \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

USER kah

COPY ./apps/sonarr/${SONARR__BRANCH}/config.xml.tmpl /app/config.xml.tmpl
COPY ./apps/sonarr/${SONARR__BRANCH}/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.title="${SONARR__INSTANCE_NAME} (${SONARR__BRANCH})"
