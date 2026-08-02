package logic.implication

import logic.*
import logic.proof.*

val axmp = idi(phi implies psi)
val ax1 = a1ii
val ax2 = ax1(phi implies psi, phi implies (psi implies chi)).expand[1]