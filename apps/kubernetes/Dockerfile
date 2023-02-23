<<<<<<< HEAD
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:2492f776eaca93effc88a54ee36f6b9e9301c41bf3021dee0681f1d5ad28ce23
=======
FROM ghcr.io/cfallwell/alpine:3.17.2@sha256:642fefc9a6d83bbcc28e1aa7f17655b790fe806ad43be2ed4167ce01f57e46fd
>>>>>>> fb57d4b (Fix paths)

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cfallwell/containers
ARG VERSION
ARG CHANNEL
ARG TARGETARCH
ENV TARGETARCH=${TARGETARCH:-amd64}

#hadolint ignore=DL3018
RUN apk add --no-cache ca-certificates openssl
#hadolint ignore=DL3018,DL3059
RUN \
    curl -fsSL -o /usr/local/bin/kubectl "https://dl.k8s.io/release/v${VERSION}/bin/linux/${TARGETARCH}/kubectl" \
    && chmod +x /usr/local/bin/kubectl

USER kah
CMD [ "/usr/local/bin/kubectl" ]

LABEL org.opencontainers.image.source="https://github.com/kubernetes/kubectl"
