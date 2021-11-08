# fullStackLearning
This app will use the functional coding style for Backend and frontend .

## **Tech used in this**

> ### Backend
> - **Maven**
> - **Kotlin**
> - **Arrow**
> - **SpringBoot**

> ### DataBase
> - **PostgresSql**

> ### Frontend
> - **Yarn**
> - **React**
> - **Typescript**

## How to run the backend ?
> Build the app - `maven clean install`
>
> Run the app - Run `MainApplication.kt`
>
> Run as maven `mvn spring-boot:run`


## How to run the frontend ?
> Got to frontend folder `cd frontend`
>
> Run `yarn install`
>
> Start react app `yarn start`
> 
> Run the test(s) `yarn run test`
>  
> Build the app `yarn build`

## Useful urls
- Backend Url: http://localhost:3333/
- React Url: http://localhost:3000/


> ## Database
> Install postgres using [brew](https://brew.sh/) 
> `brew install postgresql`
> 
> Start postgres `brew services start postgresql`
> 
> Stop postgres `brew services stop postgresql`
> 
> Login to postgres `psql postgres`
> 
> Create user for our app `CREATE ROLE fullStackDeveloper WITH LOGIN PASSWORD '<password from properties>';`
> 
> Add createDb role `ALTER ROLE fullStackDeveloper CREATEDB`
> 
> Login using created role `psql postgres -U fullstackdeveloper`
> 