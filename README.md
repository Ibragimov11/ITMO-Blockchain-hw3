#  Описание проекта

### Конфигурация

В файле `config.json` пропишите ваш вебсокет адрес ноды и необходимые адреса оракулов.

```json
{
  "node_url": "YOUR NODE WEBSOCKET ADDRESS",
  "abi" : {
    "ETH_USD": "0x37bC7498f4FF12C19678ee8fE19d713b87F6a9e6",
    "LINK_ETH": "0xbba12740DE905707251525477bAD74985DeC46D2",
    "USDT_ETH": "0x7De0d6fce0C128395C488cb4Df667cdbfb35d7DE"
  }
}
```

### Сборка
Для сборки необходимо выполнить
* `./gradlew distZip` на Linux или MacOS
* `gradlew distZip` на Windows

### Запуск
Извлечь содержимое архива и вызвать скрипт в папке `bin`.

### Пример лога

```
New block: ts=1667523287, number=15893200, hash=0x368c091a1adf0604099ae022f0a82234c7027dbd8c5ef62f76bc01599ec88ecb 
New block: ts=1667523299, number=15893201, hash=0x23579e9c1a7ee5bfe1c5a00b189ea4022f0cb52c71f03f1d2581d4fe3736a721 
New block: ts=1667523311, number=15893202, hash=0x96422e868609594bd3168b7e53c937faea157a66cdf70b53d1dd7ff9b4df9ba6 
New block: ts=1667523323, number=15893203, hash=0x26415ca36e38e903100ffbed8ebdd390d493eb7f7ae47588ee970a29a1170d8d 
Contract ETH_USD is updated: ts=1667523335, current=153948977591, roundId=36220 
New block: ts=1667523335, number=15893204, hash=0x2263b095f9e4f564b8fe7ca5edfd6504a3522f3e02288b4c550a243b79a7e61e 
New block: ts=1667523347, number=15893205, hash=0x05e17c1587e3ad0d1933ee386b123c33a8cfb795056e4c32b4d817fb0c4e11db 
New block: ts=1667523359, number=15893206, hash=0xa317fee43fa63074b69a57eec106dccf4177167c52496664b00008628507f6a3 ```
```