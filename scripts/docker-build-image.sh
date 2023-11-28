# -ti used to run build process in interactive mode
docker build -ti armanabr/api-gateway:0.0.3 ../api-gateway/
docker build -ti armanabr/config-server:0.0.3 ../config-server/
docker build -ti armanabr/eureka-server:0.0.3 ../eureka-server/
docker build -ti armanabr/resource-service:0.0.4 ../resource-service/
docker build -ti armanabr/song-service:0.0.3 ../song-service/
docker login
docker push armanabr/api-gateway:0.0.3
docker push armanabr/config-server:0.0.3
docker push armanabr/eureka-server:0.0.3
docker push armanabr/resource-service:0.0.4
docker push armanabr/song-service:0.0.3