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

ENV PLEXAPI_CONFIG_PATH="/config/config.ini" \
    JBOPS__SCRIPT_PATH="fun/plexapi_haiku.py"

#hadolint ignore=DL3018,DL3013
RUN apk add --no-cache \
        ca-certificates \
        python3 \
    && \
    apk add --no-cache --virtual=.build-deps \
        build-base \
        libffi-dev \
        openssl-dev \
        musl-dev \
        python3-dev \
        py3-pip \
        git \
    && \
    pip install --upgrade pip \
    && git clone https://github.com/blacktwin/JBOPS.git . \
    && if [ -n "${VERSION}" ]; then \
        NUMBER_COMMITS_TO_REVERT=$(( $(git rev-list --count --first-parent HEAD) - $(echo "${VERSION}" | cut -d "." -f3) )); \
        git checkout "master~${NUMBER_COMMITS_TO_REVERT}"; \
    fi \
    && \
    pip install --upgrade --requirement /app/requirements.txt \
    && apk del --purge .build-deps \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && rm -rf \
        /root/.cache \
        /root/.cargo \
        /tmp/*

USER kah
COPY ./apps/jbops/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]

LABEL org.opencontainers.image.source="https://github.com/blacktwin/JBOPS"
