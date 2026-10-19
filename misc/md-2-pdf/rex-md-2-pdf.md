# REX Conversion Markdown vers PDF

Markdown est depuis déjà longtemps un format largement utilisé pour écrire de la documentation technique. 
Avec l'avènement des agents de code, ce statut central pour la production documentaire s'est encore trouvé renforcé, ces agents de code privilégiant l'ingestion et la production de documents dans ce format.
Ce qui est intéressant avec Markdown, c'est que cela reste un format lisible par un être humain et qu'il peut facilement être converti vers d'autres formats.
Il en est ainsi de la conversion de Markdown vers PDF : elle se fait facilement et peut même être effectuée depuis notre IDE préféré avec un simple _plugin_ dans le pire des cas.

Alors pourquoi se donner la peine de faire un article sur ce sujet ?

La conversion d'un fichier Markdown en HTML ou en PDF est assez directe mais donne un résultat visuel assez pauvre. 
Par contre, afin d'avoir un rendu visuel qui soit suffisamment propre et agréable pour avoir une touche _professionnelle_ (une page de titre, un sommaire, un document aéré et facile à lire, agréable à l'œil, etc.), cela demande un peu de travail.

L'objet de cet article est de vous faire un retour d'expérience sur la conversion d'un fichier Markdown en un fichier HTML ou PDF répondant à certaines exigences de présentation pour que le rendu fasse _professionnel_, et de donner au passage des pointeurs et une mise en œuvre concrète avec les limites et problèmes rencontrés.

## Le contexte

Le contexte dans lequel se situe ce besoin de conversion de fichiers Markdown vers HTML & PDF est celui d'une mission d'analyse et de rétro-documentation d'une application _legacy_ pour laquelle la connaissance s'est perdue. Je ne vais pas rentrer dans les détails ici (ce n'est pas l'objet) mais comme les lignes précédentes le laissent penser, dans ce projet on a généré beaucoup de documentation.
Le choix du format de génération s'est naturellement porté sur Markdown puisqu'il reste lisible pour les humains, qu'il est facile à lire et consommer par des agents et qu'il est facilement convertible vers du HTML et du PDF par exemple.

## In the beginning

Initialement il y avait peu de documents et l'urgence n'était pas la conversion des documents en PDF. 
Je pouvais toujours le faire facilement depuis mon IDE (ici VS Code). 
Cependant à peu près en même temps, lors d'une intervention sur un autre projet, un collègue me demande une relecture d'un document PDF.
Là en relisant le document, je reconnais le style de document généré avec [LaTeX](https://fr.wikipedia.org/wiki/LaTeX).
Pour la petite histoire, lors de ma prime jeunesse, quand j'étais étudiant en DEA (l'équivalent d'un Master 2 actuellement... cela vous donne une idée de mon âge... mais bon il faut faire un saut de 30 ans en arrière !) puis en doctorat, j'ai utilisé abondamment [LaTeX](https://fr.wikipedia.org/wiki/LaTeX). Cet outil, comme tout outil, a ses forces et ses faiblesses. Pour de la production scientifique et académique ou pour produire de gros documents avec beaucoup d'images, c'était bien mieux qu'un traitement de texte classique à l'époque.
Je suis un peu surpris, car actuellement, en dehors du monde académique, il est rare d'utiliser directement [LaTeX](https://fr.wikipedia.org/wiki/LaTeX) ; les ingénieurs logiciels utilisent plus volontiers des formats comme [Markdown](https://fr.wikipedia.org/wiki/Markdown) ou [AsciiDoc](https://fr.wikipedia.org/wiki/AsciiDoc).
En échangeant avec lui, je m'aperçois qu'il écrit bien en Markdown.
Par contre il utilise [Pandoc](https://pandoc.org/) pour convertir le document en PDF.
[Pandoc](https://pandoc.org/) je connais et j'ai déjà utilisé mais j'étais resté en surface.
C'est clairement le couteau suisse de la conversion de format.
Comme je savais que la conversion manuelle avec un plugin de l'IDE ne serait pas viable très longtemps, c'était l'occasion de creuser un peu plus Pandoc pour voir comment automatiser mes conversions.

## Pandoc

[Pandoc](https://pandoc.org/) est un outil en ligne de commande, ce qui est très pratique pour pouvoir l'utiliser dans un _script shell_.
De plus cet outil est disponible sur Linux, macOS et Windows, ce dernier système d'exploitation étant celui que j'utilisais dans le cadre de ce projet (je sais, ce n'est pas très _geek_ et je tiens à préciser que je n'ai rien contre Linux ou macOS :-)).
Dans tous les cas, que Pandoc soit une **CLI** (Command Line Interface) multi-plateforme est clairement un très gros avantage.
Rien que pour cela, il est à avoir dans sa trousse à outils pour ce type de situation.

## Conversion de Markdown en PDF en passant par le HTML

En creusant un peu le sujet, on s'aperçoit qu'il y a plusieurs options pour convertir un Markdown en PDF en utilisant Pandoc.
Dans la suite de cet article, je vais m'intéresser à deux chemins pour passer d'un Markdown à un PDF avec une bonne qualité de rendu :

- Markdown → HTML → PDF
- Markdown → LaTeX → PDF

Nous explorons d'abord la conversion en PDF en passant par HTML, car c'est celle qui demande le moins de grosses installations sur sa machine. Donc, si le résultat vous convient, c'est la solution la moins lourde à implémenter.

Le processus est simple : on utilise Pandoc pour convertir le Markdown en HTML, puis Chrome en mode _headless_ pour convertir le HTML en PDF.

Pour que cela marche dans la ligne de commande ou dans un script il faut s'assurer que :

- le binaire `pandoc` soit dans le chemin d'exécution 
- le binaire `Chrome` soit dans le chemin d'exécution (même si vous l'avez comme navigateur, l'exécutable de Chrome n'est pas nécessairement dans le `PATH`, il faut bien s'assurer de l'y ajouter)

Pandoc permet de paramétrer assez finement la conversion, comme nous allons le voir.
Pour convertir le fichier Markdown en HTML, on pourrait avoir une ligne de commande similaire à ce qui suit :

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --math-method=mathjax --syntax-highlighting pygments -c style.css -o test-file.html
```

- Le _template_ HTML à utiliser (`--template template-pandoc.html`)
- Le fichier de style CSS à utiliser dans le HTML (`-c style.css`)
- Le style de _syntax highlighting_ à utiliser pour le code dans le document le cas échéant (par exemple pour avoir un style similaire à [Pygments](https://pygments.org/) `--syntax-highlighting=pygments`, qui est d'ailleurs le style par défaut si on ne précise rien) ; à noter que le style CSS fourni peut surcharger le rendu initial.
- si on souhaite avoir une table des matières (`--toc`)
- si on souhaite avoir une numérotation des sections  (`--number-sections`)
- si on souhaite que le code LaTeX inline soit correctement rendu, il faut utiliser l'option `--math-method=mathjax` (et dans le `<head>` du template, on doit avoir un `$math$`)
- `test-file.md` est le fichier Markdown que nous cherchons à transformer
- `-o test-file.html` indique le fichier de sortie résultat de la conversion

Avec les fichiers `test-file.md` (disponible [ici](./md-html-pdf/test-file.md)), `style.css` (disponible [ici](./md-html-pdf/style.css)) et `template-pandoc.html` (disponible [ici](./md-html-pdf/template-pandoc.html)), on obtient un document HTML plutôt propre (disponible [ici](./md-html-pdf/test-file.html))

Seul le code du diagramme Mermaid inséré directement dans le markdown n'est pas converti directement en une image. 
En fait c'est normal, il faut ajouter un [filtre supplémentaire](https://github.com/pandoc-ext/diagram) en [Lua](https://www.lua.org/). Il est également nécessaire d'avoir [Mermaid CLI](https://github.com/mermaid-js/mermaid-cli) dans le `PATH`.

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --math-method=mathjax --syntax-highlighting=pygments -c style.css --lua-filter diagram.lua --extract-media=media -o test-file.html
```

Comme l'indique le [README](https://github.com/pandoc-ext/diagram/blob/main/README.md), il faut ajouter l'option `--extract-media` pour que l'image générée à partir du diagramme Mermaid soit créée sur le disque (ici dans le répertoire `media`) et puisse être liée dans la page HTML. À noter que tous les médias sont _extraits_ du fichier Markdown, y compris les images locales ou distantes.

Il est également normalement possible, d'après le [README](https://github.com/pandoc-ext/diagram/blob/main/README.md), de faire en sorte que l'image générée soit directement incluse dans le HTML en utilisant l'option `--embed-resources`. Comme pour `--extract-media`, l'option est globale et concernera l'ensemble des images référencées dans le document Markdown qui se retrouveront toutes incluses dans le HTML.  Cependant cette option ne garantit pas l’autonomie complète lorsque JavaScript charge ensuite des ressources, comme cela peut être le cas avec MathJax et ses fontes.

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --math-method=mathjax --syntax-highlighting=pygments -c style.css --lua-filter diagram.lua --embed-resources -o test-file.html
```

À noter que sous Windows, avec une version de Node gérée via [fnm](https://github.com/schniz/fnm), j'ai eu des difficultés pour que le script Lua trouve la CLI `mmdc`, pourtant installée de manière globale avec [npm](https://www.npmjs.com/). Il a été nécessaire que j'ajoute les lignes ci-après dans le `front-matter` YAML du fichier Markdown à convertir. GitHub Copilot en _mode Ask_ a été bien utile pour m'aider à trouver quels étaient les problèmes et comment les résoudre rapidement !

```yaml
diagram:
  engine:
    mermaid:
      execpath: [cmd.exe, /d, /c, mmdc.cmd]
```

A noter que l'exemple ci-dessus (que vous retrouverez dans le fichier `test-file.md`) ne sera valable que sous Windows.
Pour les besoins de l'exemple, j'ai recopié le [filtre en Lua](./md-html-pdf/diagram.lua) directement dans le répertoire de travail dans lequel j'ai lancé la ligne de commande mais il provient sans modification de [Diagram Generator](https://github.com/pandoc-ext/diagram). 

Maintenant que nous avons le fichier HTML, nous pouvons le convertir en PDF avec Chrome.

```bash
Chrome --headless --disable-gpu --no-pdf-header-footer --print-to-pdf="/chemin/complet/vers/fichier/test-file.pdf" "/chemin/complet/vers/fichier/test-file.html"
```

Attention, il faut indiquer les chemins complets vers le fichier source que l'on transforme et le fichier cible ; vous devez adapter légèrement la ligne de commande ci-dessus avec les chemins corrects vers les fichiers source et cible.
Bien sûr l'option `--headless` est nécessaire pour ne pas démarrer Chrome sans que la fenêtre du navigateur ne soit lancée.
L'option `--no-pdf-header-footer` permet de ne pas avoir les en-têtes et pieds de page classiques avec la date et le numéro de page.

Pour un meilleur rendu des caractères Unicode et des emojis présents dans le document, il faut éventuellement installer des fontes supplémentaires ; pour ma part j'ai installé les fontes suivantes :

- https://fonts.google.com/noto/specimen/Noto+Sans
- https://fonts.google.com/noto/specimen/Noto+Emoji
- https://fonts.google.com/specimen/Cascadia+Code

Le document PDF produit avec le [fichier d'exemple Markdown](./md-html-pdf/test-file.md) est disponible [ici](./md-html-pdf/test-file.pdf).

En synthèse, les 2 lignes à lancer sont les suivantes si on choisit l'extraction des images du fichier Markdown dans un répertoire `media`:

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --math-method=mathjax --syntax-highlighting=pygments -c style.css --lua-filter diagram.lua --extract-media=media -o test-file.html
Chrome --headless --disable-gpu --no-pdf-header-footer --print-to-pdf="/chemin/complet/vers/fichier/test-file.pdf" "/chemin/complet/vers/fichier/test-file.html"
```

Au final, les rendus HTML et PDF sont très propres et peuvent être considérés comme professionnels. Si on maîtrise bien CSS et HTML, cela peut être une option particulièrement pertinente pour personnaliser le rendu.

Avant de voir ce que cela peut donner en utilisant [LaTeX](https://fr.wikipedia.org/wiki/LaTeX), un petit mot sur les options à Chrome pour convertir du HTML vers PDF.

En effet, il est également possible d'effectuer la conversion avec [weasyprint](https://weasyprint.org/) ou [wkhtmltopdf](https://wkhtmltopdf.org/) plutôt qu'avec Chrome.

## Utilisation de weasyprint plutôt que Chrome

L'expérience avec [weasyprint](https://weasyprint.org/) relatée ci-après dépend aussi fortement de l’environnement dans lequel je l’ai menée (à savoir Windows) et pourrait être assez différente avec un autre _OS_. En conséquence ce paragraphe est aussi très orienté pour des utilisateurs de Windows et aura beaucoup moins d'intérêt pour des utilisateurs de Linux ou macOS.

Étant un utilisateur occasionnel de Python, j'en avais déjà une version sur ma machine et j'ai essayé [weasyprint](https://weasyprint.org/).
L'installation via Python est classique via `pip`: `pip install weasyprint`
Cependant sous Windows, il faut _installer_ **GTK** pour que **weasyprint** fonctionne correctement
Il faut donc télécharger le [runtime GTK pour Windows](https://github.com/tschoonj/GTK-for-Windows-Runtime-Environment-Installer/releases).
Une fois l'installation effectuée, il faut ajouter le répertoire `bin` au `PATH` Windows.
Pour vérifier l'installation de GTK sous Windows avec PowerShell si vous avez effectué l'installation sous `C:\Outils\misc` : `Get-ChildItem -Recurse "C:\Outils\misc" -Filter libgobject-2.0-0.dll`

Pour tester **weasyprint** une fois qu'il a été installé via `pip`: `weasyprint --info` 

Néanmoins, en plus de l'installation du _runtime GTK_, sur ma version de Windows j'ai été obligé d'installer la version **59** de **weasyprint** plutôt que la dernière version : `pip install weasyprint==59.0`
En conséquence, il a également fallu que j'installe une version adaptée de `pydyf`

- désinstallation de `pydyf` s'il était déjà installé par ailleurs `pip uninstall pydyf`
  - Attention ici, si vous n'avez pas utilisé un environnement virtuel et si `pydyf` est installé de manière globale, il faut s'assurer avant de le désinstaller qu'il n'est pas utilisé par un autre projet Python.
- installation de la version compatible avec la version **59** de **weasyprint** : `pip install pydyf==0.6.0`

**NB :** afin de ne pas alourdir l'article je ne suis pas rentré dans les détails ici mais idéalement vous avez intérêt avec Python à utiliser des environnements virtuels spécifiques à chacun de vos projets afin d'isoler leurs dépendances de celles des autres projets. Si vous avez besoin d'un petit rappel sur le sujet, j'avais fait un [article](https://medium.com/norsys-octogone/creating-and-using-a-virtual-environment-for-python-with-venv-7845e985e805) sur la manière d'en créer avec `venv`.

Ensuite, j'ai eu des erreurs liées aux fontes : `Fontconfig error: Cannot load default config file`.

Pour régler ce problème-là, il faut ajouter une variable d'environnement `FONTCONFIG_PATH`.
Sous PowerShell, pour ajouter temporairement cette variable, on peut définir `$env:FONTCONFIG_PATH="C:\Outils\Misc\GTK3-Runtime Win64\etc\fonts"` dans un shell de commande PowerShell (chemin à ajuster selon le répertoire d'installation du _runtime GTK_ ; dans l'exemple précédent, il s'agissait de `"C:\Outils\Misc\GTK3-Runtime Win64"`).

Pour ajouter la variable d'environnement de façon plus permanente, on peut l'ajouter aux variables d'environnement via l'interface graphique ou directement avec PowerShell :

```powershell
[System.Environment]::SetEnvironmentVariable(
    "FONTCONFIG_PATH",
    "C:\Outils\Misc\GTK3-Runtime Win64\etc\fonts",
    "User"
)
```

Sachant que **weasyprint 59** ne supporte pas toutes les fonctionnalités _Flexbox/Grid_ modernes et que le rendu au final n'est pas mieux qu'avec Chrome, cela n'a pas été une expérience concluante de mon côté. 
Cela ne signifie pas que cette option ne puisse pas être intéressante pour vous.

Il est important que vous ayez cette possibilité en tête si pour une raison ou une autre l'utilisation de Chrome n'est pas possible pour vous ou pose problème.

## Utilisation de wkhtmltopdf plutôt que Chrome

L'outil [wkhtmltopdf](https://wkhtmltopdf.org/) est également un outil assez connu pour la conversion de HTML vers PDF.
Il existe des binaires pour différentes plateformes.
Il faut noter que le moteur de [wkhtmltopdf](https://wkhtmltopdf.org/) est ancien et il est déconseillé de l'utiliser avec du HTML non fiable (voir l'état officiel de [wkhtmltopdf](https://wkhtmltopdf.org/status.html)).
La documentation est relativement limitée par contre et repose sur la documentation en ligne de commande au moment de l'écriture de cet article (`wkhtmltopdf -H`).
Il existe une pléthore d'options que l'on peut passer à [wkhtmltopdf](https://wkhtmltopdf.org/).

```bash
wkhtmltopdf test-file.html test-file-wkhtmltopdf.pdf
```

Après quelques essais avec différentes options je n'ai pas réussi à générer un document PDF avec la qualité que j'attendais (voire dans certains cas la génération du PDF n'a même pas fonctionné).

Donc comme avec **weasyprint**, **wkhtmltopdf** n'a pas été une expérience concluante de mon côté. 
Encore une fois, cela ne signifie pas que cette option ne puisse pas être intéressante pour vous, et il est important que vous ayez cette possibilité en tête si, pour une raison ou une autre, l'utilisation de Chrome n'est pas possible pour vous. Garder néanmoins à l'esprit que ce n'est pas l'option la plus récente et qu'elle est à éviter sur du HTML auquel vous ne faites pas confiance.

## Génération d'un PDF en passant par LaTeX

Toujours en utilisant [Pandoc](https://pandoc.org/) un autre chemin est possible pour passer d'un document au format Markdown à PDF, en passant par le format [TeX](https://fr.wikipedia.org/wiki/TeX)/[LaTeX](https://fr.wikipedia.org/wiki/LaTeX) plutôt que par HTML.

Sous Windows, le plus simple est d'installer [MiKTeX](https://miktex.org/), qui est également disponible pour les plateformes Linux et macOS.
L'installation de MiKTeX n'est pas compliquée (elle se fait via un installeur graphique) et est [documentée](https://docs.miktex.org/manual/installing.html), mais prend un peu de temps et de place sur votre disque dur.
Selon votre système d'exploitation, il existe d'autres distributions de [LaTeX](https://fr.wikipedia.org/wiki/LaTeX), vous avez donc le choix à ce niveau. Par contre dans tous les cas, vous avez besoin d'une installation de **LaTeX**.

Comme pour la contrepartie HTML, pour avoir un minimum de contrôle sur le rendu final, il est recommandé d'utiliser un _template_.
Il est bien sûr toujours possible de créer le vôtre si vous avez la compétence, le temps et/ou les tokens (je n'ai pas essayé mais cela doit être possible de piloter un agent de code pour qu'il produise ce template)
Néanmoins, pourquoi réinventer la roue, si une solution de bonne facture existe déjà ?
Ainsi, pour ma part j'ai installé les _templates_ [_Eisvogel_](https://github.com/wandmalfarbe/Pandoc-latex-template).
L'installation n'est pas compliquée et est expliquée dans le [README](https://github.com/Wandmalfarbe/pandoc-latex-template/blob/master/README.md) du projet : il faut récupérer une archive `.zip` et mettre les bons fichiers dans le bon répertoire (un sous-répertoire de données de **Pandoc**).

J'ai suivi la procédure d'installation des templates décrite dans le `README` et je n'ai pas rencontré de problème particulier.

Ce _template_ vient avec un certain nombre de paramètres que l'on peut _injecter_ : les métadonnées lues dans un _front matter_ `yaml` en début du document Markdown à convertir peuvent alimenter les valeurs de ces paramètres.

Le fichier d'exemple [test-file.md](./md-latex-pdf/test-file.md) est doté d'un _front matter_ prérempli ; un [fichier modèle de métadonnées](./md-latex-pdf/template-metadata.yml) est également disponible. Cet exemple facilite la spécification à un agent ou dans un _skill_.

Au niveau de `pandoc`, on spécifie le moteur **LaTeX** que l'on souhaite utiliser (option `--pdf-engine` ; pour ma part, j'utilise `lualatex`, mais il y en a d'autres ; il faut juste s'assurer que ce moteur **LaTeX** a bien été installé ou compléter l'installation).

```bash
pandoc test-file.md --pdf-engine=lualatex --template=eisvogel --toc --number-sections --resource-path=. --lua-filter diagram.lua --extract-media=media --from markdown --to pdf -o test-file.pdf
```

- L'option `--toc` permet la génération de la table des matières
- L'option `--number-sections` permet la numérotation des sections
- L'option `--resource-path=.` indique que les liens vers les images et les ressources dans le Markdown pour les chemins relatifs sont à considérer par rapport au répertoire de travail du processus. Dans cet exemple, la commande est lancée dans le répertoire dans lequel se trouve le fichier à convertir : si vous incorporez cet exemple dans un script `shell` ou `PowerShell`, il faudra adapter la valeur au répertoire dans lequel se trouve le fichier à convertir.
- Les options `--lua-filter diagram.lua` et `--extract-media=media` fonctionnent de concert de la même manière que pour la conversion vers HTML
- Les options `--from markdown` et `--to pdf` indiquent respectivement le format source et le format cible.
- L'option `-o test-file.pdf` précise le fichier de sortie

Comme indiqué un peu plus haut, pour un meilleur rendu des caractères Unicode et des emojis présents dans le document, j'ai installé les fontes suivantes :

- https://fonts.google.com/noto/specimen/Noto+Sans
- https://fonts.google.com/noto/specimen/Noto+Emoji
- https://fonts.google.com/specimen/Cascadia+Code

Leur utilisation est explicite au niveau du _front matter_ **YAML**  :

```yaml
---
[...]
mainfont: "Noto Sans"

sansfont: "Noto Sans"

monofont: "Cascadia Code"
[...]
---
```

À noter que, malgré cela, certains caractères Unicode ou certains émojis ne sont pas traduits correctement : normalement, vous aurez des avertissements lors de la conversion, même si cela ne bloque pas la génération du PDF.
Le plus simple est d'éviter ces caractères en les remplaçant par d'autres équivalents (il existe souvent des alternatives).
Cela peut être un critère de choix pour préférer la conversion en **PDF** depuis du **HTML** plutôt qu'en passant par **LaTeX**.

Avec MiKTeX, les _packages_ LaTeX nécessaires à la conversion mais manquants peuvent être téléchargés après validation par l'utilisateur.

Selon la machine que vous avez, la conversion peut prendre un peu de temps (quelques minutes). Si vous avez un gros volume de documents Markdown à convertir, il faut éventuellement en tenir compte.

Le fichier PDF obtenu est [test-file.pdf](./md-latex-pdf/test-file.pdf).
Là aussi, on obtient un rendu PDF très propre pouvant être considéré comme _professionnel_.

### Petite note concernant la sécurité

Le filtre `diagram.lua:398` lit `execpath` dans les métadonnées et le transmet à `pandoc.pipe` pour lancer un processus. Vous noterez que le document d’exemple `test-file.md` configure précisément `cmd.exe /c mmdc.cmd`. Il est donc important que cette chaîne traite uniquement des documents de _confiance_ : un document non fiable peut influer sur l’exécutable lancé. 
L'option `--sandbox` ne suffit pas à isoler les filtres et moteurs PDF, comme le rappelle le [manuel Pandoc](https://pandoc.org/MANUAL.html#a-note-on-security).

## Conclusion

Il existe des outils pour convertir simplement et rapidement un fichier **Markdown** en **PDF** mais au prix d'un rendu qui lui aussi est simple, voire simpliste.
Il y a néanmoins des solutions pour créer un **PDF** avec un rendu plus _professionnel_ mais elles demandent un peu de travail.

Dans cet article, je vous en présente 2 qui donnent des résultats très satisfaisants.

L'une passe par une conversion intermédiaire en **HTML** puis de là permet de convertir le **HTML** en **PDF**, en agrémentant ces conversions avec des feuilles de style (**CSS**) et des templates (**HTML**). Il gère bien les emojis et est un bon choix si on a également besoin de la version **HTML**. Elle sera particulièrement attirante pour ceux qui ont déjà une bonne maitrise de **CSS** et **HTML**. Enfin elle ne nécessite que l'installation de [Pandoc](https://pandoc.org/) et Chrome (et éventuellement Node et Mermaid CLI si vous avez besoin de gérer des diagrammes de ce type).

L'autre passe par l'utilisation d'un moteur **LaTeX** pour obtenir le **PDF**. Là encore, le cœur de la transformation passe par l'utilisation d'un _template_ qui permet de bien cadrer la conversion. Les emojis ne sont pas bien gérés mais la pagination finale du document PDF produit est meilleure que pour la première option à mon sens. J'apprécie également le rendu final mais j'ai probablement un biais pour les rendus que permet d'offrir **LaTeX**. Enfin, il faut noter que par rapport à la première option, il faut prévoir des installations plus lourdes (il faut installer une distribution **LaTeX** et éventuellement Node et Mermaid CLI comme la première option).

J'espère que cela permettra de vous faire votre propre opinion et de pouvoir converger plus rapidement vers la solution qui correspond le mieux à vos besoins. Tous les exemples et les résultats des générations sont [disponibles sur GitHub dans ce petit projet](https://github.com/TGITS/devtoolbox/misc/md-2-pdf) et librement réutilisables : il faudra peut-être faire des adaptations par rapport à votre système et, bien sûr, tout cela vous est fourni _tel quel_ sans garantie aucune. 
À ce sujet, il faut garder à l’esprit que les exemples supposent que les fichiers Markdown et HTML proviennent d’une source que vous maîtrisez et en laquelle vous avez confiance. En effet, j'ai effectué ce travail dans un contexte où j'étais le producteur des fichiers Markdown et HTML. 
Il n’est pas sans risque d’utiliser ces exemples avec des fichiers auxquels vous ne pouvez pas pleinement faire confiance. Comme tout ce que vous pouvez récupérer sur Internet, tout cela est à utiliser avec précaution et demande une validation.

J'espère néanmoins que vous pourrez exploiter ce retour d'expérience pour faciliter vos conversions de Markdown vers PDF et HTML.