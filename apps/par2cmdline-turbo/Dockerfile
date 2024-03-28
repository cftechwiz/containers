# FROM ghcr.io/cftechwiz/alpine:rolling@sha256:3eaee8b2beb9139e09d80bbf5842fa747042bcd67e91100c9dc44e5b367f069f as build
FROM ghcr.io/cftechwiz/ubuntu:jammy-20231004@sha256:71c26a8612dbda5b930622eeb37968c3bbc73324a6ec17110d7e4ed114ae9d83 as build
ARG TARGETARCH
ARG VERSION
WORKDIR /tmp
ENV LDFLAGS="-static"
ENV DOCKER_BUILDKIT=0
RUN \
    apk add --no-cache \
        autoconf \
        automake \
        build-base \
        curl \
        linux-headers \
        musl-dev \
    && \
    curl -fsSL "https://github.com/animetosho/par2cmdline-turbo/archive/refs/tags/v${VERSION}.tar.gz" \
        | tar xzf - -C /tmp --strip-components 1 \
    && ./automake.sh \
    && ./configure \
    && make \
    && make check \
    && make install

FROM scratch
COPY --from=build /usr/local/bin/par2 /usr/local/bin/par2
RUN -it /usr/local/bin/par2 --help
CMD ["/usr/local/bin/par2"]
