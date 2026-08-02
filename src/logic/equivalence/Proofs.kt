package logic.equivalence

import logic.*
import logic.conjunction.*
import logic.implication.*

val equiv = (((phi implies psi) and (psi implies phi)) implies (phi equiv psi)) and
    ((phi equiv psi) implies ((phi implies psi) and (psi implies phi)))

val equivInt = Proof {
  argue(equiv)
  argue(conjLeft(equiv.antecedent, equiv.consequent))
  qed
}

val equivLeft = Proof {
  argue(equiv)
  argue(conjRight(equiv.antecedent, equiv.consequent))
  argue(conjLeft(phi implies psi, psi implies phi))
  argue(aInt(conjLeft(phi implies psi, psi implies phi), phi equiv psi))
  argue(mpd(phi equiv psi, (phi implies psi) and (psi implies phi), phi implies psi))
  qed
}

val equivRight = Proof {
  argue(equiv)
  argue(conjRight(equiv.antecedent, equiv.consequent))
  argue(conjRight(phi implies psi, psi implies phi))
  argue(aInt(conjRight(phi implies psi, psi implies phi), phi equiv psi))
  argue(mpd(phi equiv psi, (phi implies psi) and (psi implies phi), psi implies phi))
  qed
}