package logic.proof

import logic.*
import logic.implication.*

val idi = proof { assuming(phi); qed }
val a1ii = proof { argue(phi implies (psi implies phi)); qed }