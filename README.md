
Calcit Workflow
----

> Personal project template based on ClojureScript, Respo, shadow-cljs, Cirru.

### Usage

Make sure you have Node.js and JVM installed. Then install dependencies:

```bash
yarn
```

All build script are running in:

```bash
yarn watch # to start watch server...
yarn page # to generate target/index.html file
yarn ln # link CSS files to target/ folder
yarn build # to build release bundles, with local assets links
```

Edit `config.cljs` to change the settings as you want(by default it sends assets to my server). To release:

```bash
yarn build-cdn # to build release bundles, with assets link to CDN
yarn upload # to upload assets to my server
```

Edit Clojure with [calcit-editor](https://github.com/Cirru/calcit-editor):

```bash
npm i -g calcit-editor
calcit-editor # watching server...

op=compile calcit-editor # if you need to generate code at once
```

Package jar file and send to Clojars with [Meyvn](https://github.com/danielsz/meyvn):

```bash
myven deploy
```

### Workflow

Workflow https://github.com/mvc-works/calcit-workflow

### License

MIT
