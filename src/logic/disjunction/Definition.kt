package logic.disjunction

import logic.*
import logic.conjunction.*
import logic.equivalence.*
import logic.implication.*

val disj = ((phi or psi) implies chi) equiv ((phi implies chi) and (psi implies chi))