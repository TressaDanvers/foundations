package logic.conjunction

import logic.*
import logic.implication.*

val axia1 = (phi and psi) implies phi
val axia2 = (phi and psi) implies psi
val axia3 = phi implies (psi implies (phi and psi))