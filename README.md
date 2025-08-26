# 🎵 Mini Player - Sistema de Streaming de Mídias Sonoras
Projeto desenvolvido em Java para a disciplina de Programação Orientada a Objetos, simulando as funcionalidades básicas de uma plataforma de streaming de músicas.
<br>
<br>

## 📋 Funcionalidades

### 👤 Sistema de Usuários:
- Cadastro de usuários com nome e e-mail
- Login no sistema
- Gerenciamento personalizado de playlists
<br>

### 🎵 Catálogo de Mídias:
- Diferentes tipos de mídia: Músicas, Podcasts e Audiobooks
- Busca por título, artista ou gênero
- Catálogo centralizado com todas as mídias disponíveis
<br>

### 📝 Playlists Personalizadas:
- Criação e gerenciamento de playlists
- Adição e remoção de mídias
- Cálculo automático da duração total
- Visualização organizada do conteúdo
<br>

### 🎼 Gêneros Musicais:
- Sistema de enumeração para gêneros: ROCK, POP, MPB, JAZZ, CLASSICA, ELETRONICA, RAP, PODCAST, AUDIOBOOK
<br>

## 🛠️ Tecnologias e Conceitos Utilizados:

- **Java POO**: Implementação dos pilares da Orientação a Objetos
- **ArrayList**: Estrutura de dados principal para armazenamento
- **Tratamento de Exceções**: Exceções personalizadas para erros específicos
- **Loop For**: Iterações sobre coleções
- **Try-Catch**: Manipulação de erros e entradas inválidas
<br>

## 🏗️ Estrutura do Projeto

```
src/
├── exceptions/
│   ├── PlaylistNotFoundException.java
│   ├── MediaNotFoundException.java
│   └── UserNotFoundException.java
├── model/
│   ├── Genero.java
│   ├── Media.java (classe abstrata)
│   ├── Musica.java
│   ├── Podcast.java
│   ├── Audiobook.java
│   ├── Usuario.java
│   ├── Playlist.java
│   └── Catalogo.java
└── Main.java
```
<br>

## ⚙️ Como Executar

1. Clone o repositório:
```bash
git clone [url-do-repositorio]
```

2. Compile os arquivos Java:
```bash
javac -d bin src/*.java src/exceptions/*.java src/model/*.java
```

3. Execute o programa:
```bash
java -cp bin Main
```
<br>

## 🎯 Principais Conceitos de POO Implementados

### 🔒 Encapsulamento:
- Atributos privados com métodos públicos de acesso (getters/setters)
- Controle de acesso aos dados internos das classes

### 📐 Herança:
- Classe abstrata `Media` como base para `Musica`, `Podcast` e `Audiobook`
- Reutilização de código e hierarquia lógica

### 🔄 Polimorfismo:
- Sobrescrita do método `toString()` nas subclasses
- Tratamento uniforme de diferentes tipos de mídia

### 🗂️ Abstração:
- Classe `Media` abstrata define estrutura comum
- Métodos abstratos implementados nas classes concretas
<br>

## 🚦 Fluxo do Programa

1. **Inicialização**: Carregamento de mídias e usuário demo
2. **Menu Principal**: Login, cadastro ou visualização do catálogo
3. **Menu do Usuário**: Gerenciamento de playlists e buscas
4. **Gerenciamento de Playlists**: Criação, edição e visualização
5. **Catálogo**: Navegação e adição de mídias às playlists
<br>

## 🔍 Destaques de Implementação

### Tratamento de Exceções
```java
public Playlist getPlaylist(String nome) throws PlaylistNotFoundException {
    for (Playlist playlist : playlists) {
        if (playlist.getNome().equalsIgnoreCase(nome)) {
            return playlist;
        }
    }
    throw new PlaylistNotFoundException("Playlist não encontrada: " + nome);
}
```
<br>

### Polimorfismo e Herança
```java
public abstract class Media {
    // Atributos e métodos comuns
    public abstract String toString();
}

public class Musica extends Media {
    @Override
    public String toString() {
        return super.toString() + " [Álbum: " + album + "]";
    }
}
```
<br>

### Interface de Usuário
- Menus interativos com tratamento de entradas inválidas
- Formatação de tempo (minutos:segundos)
- Visualização organizada de playlists e mídias
<br>

## 📊 Funcionalidades Técnicas

- [x] Cadastro e login de usuários
- [x] Diferentes tipos de mídia (herança)
- [x] Gerenciamento completo de playlists
- [x] Sistema de buscas no catálogo
- [x] Cálculo de duração total das playlists
- [x] Tratamento robusto de erros
- [x] Interface de usuário intuitiva
<br>
