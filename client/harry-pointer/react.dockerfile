FROM node:18-alpine
WORKDIR /harry
COPY package.json package.json
COPY package-lock.json package-lock.json

RUN npm install --silent

COPY . .
EXPOSE 3000

ENTRYPOINT ["npm", "start"]