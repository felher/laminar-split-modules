import org.scalajs.linker.interface.ModuleSplitStyle

val scala3Version = "3.5.0"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion                           := scala3Version,
    scalaJSUseMainModuleInitializer        := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.FewestModules
        )
    },
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.0",
    libraryDependencies += "com.raquo"    %%% "laminar"     % "17.1.0"
  )
