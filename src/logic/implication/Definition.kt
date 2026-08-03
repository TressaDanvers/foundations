package logic.implication

import logic.*

val axmp = phi implies ((phi implies psi) implies psi)
val ax1 = phi implies (psi implies phi)
val ax2 = (phi implies (psi implies chi)) implies ((phi implies psi) implies (phi implies chi))