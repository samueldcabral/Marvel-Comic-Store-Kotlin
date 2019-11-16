# Marvel Comicbook Store

This is a Comicbook store app using the Marvel Api ( [Checkout at developer.marvel.com](https://developer.marvel.com/) )

## Project goal, language and resources

1- Create an Android APP using Kotlin

2- Use Retrofit for the API Call

3- Use Picasso library for fetching images from the web

## Usage

After cloning this repo, you must create a Config.kt file as follows:

```Kotlin
package br.edu.ifpb.phoebus_marvel_store.config

open class Config {

    class Keys{
        companion object {
            const val PUBLIC_KEY = "REPLACE_WITH_YOUR_PUBLIC_KEY"
            const val PRIVATE_KEY = "REPLACE_WITH_YOUR_PRIVATE_KEY"
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


