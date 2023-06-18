#!/usr/bin/env bash

./gradlew clean bootJar
# `--build` is necessary, else the service image will only be built the first time
docker compose -f docker/docker-compose.yml up --build --pull always
