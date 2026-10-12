# REX Conversion Markdown vers PDF

Outils et utilitaires utilisés dans ce projet.

Markdown est depuis déjà longtemps un format largement utilisé pour écrire de la documentation technique. 
Avec l'avènement des agents de code ce statut central pour la production documentaire s'est encore trouver renforcé, ces agents de code privilégiant l'ingestion et la production de document dans ce format.
Ce qui est intéressant avec Markdown c'est que cela reste un format lisible pas un être humain et qu'il peut facilement être converti vers d'autres formats.
Il en est ainsi de la conversion de Markdown vers PDF, elle se fait facilement et peut même être effectué depuis notre IDE préféré avec un simple _plugin_ dans le pire cas.

Alors pourquoi se donner la peine de faire un article sur ce sujet ?

La conversion d'un fichier Markdown en HTML ou en PDF est assez directe mais donne un résultat visuel assez pauvre. 
Par contre, afin d'avoir un rendu visuel qui soit suffisamment propre et agréable pour avoir une touche _professionnelle_ (une page de titre, un sommaire, un document aéré et facile à lire, agréable à l'oeil, etc.), cela demande un peu de travail.

L'objet de cet article est de vous faire un retour d'expérience sur la conversion d'un fichier Markdown en un fichier HTML ou PDF qui répondent à certaines exigences de présentations pour que le rendu fasse _professionnel_ et de donner au passage des pointeurs et de la mise en oeuvre concrète avec les limites et problèmes rencontrés.

## Le contexte

Le contexte dans lequel se situe ce besoin de conversion de fichiers Markdown vers HTML & PDF est celui d'une mission d'analyse et de rétro-documentation d'une application _legacy_ pour laquelle la connaissance s'est perdue. Je ne vais pas rentrer dans les détails ici (ce n'est pas l'objet) mais comme les lignes précédentes le laissent penser, dans ce projet on a généré beaucoup de documentation.
Le choix du format de génération s'est naturellement porté sur Markdown puisqu'il reste lisible pour les humains, qu'il est facile à lire et consommer par des agents et qu'il est facilement convertible vers du HTML et du PDF par exemple.

## In the beginning

Initialement il y avait peu de documents et l'urgence n'était pas la conversion des documents en PDF. 
Je pouvais toujours le faire facilement depuis mon IDE (ici VS Code). 
Cependant à peu près en même temps, lors d'une intervention sur un autre projet, un collègue me demande une relecture d'un document PDF.
Là en relisant le document, je reconnais le style de document généré avec LaTeX.
Pour la petite histoire, lors de ma prime jeunesse, quand j'étais étudiant en DEA (l'équivalent d'un Master 2 actuellement... cela vous donne une idée de mon âge... mais bon il faut faire un saut de 30 ans en arrière !) puis en doctorat, j'ai utilisé abondamment LaTeX. Cet outil comme tout outil à ses forces et ses faiblesses. Pour de la production scientifique et académique ou pour produire des gros documents avec beaucoup d'images c'était bien mieux qu'un traitement de texte classique à l'époque.
Je suis un peu surpris, car actuellement en dehors du monde académique il est rare d'utiliser directement LaTeX, les ingénieurs locigiels utilisent plus volontier des formats comme Markdown ou AsciiDoc.
En échangeant avec lui, je m'aperçois qu'il écrit bien en Markdown.
Par contre il utilise [Pandoc](https://pandoc.org/) pour convertir le document en PDF.
[Pandoc](https://pandoc.org/) je connais et j'ai déjà utilisé mais j'étais resté en surface.
C'est clairement le couteau suisse de la conversion de format.
Comme je savais que la conversion manuelle avec un plugin de l'IDE ne serait pas viable très longtemps, c'était l'occasion de creuser un peu plus Pandoc pour voir comment automatiser mes conversions.

## Pandoc

[Pandoc](https://pandoc.org/) est un outil en ligne de commande, ce qui est très pratique pour pouvoir l'utiliser dans un _script shell_.
De plus cet outil est disponible sur Linux, MacOs et Windows, ce dernier système d'exploitation étant celui que j'utilisais dans le cadre de ce projet (je sais ce n'est pas très _geek_ et je tiens à préciser que je n'ai rien contre Linux ou MacOs :-)).
Dans tous les cas, que Pandoc soit une CLI multi-plateforme est clairement un très gros avantage.
Rien que pour cela il est à avoir dans sa trousse à outil pour ce type de situation.

## Conversion de Markdown en PDF en passant par le HTML

En creusant un peu le sujet, on s'aperçoit qu'il y a plusieurs options pour convertir un Markdown en PDF en utilisant Pandoc.
Dans la suite de cet article, je vais m'intéresser à 2 chemins pour passer d'un Makdown à un PDF avec une bonne quamité de rendu:

- Markdown → HTML → PDF
- Markodwn → LaTeX → PDF

Nous explorons d'abord la conversion en PDF en passant par HTML car c'est celle qui demande le moins de grosse installation sur sa machine. Donc si le résultat sous convient c'est la solution la moins lourdre à implémenter. 

Le processus est simple : on utilise Pandoc pour convertir le Markdown en HTML, puis Chrome en mode _headless_ pour convertir le HTML en PDF.

Pour que cela marche dans la ligne de commande ou dans un script il faut s'assurer que :

- le binaire `Pandoc` soit dans le chemin d'exécution 
- le binaire `Chrome` soit dans le chemin d'exécution (même si vous l'avez comme navigateur, l'exécutable de Chrome n'est pas nécessairement dans le `PATH`, il faut bien s'assurer de l'y ajouter)

Pandoc permet de paramètrer assez finement la conversion comme nous allons le voir. 
Pour convertir le fichier Markdown en HTML, on pourrait avoir une ligne de commande similaire à ce qui suit :

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --mathjax --syntax-highlighting pygments -c style.css -o test-file.html
```

- Le _template_ HTML à utiliser (`--template template-pandoc.html`)
- Le fichier de style CSS à utiliser dans le HTML (`-c style.css`)
- Le style de _syntax highligthing_ à utiliser pour le code dans le document le cas échéant (par exemple pour avoir un style similaire à [pygments](https://pygments.org/) `--syntax-highlighting=pygments`, qui est d'ailleurs le style pas défaut si on ne précise rien) ; à noter que le style CSS fournit peut surcharger le rendu initial.
- si on souhaite avoir une table des matières (`--toc`)
- si on souhaite avoir une numérotation des sections  (`--number-sections`)
- si on souhaite que le code LaTeX inline soit correctement rendi il faut utiliser l'option `--mathjax` (et dans le `<head>` de template on doit avoir un `$math$`)
- `test-file.md` est le fichier Markdown que nous cherchons à transformer
- `-o test-file.html` indique le fichier de sortie résultat de la conversion

Avec les fichiers `test-file.md` (disponible [ici](./md-html-pdf/test-file.html)), `style.css` (disponible [ici](./md-html-pdf/style.css)) et `template-pandoc.html` (disponible [ici](./md-html-pdf/template-pandoc.html)), on obtient un document HTML plutôt propre (disponible [ici](./md-html-pdf/test-file.html))

Seul le code du diagramme Mermaid inséré directement dans le markdown n'est pas converti directement en une image. 
En fait c'est normal, il faut ajouter un [filtre supplémentaire](https://github.com/pandoc-ext/diagram) en [Lua](https://www.lua.org/). Il est également nécessaire d'avoir [Mermaid CLI](https://github.com/mermaid-js/mermaid-cli) dans le `PATH`.

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --mathjax --syntax-highlighting pygments -c style.css --lua-filter diagram.lua --extract-media=media -o test-file.html
```

Comme l'indique, la documentation, il faut ajouter l'option `--extract-media=media` pour que l'image générée à partir du diagramme Mermaid soit créée sur le disque et puisse être liée dans la page HTML.

Sous Windows, j'ai eu des difficultés pour que le script Lua trouve la CLI `mmdc`. Il a été nécessaire que j'ajoute les lignes suivantes dans le `front-matter` YAML de mon fichier Markdown. Et là j'avoue que GitHub Copilot en mode Ask a été bien utile pour m'aider à trouver quels étaient problèmes et comment les résoudre rapidement !

```yaml
diagram:
  engine:
    mermaid:
      execpath: [cmd.exe, /d, /c, mmdc.cmd]
```

Dans le cadre de ce répertoire, j'ai recopié le filter en Lua mais il provient sans modification de [Diagram Generator](https://github.com/pandoc-ext/diagram)

Maintenant que nous avons le fichier HTML, convertissons le en PDF avec Chrome.

```bash
Chrome --headless --disable-gpu --no-pdf-header-footer --print-to-pdf="/chemin/complet/vers/fichier/test-file.pdf" "/chemin/complet/vers/fichier/test-file.html"
```

Il faut indiquer les chemins complets vers le fichier source que l'on transforme et le fichier cible résultat.
Bien sûr l'option `--headless` est nécessaire pour ne pas démarrer Chrome sans que la fenêtre du navigateur ne soit lancée.
L'option `--no-pdf-header-footer` permet de ne pas avoir les entêtes et pieds de page classique avec la date et le numéro de page, qu'on ne veut pas avoir en général dans le PDF généré.

Pour un meilleur rendu des caractères Unicode et des emojis éventuels, il faut éventuellement installer des fontes supplémentaires ; pour ma part j'ai installé les fontes suivantes :

- https://fonts.google.com/noto/specimen/Noto+Sans
- https://fonts.google.com/noto/specimen/Noto+Emoji
- https://fonts.google.com/specimen/Cascadia+Code

En synthèse, les 2 lignes à lancer sont les suivantes

```bash
pandoc test-file.md --template template-pandoc.html --toc --number-sections --mathjax --syntax-highlighting pygments -c style.css -o test-file.html
Chrome --headless --disable-gpu --no-pdf-header-footer --print-to-pdf="C:\Users\cvaudry\Documents\Perso\Workspace\devtoolbox\misc\md-2-pdf\test-file.pdf" "C:\Users\cvaudry\Documents\Perso\Workspace\devtoolbox\misc\md-2-pdf\test-file.html"
```



Au final, le rendu PDF est _correct_ (le document est lisible et il n'y a pas d'erreurs de rendu) mais les documents générés ne sont pas _visuellement beaux et agréables_ même avec un fichier de style CSS et un fichier de template HTML.

A partir de ce constat, les pistes à investiguer pour améliorer le rendu étaient :

- Travailler le fichier de style CSS pour que le rendu finale soit meilleur
- Essayer avec [weasyprint](https://weasyprint.org/) et/ou [wkhtmltopdf](https://wkhtmltopdf.org/) plutôt que Chrome
- Essayer en passant par LaTeX pour générer le PDF.
  - Sur Windows, cela implique d'installer une version de LaTeX (par exemple [MikTeX](https://miktex.org/)) et de s'assurer qu'il est bien dans le chemin d'exécution. 

## Utilisation de weasyprint

Etant un utilisateur occasionnel de Python, j'en avais déjà une version sur ma machine et j'ai essayé [weasyprint](https://weasyprint.org/).
L'installation via Python est classique via `pip`: `pip install weasyprint`
Cependant sous Windows, il faut _installer_ **GTK** pour que **weasyprint** fonctionne correctement
Donc téléchargement du [runtime GTK pour Windows](https://github.com/tschoonj/GTK-for-Windows-Runtime-Environment-Installer/releases).
Une fois l'installation effectuée, il faut ajoutez le répertoire `bin` au `PATH` Windows.
Pour vérifier l'installation de GTK:

- Système Unix : `where libgobject-2.0-0.dll`
- Windows avec Powershell si vous avez effectué l'installation sous `C:\Outils\misc` : `Get-ChildItem -Recurse "C:\Outils\misc" -Filter libgobject-2.0-0.dll`

Pour tester **weasyprint** une fois qu'il a été installé via `pip`: `weasyprint --info` 

Néanmoins, en plus de l'installation duruntime GTK, sur ma version de Windows j'ai été obligé d'installer la version **59** de Weasyprint plutôt que la dernière version : `pip install weasyprint==59.0`
En conséquence, il a également fallu que j'installe une version adaptée de `pydyf`

- désinstallation de `pydyf` s'il était déjà installé par ailleurs `pip uninstall pydyf`
- installation de la version _ compatible avec la version **59** de **weasyprint** : `pip install pydyf==0.6.0`

Mais je n'étais pas au bout de mes peines !
J'ai eu des erreurs liées au fontes `Fontconfig error: Cannot load default config file`.
Pour régler ce problème-là, il faut ajouter une variable d'environnement `FONTCONFIG_PATH`.
Sous PowerShell pour faire un ajout temporaire on peut faire `$env:FONTCONFIG_PATH="C:\Outils\Misc\GTK3-Runtime Win64\etc\fonts"` dans un shell de commande PowerShell (à ajuster avec le réperoire d'installation du runtime GTK, dans l'exemple précédent c'était `"C:\Outils\Misc\GTK3-Runtime Win64"`.

Pour un ajout plus permanent de la variable d'environnement sous en allant l'ajouter directement aux variables d'environnement système via l'interface graphique soit avec PowerShell directement :

```powershell
:SetEnvironmentVariable(
    "FONTCONFIG_PATH",
    "C:\Outils\Misc\GTK3-Runtime Win64\etc\fonts",
    "User"
)
```
Le pire c'est qu'au final **weasyprint 59** ne supporte pas toutes les fonctionnalités Flexbox/Grid modernes et que le rendu n'est pas mieux qu'avec Chrome.
Après beaucoup des faire et trop de temps perdu avec l'option **weasyprint**, j'ai jeté l'éponge et me suis dit que j'allais essayer autre chose.

## Utilisation de LaTeX

J'ai eu peur que de me lancer dans l'amélioration du CSS et du template soit chronophagae pour un rendu qui au final ne me satisferait pas. 
De manière similaire, je me suis dit que d'explorer la piste de [wkhtmltopdf](https://wkhtmltopdf.org/) ne m'apporterait pas grand chose de plus par rapport à la solution avec Chrome.

Il me restait donc à explorer la solution se basant sur LaTeX.

Sous Windows, le plus simple est d'installer MikTeX qui est également disponible pour les plateformes Linux et MacOs.
L'installation de MikTeX n'est pas compliqué mais prend un peu de temps et de place sur votre disque dur.

En cherchant un peu, pour avoir un rendu de bonne qualité, j'ai utilisé des templates et plus précisément j'ai installé les templates [_Eisvogel_](https://github.com/wandmalfarbe/Pandoc-latex-template).
Pour l'installation j'ai suivi la procédure d'installation des templates décrite dans le README.
Choix de Lualatex
Attention aux diagrammes mermaids qui doivent être externes au fichier Markdown.
Installation nécessaire des fontes
Attention avec les Emojis et certains caractères unicodes, qui peuvent ne pas être présents dans les fontes : cela peut demander de rentrer dans le LaTex et l'installation de fonte.
Mise en place d'un front matter yaml avec des métadonnées
Durée de conversion sur une grosse base documentaire

- Finalement après pas mal d'efforts je suis arrivé à une solution fonctionnelle et satisfaisante en termes de rendu du document avec LaTeX.
  - Par contre, il ne faut pas d'emoji dans le document, c'est mal géré par LaTeX (même si cela passe bien en HTML)
- Au final, j'ai également séparé la génération du HTML et du PDF dans 2 scripts distincts
- La génération des PDF prend un certain temps (c'est un peu long)
- Parler des limites
