package logic.negation

import logic.*

data class Negation(override val logeme: Logeme): Property<Negation> {
  override fun build(logeme: Logeme) = Negation(logeme)
  override val free get() = logeme.free
  override fun toString() = "¬$logeme"
}
