<<<<<<< HEAD
FROM ghcr.io/cfallwell/ubuntu:jammy-20230126@sha256:cf78514ef78901d2a5b256aa0e4e1008d08d95ef1f23ba398735a24290f092a4 as builder
=======
FROM ghcr.io/cfallwell/ubuntu:jammy-20230126sha256:edeac77eccfe2365701fd101d538100caec2466c93557a8e3d8f7fbef67358bd as builder
>>>>>>> fb57d4b (Fix paths)

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

WORKDIR /tmp

# hadolint ignore=DL3008,DL3015,SC2039,SC2086
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') \
            export ARCH='x86_64'; \
        ;; \
        'linux/arm64') \
            export ARCH='aarch64'; \
        ;; \
    esac \
    && \
    apt-get update -qq \
    && \
    apt-get install -qqy cpio rpm2cpio \
    && \
    mkdir -p /app/emby \
    && \
    curl -fsSL -o emby.rpm \
        "https://github.com/MediaBrowser/Emby.Releases/releases/download/${VERSION}/emby-server-rpm_${VERSION}_${ARCH}.rpm" \
    && \
    rpm2cpio emby.rpm | cpio -i --make-directories \
    && \
    mv -t \
        /app/emby \
        /tmp/opt/emby-server/system/* \
        /tmp/opt/emby-server/lib/* \
        /tmp/opt/emby-server/bin/ff* \
        /tmp/opt/emby-server/etc \
        /tmp/opt/emby-server/extra/lib/*

<<<<<<< HEAD
FROM ghcr.io/cfallwell/ubuntu:jammy-20230126@sha256:cf78514ef78901d2a5b256aa0e4e1008d08d95ef1f23ba398735a24290f092a4
=======
FROM ghcr.io/cfallwell/ubuntu:jammy-20230126sha256:edeac77eccfe2365701fd101d538100caec2466c93557a8e3d8f7fbef67358bd
>>>>>>> fb57d4b (Fix paths)

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL

ENV NVIDIA_DRIVER_CAPABILITIES="compute,video,utility"

USER root

# hadolint ignore=DL3008,DL3015,SC2039,SC2086
RUN \
    case "${TARGETPLATFORM}" in \
        'linux/amd64') \
            export EXTRA_INSTALL_ARG='mesa-va-drivers'; \
        ;; \
        'linux/arm64') \
            curl -s "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x6587ffd6536b8826e88a62547876ae518cbcf2f2" | apt-key add - \
            && echo "deb http://ppa.launchpad.net/ubuntu-raspi2/ppa-nightly/ubuntu focal main">> /etc/apt/sources.list.d/raspbins.list \
            && \
            export EXTRA_INSTALL_ARG='libomxil-bellagio0 libomxil-bellagio-bin libraspberrypi0'; \
            unset NVIDIA_DRIVER_CAPABILITIES; \
        ;; \
    esac \
    && \
    apt-get update -qq && \
    apt-get install -qqy ${EXTRA_INSTALL_ARG} \
    && apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false \
    && apt-get autoremove -y \
    && apt-get clean \
    && \
    rm -rf \
        /tmp/* \
        /var/lib/apt/lists/* \
        /var/tmp/ \
    && chown -R root:root /app \
    && chmod -R 755 /app \
    && printf "umask %d\n" "${UMASK}" >> /etc/bash.bashrc

USER kah
COPY --from=builder /app/emby /app/emby
COPY ./apps/emby/entrypoint.sh /entrypoint.sh
CMD ["/entrypoint.sh"]
