# Products App
- React.js FE with Springboot Java BE
- Assumes MacOS (Linux Equivalent)

## Server: Compile, Test, Package, Run
- [pom.xml](pom.xml)
```
./mvnw clean install
./mvnw compile
./mvnw test
./mvnw package
./mvnw spring-boot:run
```

## Frontend: Install, Test, Run
 - [package.json](frontend/package.json)
```
cd frontend
pnpm install
pnpm test
pnpm dev
```

## Getting Started with Postgres
1. Install a postgres database
```
brew install postgresql
brew services start postgresql
psql -U <username> -w <database>
# example: psql -U <username> -w postgres
```
- for macos if you don't setup a user its just your macos user name without password
```
psql postgres
> CREATE DATABASE <databasename>;
# example: CREATE DATABASE estore;
> \c estore
```
- Create a Products table and add a few products
    - Future: implement something like flyway to handle migrations
- [001_create_products_table.sql](db/migrations/001_create_products_table.sql)


### Other
- Lombok is a bit testy and you might need to make a change in the Entity or DTO file before it re runs 
- The React proxy can get confused and you need to delete the node_modules and install and run