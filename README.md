This is a small example project to show how to split a UI project using Laminar into multiple modules.

Take a look at the `src/main/scala/Main.scala` file which lazyly loads the `src/main/scala/LoadLater.scala` file.

You can verify it by grepping for `lorem ipsum` in the `target/scala-3.5.0/root-fastopt/` directory after running `fastLinkJS` in sbt.

Also, if you throttle your development console, you can see the `loading later...` text.

**This loads the code via ES6 modules - you might need to serve the files with a server instead of file:/// because of CORS.**
