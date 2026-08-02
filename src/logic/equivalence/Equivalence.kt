package logic.equivalence

import logic.Logim
import logic.Operation

data class Equivalence(
  override val antecedent: Logim,
  override val consequent: Logim
): Operation<Equivalence> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logim, consequent: Logim) =
    Equivalence(antecedent, consequent)
  override fun toString() = "($antecedent ↔ $consequent)"
}