package logic.disjunction

import logic.*
import logic.conjunction.*
import logic.equivalence.*
import logic.implication.*
import logic.proof.*

val olc = proof {
  assuming(phi)
  val interimA = argue(disj(phi, psi, phi or psi)) as Equivalence
  argue(id(phi or psi))
  val interimB = argue(equivLeft(interimA.antecedent, interimA.consequent)) as Conjunction
  argue(conjLeft(interimB.antecedent, interimB.consequent))
  qed
}

val orc = proof {
  assuming(phi)
  val interimA = argue(disj(psi, phi, psi or phi)) as Equivalence
  argue(id(psi or phi))
  val interimB = argue(equivLeft(interimA.antecedent, interimA.consequent)) as Conjunction
  argue(conjRight(interimB.antecedent, interimB.consequent))
  qed
}