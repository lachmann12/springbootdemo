cd ..
chmod 777 mvnw
mvnw clean install
cd docker

cp ../target/demo-0.0.1-SNAPSHOT.war demo.war

docker build -f DockerFile -t lachmann12/springbootdemo .
#docker push lachmann12/springbootdemo
