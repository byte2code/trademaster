# TradeMaster

Spring Boot application for recording stock trades and retrieving trade history for a user.

## Features

- Execute buy and sell trades
- Persist trade records with JPA and MySQL
- Query trade history by username
- Emit application logs to a dedicated debug file

## API

- `POST /tradeMasterApp/execute-trade`
- `GET /tradeMasterApp/tradeHistory/{username}`

## Stack

- Java 17
- Spring Boot 3.0.0
- Spring Data JPA
- MySQL
- Lombok
