# Reference implementation TOMP API

## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

## MaaS Provider
The MaaS Provider can start this application using this profile: -Dspring.profiles.active=maasprovider<br>
This means you can start the MaaS Provider like this: _java -jar tomp-ref-1.0.0.jar -Dspring.profiles.active=maasprovider_<br>

The MaaS component will start at port 8090. This means you can call the API using http://localhost:8090/{localPath}

The MaaS Provider implements also the TOMP API. This means we (mis)used the API also for communicating between an app and the backend of the MaaS Provider. 

Before calling the MaaS component, you'll have to start the TO components (have a look at the application.yml). Default it's car and bike.

e.g. calling http://localhost:8090/planning-options/ with body 
<pre>{
  "start-time": 1546336800,
  "end-time": 1546337000,
  "from": {
    "lng": 6.169639,
    "lat": 52.253279
  },
  "radius": 10,
  "to": {
    "lng": 4.897934,
    "lat": 52.362941
  },
  "travellers": 1,
  "provide-ids": true,
  "users": [
    {
      "age": 20
    }
  ]
}</pre>
will result in a few planning options. There is a very simple implementation, dividing the route in a few legs and for each leg it will look for TOs that can fulfill the request. 

##Operators
These operators are available:<br>
java -jar tomp-ref-1.0.0.jar -Dspring.profiles.active=bike<br>
java -jar tomp-ref-1.0.0.jar -Dspring.profiles.active=car<br>

There are also other possibilities to start up other operators, look at the application.yml. 

If you want to add extra functionality to a (new) operator, please make another provider class for that TO in each module. 

