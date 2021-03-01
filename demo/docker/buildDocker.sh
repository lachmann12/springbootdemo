cd ..
mvnw clean install
cd docker

chmod 777 ../target/demo-0.0.1-SNAPSHOT.war

docker build -f DockerFile -t lachmann12/springbootdemo .
#docker push lachmann12/springbootdemo
