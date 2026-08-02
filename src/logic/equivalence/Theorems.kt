package logic.equivalence

import logic.*
import logic.conjunction.*
import logic.implication.*
import logic.proof.*

val equivInt = proof {
  argue(equiv)
  argue(conjLeft(equiv.antecedent, equiv.consequent))
  qed
}

val equivLeft = proof {
  argue(equiv)
  argue(conjRight(equiv.antecedent, equiv.consequent))
  argue(conjLeft(phi implies psi, psi implies phi))
  argue(aInt(conjLeft(phi implies psi, psi implies phi), phi equiv psi))
  argue(mpd(phi equiv psi, (phi implies psi) and (psi implies phi), phi implies psi))
  qed
}

val equivRight = proof {
  argue(equiv)
  argue(conjRight(equiv.antecedent, equiv.consequent))
  argue(conjRight(phi implies psi, psi implies phi))
  argue(aInt(conjRight(phi implies psi, psi implies phi), phi equiv psi))
  argue(mpd(phi equiv psi, (phi implies psi) and (psi implies phi), psi implies phi))
  qed
}