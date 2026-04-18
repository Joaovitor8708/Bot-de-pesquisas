# Bot Futebol Humano - Microsoft Rewards Automator ⚽🤖

Este é um script de automação desenvolvido em Java utilizando Selenium WebDriver para realizar pesquisas automáticas no buscador Microsoft Bing. O diferencial deste bot é o comportamento "humano", projetado para ajudar no acúmulo de pontos do programa Microsoft Rewards de forma natural.

## 🚀 Funcionalidades

- **Pesquisas Dinâmicas:** Utiliza listas de times e jogadores de futebol para gerar milhares de combinações de busca.
- **Simulação de Digitação Humana:** O bot não "cola" o texto; ele digita caractere por caractere com intervalos aleatórios.
- **Intervalos Randômicos:** Pausas entre as pesquisas para evitar a detecção por comportamento robótico.
- **Suporte a Múltiplas Categorias:** Alterna entre buscas sobre atletas e clubes.

## 🛠️ Tecnologias Utilizadas

- **Java** (JDK 21)
- **Selenium WebDriver** (Automação de browser)
- **EdgeDriver** (Navegador Microsoft Edge)

## 📁 Estrutura de Arquivos

Para o bot funcionar, ele espera a seguinte estrutura de pastas:
```text
.
├── src/main/java/org/example/
│   └── BotFutebolHumano.java
├── dados/
│   ├── times.txt
│   └── jogadores.txt
├── pom.xml           
└── README.md
```
## ⚙️ Como Configurar

1. **WebDriver:** Baixe o `msedgedriver.exe` compatível com a sua versão do Edge.
2. **Caminho do Driver:** No código, ajuste o `System.setProperty` para o local do seu `.exe`.
3. **Execução:** Compile e rode a classe `BotFutebolHumano`.

## ⚠️ Aviso Legal
Este projeto tem fins estritamente educacionais para estudo de automação com Selenium. O uso de bots pode violar os Termos de Serviço do Microsoft Rewards. Use por sua conta e risco.
