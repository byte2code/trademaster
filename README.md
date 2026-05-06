# TradeMaster

Spring Boot application for recording stock trades, retrieving trade history, and tracking API usage with Micrometer metrics.

## Features

- Execute buy and sell trades
- Persist trade records with JPA and MySQL
- Query trade history by username
- Expose Actuator and Prometheus metrics
- Track trade-history access count through a custom counter

## API

- `POST /tradeMasterApp/execute-trade`
- `GET /tradeMasterApp/tradeHistory/{username}`

## Stack

- Java 17
- Spring Boot 3.0.0
- Spring Data JPA
- MySQL
- Lombok
- Micrometer Prometheus registry
