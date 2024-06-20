# Pokédex Android App

Esta é uma aplicação Android de Pokédex que permite buscar e listar Pokémon usando a API do Pokémon.

## Funcionalidades

- Buscar Pokémon por nome ou número.
- Listar todos os Pokémon com detalhes.
- Visualizar informações detalhadas de cada Pokémon.

## Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **Build System:** Gradle
- **Arquitetura:** MVVM (Model-View-ViewModel)
- **API:** [PokéAPI](https://pokeapi.co/)

## Bibliotecas

O projeto utiliza as seguintes bibliotecas:

- **AGP (Android Gradle Plugin):** 8.5.0
- **Kotlin:** 1.9.0
- **Core KTX:** 1.13.1
- **JUnit:** 4.13.2
- **AndroidX JUnit:** 1.1.5
- **Espresso Core:** 3.5.1
- **AppCompat:** 1.7.0
- **Material Components:** 1.12.0
- **Activity KTX:** 1.9.0
- **ConstraintLayout:** 2.1.4

### Configuração das Bibliotecas no `build.gradle.kts`

```kotlin
dependencies {
    implementation("androidx.core:core-ktx:$coreKtx")
    implementation("androidx.appcompat:appcompat:$appcompat")
    implementation("com.google.android.material:material:$material")
    implementation("androidx.activity:activity-ktx:$activity")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayout")
    testImplementation("junit:junit:$junit")
    androidTestImplementation("androidx.test.ext:junit:$junitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCore")
}

plugins {
    id("com.android.application") version "$agp"
    id("org.jetbrains.kotlin.android") version "$kotlin"
}
```

## Guia de Configuração e Contribuição do Projeto Android

### Clone o Repositório

```bash
git clone https://github.com/joaovflorisvaldo/pokedex.git
cd pokedex
```
#### Abra o Projeto no Android Studio

1. Selecione a opção "Open an existing project".
2. Navegue até o diretório clonado e selecione-o.

#### Compile e Execute o Aplicativo

1. Conecte um dispositivo Android ou use um emulador.
2. Clique no botão "Run" (ou use o atalho `Shift + F10`).

#### Estrutura do Projeto

- **app**: Contém o código-fonte da aplicação.
- **gradle**: Arquivos e scripts de configuração do Gradle.
- **.gradle**: Arquivos de cache e outros dados temporários do Gradle.
- **build.gradle.kts**: Configurações de build do projeto.
- **gradle.properties**: Propriedades de configuração do Gradle.
- **settings.gradle.kts**: Configurações dos projetos incluídos no build.
- **pokedex.apk**: Pacote instalável do Android (APK) da aplicação.

### Autores

- [João Vitor Florisvaldo Vieira](https://github.com/joaovflorisvaldo)

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
