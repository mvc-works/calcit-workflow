
Calcit Workflow
----

> Personal project template based on ClojureScript, Respo, shadow-cljs, Cirru.

### Usage

Make sure you have Node.js and JVM installed. Then install dependencies:

```bash
yarn

yarn repl # to start shadow-cljs Clojure REPL
```

All build script are running in

```clojure
(require '[build.main :as b])

(b/watch) ; to start watch server
(b/html) ; to generate target/index.html file
(b/build-local) ; to build release bundles, with local assets links
(b/build) ; to build release bundles, with assets link to CDN
(b/upload) ; to upload assets to my server
```

Edit Clojure with [calcit-editor](https://github.com/Cirru/calcit-editor):

```bash
npm i -g calcit-editor
calcit-editor # watching server...

op=compile calcit-editor # generate code.
```

Package jar file and send to Clojars:

```bash
boot deploy
```

### CSS editing

During development make use of Chrome workspace and map files via:

```bash
ln -s entry target/entry
```

### Workflow

Workflow https://github.com/mvc-works/calcit-workflow

### License

MIT
