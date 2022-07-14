#!/usr/bin/env bash

echo "Building Docker Image"
docker build --build-arg "MACHINE_NAME=$(uname -a)" --build-arg "IMAGE_DATE=$(date)" . -t static_webpage

echo "Running Docker Container"
docker run -p 80:80 -d static_webpage
