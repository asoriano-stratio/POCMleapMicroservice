import java.io.File

import ml.combust.bundle.BundleFile
import ml.combust.bundle.dsl.Bundle
import ml.combust.mleap.runtime.DefaultLeapFrame
import ml.combust.mleap.runtime.types._
import ml.combust.mleap.runtime.MleapSupport._
import ml.combust.mleap.runtime.transformer.Transformer
import ml.combust.mleap.runtime.types.StructType
import resource._

import scala.util.{Failure, Success, Try}

class MleapService() {

  private var bundle: Option[Bundle[Transformer]] = None

  def setBundle(bundle: Bundle[Transformer]): Unit = synchronized(this.bundle = Some(bundle))

  def unsetBundle(): Unit = synchronized(this.bundle = None)

  def loadModel():Bundle[Transformer]= {
    (for (bf <- managed(BundleFile(new File("/tmp/model.zip")))) yield {
      bf.loadMleapBundle()
    }).tried.flatMap(identity).get
  }


  def transform(frame: DefaultLeapFrame): Try[DefaultLeapFrame] = synchronized {
    bundle.map {
      _.root.transform(frame)
    }.getOrElse(Failure(new IllegalStateException("no transformer loaded")))
  }


}