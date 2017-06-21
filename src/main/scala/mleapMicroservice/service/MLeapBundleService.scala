package com.stratio.intelligence.mleapMicroservice.service

import org.springframework.stereotype.Service

@Service
class MLeapBundleService {

  def transformData(data:String):String = {


    "Transformed" + data
  }
}
