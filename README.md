<!---
NOTE: AUTO-GENERATED FILE
to edit this file, instead edit its template at: ./github/scripts/templates/README.md.j2
-->
<div align="center">


## Containers

_An opinionated collection of container images_

</div>

<div align="center">

![GitHub Repo stars](https://img.shields.io/github/stars/cftechwiz/containers?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/cftechwiz/containers?style=for-the-badge)
![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/cftechwiz/containers/release-scheduled.yaml?style=for-the-badge&label=Scheduled%20Release)

</div>

Welcome to our container images, if looking for a container start by [browsing the GitHub Packages page for this repo's packages](https://github.com/cftechwiz?tab=packages&repo_name=containers).

## Mission statement

The goal of this project is to support [semantically versioned](https://semver.org/), [rootless](https://rootlesscontaine.rs/), and [multiple architecture](https://www.docker.com/blog/multi-arch-build-and-images-the-simple-way/) containers for various applications.

We also try to adhere to a [KISS principle](https://en.wikipedia.org/wiki/KISS_principle), logging to stdout, [one process per container](https://testdriven.io/tips/59de3279-4a2d-4556-9cd0-b444249ed31e/), no [s6-overlay](https://github.com/just-containers/s6-overlay) and all images are built on top of [Alpine](https://hub.docker.com/_/alpine) or [Ubuntu](https://hub.docker.com/_/ubuntu).

## Tag immutability

The containers built here do not use immutable tags, as least not in the more common way you have seen from [linuxserver.io](https://fleet.linuxserver.io/) or [Bitnami](https://bitnami.com/stacks/containers).

We do take a similar approach but instead of appending a `-ls69` or `-r420` prefix to the tag we instead insist on pinning to the sha256 digest of the image, while this is not as pretty it is just as functional in making the images immutable.

| Container                                          | Immutable |
|----------------------------------------------------|-----------|
| `ghcr.io/cftechwiz/sonarr:rolling`                   | ❌         |
| `ghcr.io/cftechwiz/sonarr:3.0.8.1507`                | ❌         |
| `ghcr.io/cftechwiz/sonarr:rolling@sha256:8053...`    | ✅         |
| `ghcr.io/cftechwiz/sonarr:3.0.8.1507@sha256:8053...` | ✅         |

_If pinning an image to the sha256 digest, tools like [Renovate](https://github.com/renovatebot/renovate) support updating the container on a digest or application version change._

## Passing arguments to a application

Some applications do not support defining configuration via environment variables and instead only allow certain config to be set in the command line arguments for the app. To circumvent this, for applications that have an `entrypoint.sh` read below.

1. First read the Kubernetes docs on [defining command and arguments for a Container](https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/).
2. Look up the documentation for the application and find a argument you would like to set.
3. Set the argument in the `args` section, be sure to include `entrypoint.sh` as the first arg and any application specific arguments thereafter.

    ```yaml
    args:
        - /entrypoint.sh
        - --port
        - "8080"
    ```

## Configuration volume

For applications that need to have persistent configuration data the config volume is hardcoded to `/config` inside the container. This is not able to be changed in most cases.

## Available Images

Each Image will be built with a `rolling` tag, along with tags specific to it's version. Available Images Below

Container | Channel | Image | Latest Tags
--- | --- | --- | ---
[actions-runner]() | stable | ghcr.io/cftechwiz/actions-runner |
[bazarr](https://github.com/cftechwiz/containers/pkgs/container/bazarr) | stable | ghcr.io/cftechwiz/bazarr |![1](https://img.shields.io/badge/1-blue?style=flat-square) ![1.4](https://img.shields.io/badge/1.4-blue?style=flat-square) ![1.4.5](https://img.shields.io/badge/1.4.5-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[home-assistant](https://github.com/cftechwiz/containers/pkgs/container/home-assistant) | stable | ghcr.io/cftechwiz/home-assistant |![2024.12.1](https://img.shields.io/badge/2024.12.1-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[jbops](https://github.com/cftechwiz/containers/pkgs/container/jbops) | stable | ghcr.io/cftechwiz/jbops |![1](https://img.shields.io/badge/1-blue?style=flat-square) ![1.0](https://img.shields.io/badge/1.0-blue?style=flat-square) ![1.0.893](https://img.shields.io/badge/1.0.893-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[lidarr](https://github.com/cftechwiz/containers/pkgs/container/lidarr) | master | ghcr.io/cftechwiz/lidarr |![2](https://img.shields.io/badge/2-blue?style=flat-square) ![2.7](https://img.shields.io/badge/2.7-blue?style=flat-square) ![2.7.1](https://img.shields.io/badge/2.7.1-blue?style=flat-square) ![2.7.1.4417](https://img.shields.io/badge/2.7.1.4417-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[lidarr-develop](https://github.com/cftechwiz/containers/pkgs/container/lidarr-develop) | develop | ghcr.io/cftechwiz/lidarr-develop |![2](https://img.shields.io/badge/2-blue?style=flat-square) ![2.8](https://img.shields.io/badge/2.8-blue?style=flat-square) ![2.8.0](https://img.shields.io/badge/2.8.0-blue?style=flat-square) ![2.8.0.4431](https://img.shields.io/badge/2.8.0.4431-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[lidarr-nightly](https://github.com/cftechwiz/containers/pkgs/container/lidarr-nightly) | nightly | ghcr.io/cftechwiz/lidarr-nightly |![2](https://img.shields.io/badge/2-blue?style=flat-square) ![2.8](https://img.shields.io/badge/2.8-blue?style=flat-square) ![2.8.1](https://img.shields.io/badge/2.8.1-blue?style=flat-square) ![2.8.1.4482](https://img.shields.io/badge/2.8.1.4482-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[par2cmdline-turbo]() | stable | ghcr.io/cftechwiz/par2cmdline-turbo |
[plex](https://github.com/cftechwiz/containers/pkgs/container/plex) | stable | ghcr.io/cftechwiz/plex |![1.41.2.9200-c6bbc1b53](https://img.shields.io/badge/1.41.2.9200--c6bbc1b53-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[plex-beta](https://github.com/cftechwiz/containers/pkgs/container/plex-beta) | beta | ghcr.io/cftechwiz/plex-beta |![1.41.3.9276-8f15273fb](https://img.shields.io/badge/1.41.3.9276--8f15273fb-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[postgres-init]() | stable | ghcr.io/cftechwiz/postgres-init |
[prowlarr]() | master | ghcr.io/cftechwiz/prowlarr |
[prowlarr-develop](https://github.com/cftechwiz/containers/pkgs/container/prowlarr-develop) | develop | ghcr.io/cftechwiz/prowlarr-develop |![1](https://img.shields.io/badge/1-blue?style=flat-square) ![1.27](https://img.shields.io/badge/1.27-blue?style=flat-square) ![1.27.0](https://img.shields.io/badge/1.27.0-blue?style=flat-square) ![1.27.0.4852](https://img.shields.io/badge/1.27.0.4852-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[prowlarr-nightly](https://github.com/cftechwiz/containers/pkgs/container/prowlarr-nightly) | nightly | ghcr.io/cftechwiz/prowlarr-nightly |![1](https://img.shields.io/badge/1-blue?style=flat-square) ![1.28](https://img.shields.io/badge/1.28-blue?style=flat-square) ![1.28.0](https://img.shields.io/badge/1.28.0-blue?style=flat-square) ![1.28.0.4862](https://img.shields.io/badge/1.28.0.4862-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[qbittorrent](https://github.com/cftechwiz/containers/pkgs/container/qbittorrent) | stable | ghcr.io/cftechwiz/qbittorrent |![5](https://img.shields.io/badge/5-blue?style=flat-square) ![5.0](https://img.shields.io/badge/5.0-blue?style=flat-square) ![5.0.2](https://img.shields.io/badge/5.0.2-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[qbittorrent-beta](https://github.com/cftechwiz/containers/pkgs/container/qbittorrent-beta) | beta | ghcr.io/cftechwiz/qbittorrent-beta |![5](https://img.shields.io/badge/5-blue?style=flat-square) ![5.0](https://img.shields.io/badge/5.0-blue?style=flat-square) ![5.0.2](https://img.shields.io/badge/5.0.2-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[radarr](https://github.com/cftechwiz/containers/pkgs/container/radarr) | master | ghcr.io/cftechwiz/radarr |![5](https://img.shields.io/badge/5-blue?style=flat-square) ![5.15](https://img.shields.io/badge/5.15-blue?style=flat-square) ![5.15.1](https://img.shields.io/badge/5.15.1-blue?style=flat-square) ![5.15.1.9463](https://img.shields.io/badge/5.15.1.9463-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[radarr-develop](https://github.com/cftechwiz/containers/pkgs/container/radarr-develop) | develop | ghcr.io/cftechwiz/radarr-develop |![5](https://img.shields.io/badge/5-blue?style=flat-square) ![5.16](https://img.shields.io/badge/5.16-blue?style=flat-square) ![5.16.0](https://img.shields.io/badge/5.16.0-blue?style=flat-square) ![5.16.0.9485](https://img.shields.io/badge/5.16.0.9485-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[radarr-nightly](https://github.com/cftechwiz/containers/pkgs/container/radarr-nightly) | nightly | ghcr.io/cftechwiz/radarr-nightly |![5](https://img.shields.io/badge/5-blue?style=flat-square) ![5.16](https://img.shields.io/badge/5.16-blue?style=flat-square) ![5.16.1](https://img.shields.io/badge/5.16.1-blue?style=flat-square) ![5.16.1.9508](https://img.shields.io/badge/5.16.1.9508-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[readarr-develop]() | develop | ghcr.io/cftechwiz/readarr-develop |
[readarr-nightly]() | nightly | ghcr.io/cftechwiz/readarr-nightly |
[sabnzbd](https://github.com/cftechwiz/containers/pkgs/container/sabnzbd) | stable | ghcr.io/cftechwiz/sabnzbd |![4](https://img.shields.io/badge/4-blue?style=flat-square) ![4.3](https://img.shields.io/badge/4.3-blue?style=flat-square) ![4.3.3](https://img.shields.io/badge/4.3.3-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[sonarr](https://github.com/cftechwiz/containers/pkgs/container/sonarr) | main | ghcr.io/cftechwiz/sonarr |![4](https://img.shields.io/badge/4-blue?style=flat-square) ![4.0](https://img.shields.io/badge/4.0-blue?style=flat-square) ![4.0.11](https://img.shields.io/badge/4.0.11-blue?style=flat-square) ![4.0.11.2680](https://img.shields.io/badge/4.0.11.2680-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[sonarr-develop](https://github.com/cftechwiz/containers/pkgs/container/sonarr-develop) | develop | ghcr.io/cftechwiz/sonarr-develop |![4](https://img.shields.io/badge/4-blue?style=flat-square) ![4.0](https://img.shields.io/badge/4.0-blue?style=flat-square) ![4.0.11](https://img.shields.io/badge/4.0.11-blue?style=flat-square) ![4.0.11.2724](https://img.shields.io/badge/4.0.11.2724-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[tautulli](https://github.com/cftechwiz/containers/pkgs/container/tautulli) | master | ghcr.io/cftechwiz/tautulli |![2](https://img.shields.io/badge/2-blue?style=flat-square) ![2.15](https://img.shields.io/badge/2.15-blue?style=flat-square) ![2.15.0](https://img.shields.io/badge/2.15.0-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[theme-park](https://github.com/cftechwiz/containers/pkgs/container/theme-park) | stable | ghcr.io/cftechwiz/theme-park |![1](https://img.shields.io/badge/1-blue?style=flat-square) ![1.19](https://img.shields.io/badge/1.19-blue?style=flat-square) ![1.19.1](https://img.shields.io/badge/1.19.1-blue?style=flat-square) ![rolling](https://img.shields.io/badge/rolling-blue?style=flat-square)
[volsync]() | stable | ghcr.io/cftechwiz/volsync |


## Contributing

1. Install [Docker](https://docs.docker.com/get-docker/), [Taskfile](https://taskfile.dev/) & [Cuelang](https://cuelang.org/)
2. Get familiar with the structure of the repositroy
3. Find a similar application in the apps directory
4. Copy & Paste an application and update the directory name
5. Update `metadata.json`, `Dockerfile`, `ci/latest.sh`, `ci/goss.yaml` and make it suit the application build
6. Include any additional files if required
7. Use Taskfile to build and test your image

    ```ruby
    task APP=sonarr CHANNEL=main test
    ```

### Automated tags

Here's an example of how tags are created in the GitHub workflows, be careful with `metadata.json` as it does affect the outcome of how the tags will be created when the application is built.

| Application | Channel   | Stable  | Base    | Generated Tag               |
|-------------|-----------|---------|---------|-----------------------------|
| `ubuntu`    | `focal`   | `true`  | `true`  | `ubuntu:focal-rolling`      |
| `ubuntu`    | `focal`   | `true`  | `true`  | `ubuntu:focal-19880312`     |
| `alpine`    | `3.16`    | `true`  | `true`  | `alpine:rolling`            |
| `alpine`    | `3.16`    | `true`  | `true`  | `alpine:3.16.0`             |
| `sonarr`    | `develop` | `false` | `false` | `sonarr-develop:3.0.8.1538` |
| `sonarr`    | `develop` | `false` | `false` | `sonarr-develop:rolling`    |
| `sonarr`    | `main`    | `true`  | `false` | `sonarr:3.0.8.1507`         |
| `sonarr`    | `main`    | `true`  | `false` | `sonarr:rolling`            |

## Deprecations

Containers here can be **deprecated** at any point, this could be for any reason described below.

1. The upstream application is **no longer actively developed**
2. The upstream application has an **official upstream container** that follows closely to the mission statement described here
3. The upstream application has been **replaced with a better alternative**
4. The **maintenance burden** of keeping the container here **is too bothersome**

**Note**: Deprecated containers will remained published to this repo for 6 months after which they will be pruned.
## Credits

A lot of inspiration and ideas are thanks to the hard work of [hotio.dev](https://hotio.dev/) and [linuxserver.io](https://www.linuxserver.io/) contributors.

    