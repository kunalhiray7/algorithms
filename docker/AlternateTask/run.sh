#!/usr/bin/env bash

echo "Building Docker Image"
docker build . -t static_webpage

echo "Running Docker Container"
docker run -p 80:80 -d static_webpage
