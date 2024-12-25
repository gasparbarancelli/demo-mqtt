### Comandos maven para gerar executavel nativo com a GraalVM

Os comandos a seguir geram os executaveis nativos dentro da pasta target.

```shell
mvn package -Pnative -DmainClass=com.gasparbarancelli.Subscriber -DimageName=subscriber

mvn package -Pnative -DmainClass=com.gasparbarancelli.Publisher -DimageName=publisher
```

### Comando para incializar a aplicação subscriber

Acesse a pasta target do projeto e execute o comando a seguir:

```shell
./subscriber
```

### Comando para iniciar a aplicação publisher e enviar algumas mensagens

Acesse a pasta target do projeto e execute os comandos a seguir:

```shell
./publisher

./publisher gasparbarancelli.com

./publisher 'Feliz Natal!!!'
```
