package logic.negation

import logic.*
import logic.implication.*

val axin1 = (phi implies !phi) implies !phi
val axin2 = !phi implies (phi implies psi)