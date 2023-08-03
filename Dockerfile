# Use the official PostgreSQL image from Docker Hub
FROM postgres:latest

# Set the default environment variables for the PostgreSQL container
ENV POSTGRES_DB=lifecounter_db
ENV POSTGRES_USER=test
ENV POSTGRES_PASSWORD=password

ENV POSTGRES_USER=yourUser
ENV POSTGRES_PW=changeit
ENV POSTGRES_DB=postgres

# Optionally, you can expose the PostgreSQL port if you need to connect externally
EXPOSE 5432