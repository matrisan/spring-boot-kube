FROM ubuntu:focal
COPY ding* /apprun/
WORKDIR /apprun
ENTRYPOINT ["./ding","-config=./ding.cfg","-subdomain=ssd-minio-api","9000"]

