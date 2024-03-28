FROM ghcr.io/cftechwiz/alpine:rolling@sha256:3eaee8b2beb9139e09d80bbf5842fa747042bcd67e91100c9dc44e5b367f069f as build
ARG TARGETARCH
ARG VERSION
WORKDIR /tmp
ENV LDFLAGS="-static"
RUN \
    apk update upgrade add --no-cache \
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
