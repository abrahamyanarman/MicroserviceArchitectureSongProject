helm uninstall --namespace k8s-microservice-song-project config-server
helm uninstall --namespace k8s-microservice-song-project postgres
helm uninstall --namespace k8s-microservice-song-project resource
helm uninstall --namespace k8s-microservice-song-project song
kubectl delete -f ./local-path-storage.yml
