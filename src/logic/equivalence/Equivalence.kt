package logic.equivalence

import logic.Logeme
import logic.Operation

data class Equivalence(
  override val antecedent: Logeme,
  override val consequent: Logeme
): Operation<Equivalence> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logeme, consequent: Logeme) =
    Equivalence(antecedent, consequent)
  override fun toString() = "($antecedent ↔ $consequent)"
}