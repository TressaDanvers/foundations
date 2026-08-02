package logic.implication

import logic.*
import logic.proof.*

val mpd = proof {
  assuming(phi implies psi)
  assuming(phi implies (psi implies chi))
  argue(aDist)
  argue(mp(phi implies psi, phi implies chi))
  qed
}.getOrThrow()

val syl = proof {
  assuming(phi implies psi)
  assuming(psi implies chi)
  argue(aInt(psi implies chi, phi))
  argue(mpd)
  qed
}.getOrThrow()

val mpi = proof {
  assuming(phi implies (psi implies chi))
  assuming(psi)
  argue(aInt(psi, phi))
  argue(mpd)
  qed
}.getOrThrow()