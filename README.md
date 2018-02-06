
Calcit Workflow
----

> Personal project template based on ClojureScript, Respo, shadow-cljs, Cirru.

### Usage

Make sure you have Node.js and JVM installed. Then install dependencies:

```bash
yarn
```

To run in development:

```bash
# yarn index.html # to regenerate target/index.html
yarn watch
```

To build and preview:

```bash
prod=preview yarn build
yarn serve
```

Edit Clojure with [calcit-editor](https://github.com/Cirru/calcit-editor):

```bash
npm i -g calcit-editor
calcit-editor
```

Package jar file and send to Clojars:

```bash
boot deploy
```

Get ClojureScript code:

```bash
op=compile calcit-editor
```

Release app to my CDN:

```bash
yarn build
yarn upload
```

### Workflow

Workflow https://github.com/mvc-works/calcit-workflow

### License

MIT
