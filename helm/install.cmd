kubectl create namespace k8s-microservice-song-project
kubectl apply -f ./local-path-storage.yml
helm install --namespace k8s-microservice-song-project api-gateway apiGateway
helm install --namespace k8s-microservice-song-project config-server configServer
helm install --namespace k8s-microservice-song-project eureka-server eurekaServer
helm install --namespace k8s-microservice-song-project postgres postgres
helm install --namespace k8s-microservice-song-project resource resource
helm install --namespace k8s-microservice-song-project song song