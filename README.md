# XOREncrypt
Simple lightweight java program that encrypt and decrypt text file using XOR encrypter

## Table of Contents

1. [Download & Instalation](#download--instalation)
2. [Usage](#how-to-use-this-app)
3. [XOR explenation](#what-is-xor)
4. [Contributing](#contributing)
5. [To Do](#to-do)
6. [License](#license)


## Download & Instalation
1. Download java 16 [here](https://adoptium.net/temurin/releases/?version=16).
2. Download latest version in [releases](https://github.com/BoyBACKS/XOREncrypt/releases) tab.
3. Open command prompt in folder and run command below or use `start.bat` file included in zip folder.
```bach
java -jar XOREncrypt-1.0.jar
```
4. Put files in folders.
5. Enjoy the encryption program. 😎

## How to use this app
Program will automatically create 3 folders `input`, `encrypt`, `output`.
After starting you can put files inside folders, for encryption put files in `input` folder and encrypted file will pop up in
`encrypt` folder, for decryption put files ex. `fileExtension-xOrƎ-fileName.XORe` in `encrypt` folder and 
decrypted file will pop up in `output` folder.

All encryption and decryption processes requiring encryption key word which you can enter or use file `key.properties`,
program will also ask you if you want to save key word in to a file.

For all functions to work correctly you will need a key word that can be stored in `key.properties` file or manually on piece of paper.

## What is XOR
XOR is one of the best encryption that use special key word. The XOR encryption algorithm is an example of symmetric encryption where the same key is used to both encrypt and decrypt a message.

More information about XOR encryption you can read on this [page](https://www.101computing.net/xor-encryption-algorithm/).

## Contributing
Pull requests are always welcome. For bigger changes, please open an issue first to discuss what you would like to change.

## To Do
- [ ] Add gui using JFrame where you can manage everything
- [ ] Multithreading
- [ ] Calculating encryption process

## License
[GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/)
