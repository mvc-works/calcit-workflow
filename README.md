
Calcit Workflow
----

> Personal project template based on ClojureScript, Respo, shadow-cljs, Cirru.

### Usage

Make sure you have Node.js, JVM and Lumo installed. Then install dependencies:

```bash
yarn
```

All build script are running in:

```bash
yarn watch # to start watch server...
yarn page # to generate target/index.html file
yarn build-local # to build release bundles, with local assets links
yarn build # to build release bundles, with assets link to CDN
yarn upload # to upload assets to my server
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
cd target/ && ln -s ../entry
```

### Workflow

Workflow https://github.com/mvc-works/calcit-workflow

### License

MIT
