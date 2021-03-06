#!/bin/bash
echo 'Microservice library init on K8S started'  


( cd ./book ; kubectl apply -f book-ms.yaml )
( cd ./customer ; kubectl apply -f customer-ms.yaml )
( cd ./borrowing-notification/borrowing ; kubectl apply -f borrowing-ms.yaml )
( cd ./borrowing-notification/notification ; kubectl apply -f notification-ms.yaml )