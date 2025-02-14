FROM ghcr.io/cftechwiz/alpine:rolling@sha256:5e4c3d60e12e02aec17ad61f20543438c219e5ddef72a2313ee3a6e820cd9519 as build
ARG TARGETARCH
ARG VERSION
WORKDIR /tmp
ENV LDFLAGS="-static"
RUN \
    apk add --no-cache \
        autoconf \
        automake \
        build-base \
        curl \
        linux-headers \
        musl-dev \
        bash \
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
CMD ["/usr/local/bin/par2"]
