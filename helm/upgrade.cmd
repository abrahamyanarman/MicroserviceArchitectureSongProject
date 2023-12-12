
helm upgrade --namespace k8s-microservice-song-project api-gateway apiGateway
helm upgrade --namespace k8s-microservice-song-project config-server configServer
helm upgrade --namespace k8s-microservice-song-project eureka-server eurekaServer
helm upgrade --namespace k8s-microservice-song-project postgres postgres
helm upgrade --namespace k8s-microservice-song-project resource resource
helm upgrade --namespace k8s-microservice-song-project song song