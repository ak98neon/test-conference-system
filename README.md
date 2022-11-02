# Test Conference System

Microservice supplies conference API for test purposes.

## Table of content

* [Development](#development)
    * [Requirements](#requirements)
    * [OpenAPI](#open-api)
    * [How to run Test Conference System](#how-to-run-test-conference-system)
    * [Testing](#testing)

## Development

### Requirements

| Requirements                   	    | Reason                         	             |
|-------------------------------------|----------------------------------------------|
| Oracle Java  17.0.2+**           	  | Conference System Service                    |
| Docker Engine version 20.10.9+** 	  | Environment variable emulation 	             |
| Docker Compose version 20.10.9+** 	 | Environment variable emulation 	             |

### Open API

Open API specification is available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui.html)  
Locally in `src/main/resources/spec/api/v1/openapi.yml`

### How to run Test Conference System:

Before all you need to build the project:

```bash
mvn clean package
```

There is `com.redhash.conference.LocalConferenceSystemApplication` class
which contains main method and all necessary infrastructure dependencies
to operate it locally on your machine.

### Testing:

```bash
mvn test
```
