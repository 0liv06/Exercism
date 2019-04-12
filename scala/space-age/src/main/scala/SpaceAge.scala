object SpaceAge {
  private def getAgeSeconds(age: Double, ratio: Double): Double = age / (ratio * 31557600)

  def onEarth(age: Double): Double = getAgeSeconds(age, 1)
  def onMercury(age: Double): Double = getAgeSeconds(age, 0.2408467)
  def onVenus(age: Double): Double = getAgeSeconds(age, 0.61519726 )
  def onMars(age: Double): Double = getAgeSeconds(age, 1.8808158)
  def onJupiter(age: Double): Double = getAgeSeconds(age, 11.862615)
  def onSaturn(age: Double): Double = getAgeSeconds(age, 29.447498)
  def onUranus(age: Double): Double = getAgeSeconds(age, 84.016846)
  def onNeptune(age: Double): Double = getAgeSeconds(age, 164.79132)
}
