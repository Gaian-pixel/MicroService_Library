#!/bin/bash
echo 'Microservice library infrastructure init on K8S started'  

echo 'Kafka infrastructure deploy started'

helm repo add bitnami https://charts.bitnami.com/bitnami

( cd ./Kubernetes_Infrastracture_Components ; helm install --values kafka-values.yaml kafka bitnami/kafka )

echo 'Kafka infrastructure deploy check --It may take a while--'

kubectl get pods 

echo 'Elasticsearch deploy started'

helm repo add elastic https://helm.elastic.co

( cd ./Kubernetes_Infrastracture_Components ; helm install --values elasticsearch-values.yaml elasticsearch elastic/elasticsearch )

echo 'Elasticsearch deploy check --It may take a while--'

kubectl get pods --namespace=default -l app=elasticsearch-master 

echo 'Logstash deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values logstash-values.yaml logstash elastic/logstash )

echo 'Logstash deploy check --It may take a while--'

kubectl get pods --namespace=default -l app=logstash-logstash

echo 'Filebeat as Deamonset deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values filebeat-values.yaml filebeat elastic/filebeat )

echo 'Filebeat deploy check --It may take a while--'

kubectl get pods --namespace=default -l app=filebeat

echo 'Kibana deploy started'

( cd ./Kubernetes_Infrastracture_Components ; helm install --values kibana-values.yaml kibana elastic/kibana )

echo 'Kibana deploy check --It may take a while--'

kubectl get pods --namespace=default -l app=kibana

echo 'MongoDb for books service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values mongodb-book-values.yaml book-mongodb bitnami/mongodb )

echo 'MongoDB for books service deploy check --It may take a while--'

kubectl get pods | grep mongo

echo 'MongoDb for borrowing service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values mongodb-borrowing-values.yaml borrowing-mongodb bitnami/mongodb )

echo 'MongoDB for borrowing service deploy check --It may take a while--'

kubectl get pods | grep mongo


echo 'Postgres for customer service deploy started'

( cd ./Kubernetes_Db_Creation ; helm install --values postgres-customer-values.yaml customer-postgres bitnami/postgresql )

echo 'Postgres for customer service deploy check --It may take a while--'

kubectl get pods | grep postgres

echo 'Deploy terminated...'