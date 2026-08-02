package logic.implication

import logic.*

data class Implication(
  override val antecedent: Logeme,
  override val consequent: Logeme
): Operation<Implication> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logeme, consequent: Logeme) =
    Implication(antecedent, consequent)
  override fun toString() = "($antecedent → $consequent)"
}