kubectl apply -f ./local-path-storage.yml
helm install --namespace k8s-microservice-song-project config-server configServer
helm install --namespace k8s-microservice-song-project postgres postgres
helm install --namespace k8s-microservice-song-project resource resource
helm install --namespace k8s-microservice-song-project song song