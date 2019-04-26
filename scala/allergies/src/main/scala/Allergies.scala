object Allergies {
  def allergicTo(allergen: Allergen.Value, score: Int): Boolean = ???
  def list(score: Int): List[Allergen.Value] = ???
}

object Allergen extends Enumeration {
  type Allergen = Value
  val Peanuts, Cats, Strawberries, Eggs, Shellfish, Tomatoes, Chocolate, Pollen = Value
}