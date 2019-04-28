object Allergies {
  def allergicTo(allergen: Allergen.Value, score: Int): Boolean = ???
  def list(score: Int): List[Allergen.Value] = ???
}

object Allergen extends Enumeration {
  type Allergen = Value

  val Peanuts: Value = Value(2)
  val Cats: Value = Value(128)
  val Strawberries: Value = Value(8)
  val Eggs: Value = Value(1)
  val Shellfish: Value = Value(4)
  val Tomatoes: Value = Value(16)
  val Chocolate: Value = Value(32)
  val Pollen: Value = Value(64)
}