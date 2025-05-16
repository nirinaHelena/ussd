# USSD  [![Build Status](https://img.shields.io/badge/build-success-brightgreen)]()

Instructions pour configurer et lancer le projet localement.

## Prérequis

- Java 17
- Gradle (optionnel, le wrapper est fourni)

## Installation

1. **Vérifier les outils installés**  
   Exécutez ces commandes dans un terminal :
   ```bash
   java -version
   gradle -v  # Optionnel
2. **Se placer dans le dossier du projet**  
   ```bash
   cd mon-projet
   ```

## Utilisation

### Build du projet
```bash
./gradlew build          # Linux/Mac
gradlew.bat build        # Windows
```

### Lancer l'application
```bash
./gradlew bootRun        # Linux/Mac
gradlew.bat bootRun      # Windows
```

### Ouvrir dans un IDE
- **IntelliJ** : `File > Open` (sélectionnez le dossier du projet)
- **VSCode** : Ouvrez le dossier puis importez via `build.gradle`
