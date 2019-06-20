# Tips

### Docker commands
```
systemctl start docker
docker pull mongo
```

Create new container:
```
docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no mongo
```

Get CONTAINER_ID
```
docker ps -a
```

Start a container
```
docker start {CONTAINER_ID}
```

Get ip address of container
```
docker inspect {CONTAINER_ID}
```

Enter in the container
```
sudo docker exec -i -t {CONTAINER_ID} bash
```

### Mongo commands
```
mongo
show dbs;
use {db_name};
show collections;
```
Show all lines
```
db.{collection_name}.find()
```
Remove all lines
```
db.{collection_name}.remove({})
```
Create index to find by location
```
create index: db.garage.createIndex({ "location": "2d" })
```
Find location
```
db.garage.find( { location: { $geoWithin: { $centerSphere: [ [0, 0], 1000 ]}}})
```
