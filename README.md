# food-flow-hex

## docker-compose
Este projeto utiliza o Docker para rodar o pgAdmin e o PostgreSQL. Se você encontrar problemas de permissões, siga os passos abaixo para corrigir a configuração.

```shell
 sudo chown -R 5050:5050 food-flow-hex-service/docker-compose/data/pgadmin && 
 sudo chmod -R 770 food-flow-hex-service/docker-compose/data/pgadmin
 ```