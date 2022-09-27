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
3. Open command prompt in folder and run command.
```bach
java -jar XOREncrypt-1.0.jar
```
4. Enjoy the encryption program. 😎

## How to use this app
There is 4 files: input.txt, encryption.data, output.txt and key.properties. Files are generated automaticly.
First of all you need to paste some text or data in `input.txt`, after that program will ask you for key word for example `crocodile.` Key word can be saved in `key.properties` file and store in somekind of storage. 
Next program will ask to select encrypting or decrypting. Make sure that files aren't empty. Once selected, the program will start encryption and decryption based on your selection.

If you selected encryption output will be in `encryption.data` file but if you seleced decryption output will be in `output.txt` file.

For all functions you need key word that can be stored in `key.properties` file or manually on piece of paper.

## What is XOR
XOR is one of the best encryption that use special key word. The XOR encryption algorithm is an example of symmetric encryption where the same key is used to both encrypt and decrypt a message.

More information about XOR encryption you can read on this [page](https://www.101computing.net/xor-encryption-algorithm/).

## Contributing
Pull requests are always welcome. For bigger changes, please open an issue first to discuss what you would like to change.

## To Do
- [ ] Add gui using JFrame where you can manage everything

## License
[GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/)
