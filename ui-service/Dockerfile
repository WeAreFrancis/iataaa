FROM node:latest

ENV USR node
ENV SRC /usr/src/ui

VOLUME ${SRC}/dist

RUN mkdir -p ${SRC}
WORKDIR ${SRC}

COPY package.json ./
RUN npm install -s

COPY . ./
RUN chown -R ${USR}:${USR} ./
USER ${USR}

