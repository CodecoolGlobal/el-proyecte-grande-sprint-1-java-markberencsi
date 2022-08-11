#RUN useradd --uid 1000 --gid 999 --home /var/lib/postgresql --shell /bin/bash admin
#ENV POSTGRES_USER=admin
#USER admin

FROM postgres:latest
COPY ./src/main/resources/init_db.sql ./docker-entrypoint-initdb.d/init_db.sql
COPY ./src/main/resources/sample_students.sql ./docker-entrypoint-initdb.d/students.sql
ENV POSTGRES_PASSWORD=secret
ENV POSTGRES_DB=harry_pointer
USER postgres