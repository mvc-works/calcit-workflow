
CoWorkflow
----

> Personal project template based on ClojureScript, Respo, shadow-cljs, Cirru, Boot.

### Usage

Make sure you have Node.js and JVM installed. Then install dependencies:

```bash
yarn
```

To run in development:

```bash
yarn watch
# another tty
yarn dev
```

To build and preview:

```bash
prod=preview yarn build
yarn serve
```

Edit Clojure with [cumulo-editor](https://github.com/Cirru/cumulo-editor):

```bash
npm i -g cumulo-editor
cumulo-editor
```

### Workflow

Workflow https://github.com/Cumulo/cumulo-workflow

Package jar file and install locally:

```bash
boot build
```

Package jar file and send to Clojars:

```bash
boot deploy
```

Get ClojureScript code:

```bash
op=compile cumulo-editor
```

Release app to my CDN:

```bash
yarn build
yarn upload
```

### License

MIT
