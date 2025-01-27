package main.kotlin

import kotlin.random.Random

fun main() {
    val lista = listOf(
        "limon", "fresa", "sandia", "platano", "melon",
        "uva", "kiwi", "naranja", "piña", "pera", "cereza"
    )
    val listaAleatoria = lista[Random.nextInt(lista.size)]

    val palabraOculta = MutableList(listaAleatoria.length) { '*' }
    val rm= ReproductorMidi("SevenNationArmy.mid")
    var intentos = 6
    println()
    println("Cargando juego , espera ...")
    Thread.sleep(1000)
    DibujoAhorcado.dibujar(1)
    println()
    println("Bienvenido al ahorcado ,tienes $intentos intentos para adivinar una fruta")
    println()

    while (intentos > 0) {
        println("Tu fruta es: ${palabraOculta.joinToString("")}")

        print("Introduce tu letra: ")
        val adivinando = readln().lowercase()
        if (adivinando.length != 1) {
            println("Escribe solo una letra")
            continue
        }

        val letra = adivinando[0]

        if (letra in listaAleatoria) {
            for (i in listaAleatoria.indices) {
                if (listaAleatoria[i] == letra) {
                    palabraOculta[i] = letra
                }
            }
            println("Si! la letra $letra esta en la palabra.")
        } else {
            intentos--
            println("No! cuidado solo te quedan $intentos intentos.")
            DibujoAhorcado.dibujar(7 - intentos)
        }

        if (!palabraOculta.contains('*')) {
            println("Felicidades la fruta era: $listaAleatoria")
            break
        }
    }

    if (intentos == 0) {
        println("DEP. La fruta era: $listaAleatoria")
    }
}
