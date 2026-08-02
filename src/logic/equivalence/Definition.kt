package logic.equivalence

import logic.*
import logic.conjunction.*
import logic.implication.*

val equiv = (((phi implies psi) and (psi implies phi)) implies (phi equiv psi)) and
    ((phi equiv psi) implies ((phi implies psi) and (psi implies phi)))