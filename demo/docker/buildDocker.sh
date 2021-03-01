cd..
mvnw clean install
cd docker

docker build -f Dockerfile -t lachmann12/springbootdemo .
#docker push lachmann12/springbootdemo
