package logic.conjunction

import logic.Logim
import logic.Operation

data class Conjunction(
  override val antecedent: Logim,
  override val consequent: Logim
): Operation<Conjunction> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logim, consequent: Logim) =
    Conjunction(antecedent, consequent)
  override fun toString() = "($antecedent ∧ $consequent)"
}