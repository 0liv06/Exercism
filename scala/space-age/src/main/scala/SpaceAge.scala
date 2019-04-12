object SpaceAge {
  private def gerAgeSeconds(age: Double, ratio: Double): Double = age / (ratio * 31557600)

  def onEarth(age: Double): Double = gerAgeSeconds(age, 1)
  def onMercury(age: Double): Double = gerAgeSeconds(age, 0.2408467)
  def onVenus(age: Double): Double = gerAgeSeconds(age, 0.61519726 )
  def onMars(age: Double): Double = gerAgeSeconds(age, 1.8808158)
  def onJupiter(age: Double): Double = gerAgeSeconds(age, 11.862615)
  def onSaturn(age: Double): Double = gerAgeSeconds(age, 29.447498)
  def onUranus(age: Double): Double = gerAgeSeconds(age, 84.016846)
  def onNeptune(age: Double): Double = gerAgeSeconds(age, 164.79132)
}
