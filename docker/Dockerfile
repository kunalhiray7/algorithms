FROM ubuntu as builder
ARG MACHINE_NAME
ARG IMAGE_DATE
RUN echo "<html><h1>Welcome!!</h1><p>UNAME of the machine: ${MACHINE_NAME}</p><p>Image Creation Date: ${IMAGE_DATE}</p></html>" > index.html

FROM ubuntu
RUN apt-get update
RUN apt-get install nginx -y
RUN mkdir /app
WORKDIR /app
COPY --from=builder index.html /var/www/html/
EXPOSE 80
CMD ["nginx","-g","daemon off;"]
