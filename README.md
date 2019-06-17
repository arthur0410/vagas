docker pull mongo
docker start mongo
docker run mongo

Get CONTAINER_ID
docker ps -a

Get ip address of container
docker inspect {CONTAINER_ID}

Enter in the container
sudo docker exec -i -t {CONTAINER_ID} bash

Enter in mongo
mongo
create index: db.garage.createIndex({ "location": "2d" })
