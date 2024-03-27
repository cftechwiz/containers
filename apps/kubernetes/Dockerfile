FROM ghcr.io/cftechwiz/alpine:3.17.3@sha256:72b36e852839020d0c2a146f749eba2a66b22fa9a41ddc3d471462fff7c7d79f

ARG TARGETPLATFORM
LABEL org.opencontainers.image.source https://github.com/cftechwiz/containers
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
