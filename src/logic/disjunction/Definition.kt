package logic.disjunction

import logic.*
import logic.conjunction.and
import logic.equivalence.equiv
import logic.implication.*

val disj = ((phi or psi) implies chi) equiv ((phi implies chi) and (psi implies chi))