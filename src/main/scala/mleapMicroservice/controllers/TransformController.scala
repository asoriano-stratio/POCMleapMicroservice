package com.stratio.intelligence.mleapMicroservice.controllers

import com.stratio.intelligence.mleapMicroservice.service.MLeapBundleService
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RestController}


@RestController
class TransformController @Autowired()(mLeapBundleService: MLeapBundleService) extends LazyLogging{

  @PostMapping(value = Array("/transform"), consumes = Array("application/json"))
  def transform(@RequestBody data: String): String = {

    logger.debug("Holaaaa")
    mLeapBundleService.transformData(data)
  }

  @GetMapping(value = Array("/transform"))
  def getTransform(): String = {
    logger.debug("Holaaaa")
    "Holaaaa"
  }
}
