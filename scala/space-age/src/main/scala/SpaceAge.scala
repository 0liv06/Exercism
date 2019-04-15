import scala.language.dynamics

object SpaceAge extends Dynamic {

  private def getAgeSeconds(age: Double, ratio: Double): Double = age / (ratio * 31557600)

  def applyDynamic(name: String)(args: Double): Double = {
    name match {
      case "onEarth" => getAgeSeconds(args, 1)
      case "onMercury" => getAgeSeconds(args, 0.2408467)
      case "onVenus" => getAgeSeconds(args, 0.61519726 )
      case "onMars" => getAgeSeconds(args, 1.8808158)
      case "onJupiter" => getAgeSeconds(args, 11.862615)
      case "onSaturn" => getAgeSeconds(args, 29.447498)
      case "onUranus" => getAgeSeconds(args, 84.016846)
      case "onNeptune" => getAgeSeconds(args, 164.79132)
      case _ => 0.0
    }
  }
}