package logic.implication

import logic.*

val mp = phi implies ((phi implies psi) implies psi)
val aInt = phi implies (psi implies phi)
val aDist = (phi implies (psi implies chi)) implies
    ((phi implies psi) implies (phi implies chi))