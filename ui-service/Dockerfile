FROM node:latest

ENV USR node
ENV SRC /usr/src/ui

VOLUME ${SRC}/dist

RUN npm install gulp -s -g

RUN mkdir -p ${SRC}
WORKDIR ${SRC}

COPY package.json ./
RUN npm install -s

COPY semantic.json ./
COPY semantic ./
RUN npm install semantic-ui@latest \
  && gulp --cwd=semantic build \
  && npm cache clean

COPY . ./
RUN chown -R ${USR}:${USR} ./
USER ${USR}

