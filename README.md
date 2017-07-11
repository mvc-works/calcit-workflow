
Co Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal, shadow-cljs...

### Usage

Compilation steps:

```text
Cirru   -> ClojureScript  -> JavaScript   -> App
ir.edn     src/              target/         dist/
```

Dependencies:

```bash
# Node.js , JVM
npm i -g cumulo-editor
yarn
```

To run in development:

```bash
cumulo-editor
# another tty
yarn watch
# another tty
yarn dev
# open localhost:8080
```

To build:

```bash
yarn build
# outputs to dist/
```

Assets would be like: http://repo.tiye.me/mvc-works/cumulo-workflow/

### Workflow

Workflow https://github.com/mvc-works/cumulo-workflow

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

### License

MIT
