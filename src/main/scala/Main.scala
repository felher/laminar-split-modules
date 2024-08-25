import org.scalajs.dom
import scalajs.js
import com.raquo.laminar.api.L.*

@main def hello(): Unit =
  val body = dom.document.body

  val route = Var(Route.Home)
  render(
    body,
    div(
      child <-- route.signal.splitOne(_.ordinal)((_, initRoute, routeSig) =>
        initRoute match
          case Route.Home      => button("goToLater", onClick.mapTo(Route.LoadLater) --> route.writer)
          case Route.LoadLater =>
            val delayedChild: Signal[Option[HtmlElement]] = Signal.fromJsPromise:
              js.dynamicImport:
                LoadLater.render()

            div(
              child <-- delayedChild.map(_.getOrElse(div("loading later...")))
            )
      )
    )
  )

enum Route derives CanEqual:
  case Home, LoadLater
