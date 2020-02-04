#!/bin/bash

./gradlew fatJar

java -jar build/libs/mibs-cabinet-agent-all.jar src/main/resources/application.properties


