kubectl delete -f ./ingress/ingress.yml
helm uninstall --namespace k8s-microservice-song-project ingress-nginx