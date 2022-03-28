# MicroService_Library
A library management system based on boot-spring, REST, GraphQl and runned on k8s

The complete architecture of the project:
![image](https://user-images.githubusercontent.com/78237734/146746287-fcaf26cd-1752-44d3-bf77-2bb9845aaafe.png)

An hypothetical front end structure based on this application:
![image](https://user-images.githubusercontent.com/78237734/146746862-617ab8c1-f43a-4477-ac42-23007385db86.png)


Instruction to set up the enviroment 

Start Minikube: minikube start

1) Execute the init infrastructure script. It will install all the needed components on k8s
2) Execute the init services script. It will start the services on k8s

#Vault Configuration#
To make vault successfully inject our secrets inside a microservice pod, some configuration is needed

Let's use the book microservice as an example.

The database credential secret will be injected inside the application through the vault sidecar injector

STEP

1)Enter inside the vault pod

```console
kubectl exec -it vault-0 -n vault -- /bin/sh
```

2)Create the secret that you want to inject

```console
vault kv put internal/database/config username="root" password="root"
```
3)Verify the correct creation of the secret

```console
vault kv put internal/database/config username="root" password="root"
```

4)Enable the Kubernetes authentication method

```console
vault auth enable kubernetes
```

5)Configure the Kubernetes authentication method to use the location of the Kubernetes API, the service account token, its certificate, and the name of Kubernetes' service account issuer (required with Kubernetes 1.21+)

```console
vault write auth/kubernetes/config \
    kubernetes_host="https://$KUBERNETES_PORT_443_TCP_ADDR:443" \
    token_reviewer_jwt="$(cat /var/run/secrets/kubernetes.io/serviceaccount/token)" \
    kubernetes_ca_cert=@/var/run/secrets/kubernetes.io/serviceaccount/ca.crt \
    issuer="https://kubernetes.default.svc.cluster.local"
```

6)Create the policy

```console
vault policy write internal-app - <<EOF
path "internal/data/database/config" {
  capabilities = ["read"]
}
EOF
```

7)Create a Kubernetes authentication role named internal-app.

```console
vault write auth/kubernetes/role/internal-app \
    bound_service_account_names=internal-app \
    bound_service_account_namespaces=book \
    policies=internal-app \
    ttl=24h
```

8)Exit the vault pod

```console
exit
```

9)Create the application's service account

```console
kubectl create sa internal-app -n book
```

The vault configuration is complete!



