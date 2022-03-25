#!/bin/bash
echo 'Microservice library infrastructure init on K8S started'  

echo 'Namespcae creation started'

kubectl create ns book
kubectl create ns customer
kubectl create ns borrowing-notification
kubectl create ns logging-monitoring
kubectl create ns vault

echo 'Kafka infrastructure deploy started'

helm repo add bitnami https://charts.bitnami.com/bitnami

( cd ./Kubernetes_Infrastracture_Components ; helm install --values kafka-values.yaml kafka bitnami/kafka -n borrowing-notification )


echo 'Elasticsearch deploy started'

helm repo add elastic https://helm.elastic.co

( cd ./Kubernetes_Infrastracture_Components ; helm install --values elasticsearch-values.yaml elasticsearch elastic/elasticsearch -n logging-monitoring )


echo 'Logstash deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values logstash-values.yaml logstash elastic/logstash -n logging-monitoring )


echo 'Filebeat as Deamonset deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values filebeat-values.yaml filebeat elastic/filebeat -n logging-monitoring )


echo 'Kibana deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values kibana-values.yaml kibana elastic/kibana -n logging-monitoring)


echo 'MongoDb for books service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values mongodb-book-values.yaml book-mongodb bitnami/mongodb -n book)


echo 'MongoDb for borrowing service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values mongodb-borrowing-values.yaml borrowing-mongodb bitnami/mongodb -n borrowing-notification )


echo 'Postgres for customer service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values postgres-customer-values.yaml customer-postgres bitnami/postgresql -n customer)


echo 'Vault deploy started'

helm repo add hashicorp https://helm.releases.hashicorp.com

helm repo update

helm install vault hashicorp/vault --set "server.dev.enabled=true" -n vault

echo 'Deploy terminated...'