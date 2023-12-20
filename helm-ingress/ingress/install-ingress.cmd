kubectl create namespace k8s-microservice-song-project
helm upgrade --install ingress-nginx ingress-nginx --repo https://kubernetes.github.io/ingress-nginx --namespace k8s-microservice-song-project --set controller.replicaCount=2
kubectl apply -f ./ingress/ingress.yml