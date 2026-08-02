package logic.conjunction

import logic.*
import logic.implication.*

val conjLeft = (phi and psi) implies phi
val conjRight = (phi and psi) implies psi
val conj = phi implies (psi implies (phi and psi))