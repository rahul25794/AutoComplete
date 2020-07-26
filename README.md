# AutoComplete
A simple country name suggestion component using mysql, spring boot and docker.
## Installation
 Assuming that the mysql is installed on the device (we may use some dedicated service in prod)
 -import the schema from db.sql
 -import data in country table from data.csv

## Run
### build:
 docker build -t app:1.0
### run: 
 docker run -p 7070:7070 app:1.0
