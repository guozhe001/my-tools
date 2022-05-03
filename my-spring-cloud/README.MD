# my-spring-cloud

### 模块划分与解释
* eureka-server 服务注册中心
* server-api 提供api的服务，注册到eureka
* client-api 调用server-api的客户端api，也注册到eureka；使用ribbon做客户端负载均衡
* 服务使用者（client-api）注册到服务注册中心(eureka-server)，使用提供服务的server-api提供的服务
