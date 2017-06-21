package com.stratio.intelligence.mleapMicroservice

import com.typesafe.scalalogging.LazyLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class MLeapMicroserviceApp


object MLeapMicroserviceApp extends App with LazyLogging{
  SpringApplication.run(classOf[MLeapMicroserviceApp]);
}