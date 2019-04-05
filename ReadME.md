System Variables before Start the stack:
SET DOCKER_HOST_IP=127.0.0.1

Full stack

Single Zookeeper: $DOCKER_HOST_IP:2181

Single Kafka: $DOCKER_HOST_IP:9092

Kafka Schema Registry: $DOCKER_HOST_IP:8081

Kafka Schema Registry UI: $DOCKER_HOST_IP:8001

Kafka Rest Proxy: $DOCKER_HOST_IP:8082

Kafka Topics UI: $DOCKER_HOST_IP:8000

Kafka Connect: $DOCKER_HOST_IP:8083

Kafka Connect UI: $DOCKER_HOST_IP:8003

KSQL Server: $DOCKER_HOST_IP:8088

Zoonavigator Web: $DOCKER_HOST_IP:8004

MYSQL Server DB: $DOCKER_HOST_IP:3306


Run with:

docker-compose -f full-stack.yml up
docker-compose -f full-stack.yml down


--------------//--------------

FOR USE : USE start.bat or start.sh

--------------//--------------

## DATABASE ##

ROOT_USER : root
ROOT_PASS : root
USER : ist
PASS : ist

--------------//--------------

WEB SERVICES

@ Return how many events was created!
start point : $APPLICATION_IP:8080/webservice
type        : GET

@ Create a new event on Kafka
new event   : $APPLICATION_IP:8080/webservice/new
type        : POST (JSON)
Ex.         :{
             	"topic":"TOPIC_NAME",
             	"key":"KEY",
             	"value":"VALUE"
             }

@
--------------//--------------


