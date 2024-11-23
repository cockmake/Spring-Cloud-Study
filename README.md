-   **mysql-docker**

    >   docker run -d --name mysql-docker -p 13306:3306 -v D:/docker-volumes/mysql-docker/data:/var/lib/mysql -v D:/docker-volumes/mysql-docker/conf:/etc/mysql/conf.d -v D:/docker-volumes/mysql-docker/init:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=123456 -e TZ=Asia/Shanghai --network make --ip 172.18.0.6 sha256:b7aff0191ea53fafcae68c591ffaeaec6c2d47c34efa1e27d45c4d614b775f11

-   **nginx-docker**

    >   docker run -d --name nginx-docker -p 18080:8080 -p 18081:8081 -v D:/docker-volumes/nginx-docker/html:/usr/share/nginx/html -v D:/docker-volumes/nginx-docker/nginx.conf:/etc/nginx/nginx.conf:ro --network make --ip 172.18.0.8 sha256:3b25b682ea82b2db3cc4fd48db818be788ee3f902ac7378090cf2624ec2442df

-   **java.jar**

    >   docker run -d --name hmall-docker -p 8080:8080 --network make --ip 172.18.0.10 sha256:7660d010d3e94e9a4be9bfb160a60e24696645b773ebe28d3fa576df6cd99fa4

-   **nacos**

    >   docker run -d --name nacos --env-file ./custom.env -p 8848:8848 -p 9848:9848 -p 9849:9849 --network=make --ip=172.18.0.2 nacos:v2.4.3-slim

-   **seata**

    >   docker run -d --name seata -p 8099:8099 -p 7099:7099 -v D:/docker-volumes/seata-docker/seata:/seata-server/resources -e SEATA_IP=192.168.81.1 --privileged=true --network=make --ip=172.18.0.15 sha256:67a654ca2e05268efb435698bc59f82ebb75e68e6e5e23f0626321f50eb01a8d

-   **sentinel**

    >   java '-Dserver.port=8090' '-Dcsp.sentinel.dashboard.server=localhost:8090' '-Dproject.name=sentinel-dashboard' -jar .\sentinel-dashboard-1.8.8.jar