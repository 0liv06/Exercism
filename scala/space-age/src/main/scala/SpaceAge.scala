import scala.language.dynamics

object SpaceAge extends Dynamic {

  private val conversionTable = Map("onEarth" -> 1.0,
                                    "onMercury" -> 0.2408467,
                                    "onVenus" -> 0.61519726,
                                    "onMars" -> 1.8808158,
                                    "onJupiter" -> 11.862615,
                                    "onSaturn" -> 29.447498,
                                    "onUranus" -> 84.016846,
                                    "onNeptune" -> 164.79132 )

  private def getAgeSeconds(age: Double, ratio: Double): Double = age / (ratio * 31557600)

  def applyDynamic(name: String)(args: Double): Double = {
    getAgeSeconds(args, conversionTable getOrElse (name, 0.0) )
  }
}