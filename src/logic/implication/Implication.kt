package logic.implication

import logic.*

data class Implication(
  override val antecedent: Logim,
  override val consequent: Logim
): Operation<Implication> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logim, consequent: Logim) =
    Implication(antecedent, consequent)
  override fun toString() = "($antecedent → $consequent)"
}