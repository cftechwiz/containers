<<<<<<< HEAD
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:2492f776eaca93effc88a54ee36f6b9e9301c41bf3021dee0681f1d5ad28ce23
=======
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:642fefc9a6d83bbcc28e1aa7f17655b790fe806ad43be2ed4167ce01f57e46fd
>>>>>>> fb57d4b (Fix paths)

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

ENV \
    PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1 \
    PIP_ROOT_USER_ACTION=ignore \
    PIP_NO_CACHE_DIR=1 \
    PIP_DISABLE_PIP_VERSION_CHECK=1 \
    CRYPTOGRAPHY_DONT_BUILD_RUST=1

RUN \
    curl -fsSL -o /tmp/app.zip "https://github.com/morpheus65535/bazarr/releases/download/v${VERSION}/bazarr.zip" \
    && unzip -q /tmp/app.zip -d /app \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf /tmp/*

#hadolint ignore=DL3018,DL3013
RUN \
    apk add --no-cache ca-certificates ffmpeg python3 py3-lxml py3-numpy py3-gevent py3-cryptography py3-setuptools \
    && \
    apk add --no-cache --virtual .build-deps py3-pip gcc python3-dev musl-dev \
    && \
    pip install --upgrade pip \
    && \
    pip install --upgrade \
        gevent-websocket \
        webrtcvad-wheels \
    && apk del --purge .build-deps \
    && rm -rf \
        /root/.cache \
        /root/.cargo \
        /tmp/*

USER kah
COPY ./apps/bazarr/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/morpheus65535/bazarr"
