# DSE XML Library 🎨

A **DSE XML Library** é uma biblioteca Android desenvolvida para facilitar a integração de componentes e recursos XML reutilizáveis. Ela centraliza elementos visuais para acelerar o desenvolvimento e garantir a padronização entre diferentes aplicações.

---

## 📝 Sobre

A `dse-xml` fornece componentes de interface e recursos prontos, permitindo que o time foque na lógica de negócio enquanto mantém uma identidade visual consistente e fácil de manter.

## 🚀 Instalação

Siga os passos abaixo para adicionar a biblioteca ao seu projeto via **JitPack**.

### 1. Adicione o repositório JitPack

No seu arquivo `settings.gradle.kts` (**nível de projeto**), certifique-se de que o JitPack está incluído:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("[https://jitpack.io](https://jitpack.io)") } // Adicione esta linha
    }
}
```

### 2. Adicione a dependência

No arquivo build.gradle.kts do seu módulo app, adicione a seguinte linha nas dependências:
```kotlin
dependencies {
    implementation("com.github.Squad-01-App-Noticias:dse-xml:v1.0.2")
}
```

> ⚠️ Importante: Sempre verifique a versão mais recente diretamente no JitPack.
> https://jitpack.io/#Squad-01-App-Noticias/dse-xml

### 3. Sincronize o projeto

Após as alterações, clique em "Sync Now" no Android Studio ou execute o comando abaixo no terminal:

```kotlin
./gradlew build
```
---

### Tecnologias Utilizadas
* Linguagem: XML e Kotlin
* Build System: Gradle (Kotlin DSL)
* Distribuição: https://jitpack.io/
