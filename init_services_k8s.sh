#!/bin/bash
echo 'Microservice library init on K8S started'  


( cd ./book ; kubectl apply -f book-ms.yaml -n book )
( cd ./customer ; kubectl apply -f customer-ms.yaml -n customer )
( cd ./borrowing-notification/borrowing ; kubectl apply -f borrowing-ms.yaml -n borrowing-notification )
( cd ./borrowing-notification/notification ; kubectl apply -f notification-ms.yaml -n borrowing-notification )