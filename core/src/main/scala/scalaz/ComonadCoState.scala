package scalaz

trait ComonadCoState[F[_, _], S] extends CoMonad[({type f[x]=F[S,x]})#f] {
  def pos[A](w: F[S, A]): S
  def peek[A](s: S, w: F[S, A]): A
  def peeks[A](s: S => S, w: F[S, A]): A
  def seek[A](s: S, w: F[S, A]): F[S, A]
  def seeks[A](s: S => S, w: F[S, A]): F[S, A]
}

object ComonadCoState {
  def apply[F[_,_],S](implicit F: ComonadCoState[F, S]) = F
}