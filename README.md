# Marvel Comicbook Store

This is a Comicbook store app using the Marvel Api ( [Checkout at developer.marvel.com](https://developer.marvel.com/) ) .

## Personal thoughts

This was a very interesting app to build. Lots of challenges specially working with Marvel Api. It's overwhelming at first because you have to deal
with Public and Private keys, also you must generate a md5 checksum in order to make the api call.
It was interesting to work with Retrofit and Picasso.
Lots of new ideas to improve this app and to developer others.

## Built with

1- Android Kotlin

2- Retrofit for the API Call

3- Picasso library to fetch images from the web

## Usage

After cloning this repo, you must set your public and private keys in the Config class inside the config package:

```Kotlin
package br.edu.ifpb.phoebus_marvel_store.config

open class Config {

    class Keys{
        companion object {
            const val PUBLIC_KEY = "YOUR_PUBLIC_KEY"
            const val PRIVATE_KEY = "YOUR_PRIVATE_KEY"
        }
    }
}

```

### Tasks

| Exercicio | Status| Emoji
| ------------- |:-------------:|:-----------:|
| Fetching data from Marvel Api with Retrofit     | Done | :fire: |
| Fetching images from Marvel Api with Picasso      | Done | :fire: |
| Selecting itens from the list and sending data to another activity      | Done | :fire: |
| Randomizing 12% of the Api results to be of type Rare      | Done | :fire: |
| Normal and Rare coupons for 10% and 25% off respectively     | To do  | :gear: |


### Screenshots

Logo

![Logo](https://i.imgur.com/FuruIL4.jpg "Logo")

Main page

![Main page](https://i.imgur.com/T3pKrtF.jpg "Main page")

Selected items

![Selected items](https://i.imgur.com/EfjvRdZ.jpg "Selected items")

Checkout page

![Checkout page](https://i.imgur.com/wX1EHkW.jpg/ "Checkout page")


## License

This project is licensed under the MIT License