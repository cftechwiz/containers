FROM ghcr.io/cftechwiz/alpine:rolling@sha256:65afc7f60c380125cc0b9ca808f9ab2fecdf99142b7ff385958a2e963e8351a6

ARG TARGETPLATFORM
ARG VERSION
ARG CHANNEL

ENV \
    PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1 \
    PIP_ROOT_USER_ACTION=ignore \
    PIP_NO_CACHE_DIR=1 \
    PIP_DISABLE_PIP_VERSION_CHECK=1 \
    PIP_BREAK_SYSTEM_PACKAGES=1 \
    CRYPTOGRAPHY_DONT_BUILD_RUST=1

ENV TAUTULLI_DOCKER="True"

RUN \
    curl -fsSL "https://github.com/Tautulli/Tautulli/archive/v${VERSION}.tar.gz" | tar xzf - -C /app --strip-components 1 \
    && \
    echo "v${VERSION}" > /app/version.txt \
    && \
    echo "${CHANNEL}" > /app/branch.txt \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

#hadolint ignore=DL3018,DL3013
RUN \
    apk add --no-cache ca-certificates python3 py3-lxml py3-openssl py3-setuptools \
    && \
    apk add --no-cache --virtual .build-deps py3-pip make gcc g++ python3-dev \
    && \
    pip install --upgrade pip \
    && \
    pip install --upgrade \
        plexapi \
        pycryptodomex \
    && apk del --purge .build-deps \
    && rm -rf \
        /root/.cache \
        /root/.cargo \
        /tmp/*

USER kah
COPY ./apps/tautulli/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/Tautulli/Tautulli"
