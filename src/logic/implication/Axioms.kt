package logic.implication

import logic.*

val aInt = phi implies (psi implies phi)
val aDist = (phi implies (psi implies chi)) implies
    ((phi implies psi) implies (phi implies chi))