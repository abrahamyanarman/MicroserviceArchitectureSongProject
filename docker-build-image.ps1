# -ti used to run build process in interactive mode
docker build -t armanabr/api-gateway:0.0.2 ./api-gateway/
docker build -t armanabr/config-server:0.0.2 ./config-server/
docker build -t armanabr/eureka-server:0.0.2 ./eureka-server/
docker build -t armanabr/resource-service:0.0.3 ./resource-service/
docker build -t armanabr/song-service:0.0.2 ./song-service/
docker login
docker push armanabr/api-gateway:0.0.2
docker push armanabr/config-server:0.0.2
docker push armanabr/eureka-server:0.0.2
docker push armanabr/resource-service:0.0.3
docker push armanabr/song-service:0.0.2