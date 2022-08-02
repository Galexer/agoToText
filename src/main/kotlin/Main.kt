package ru.netology

fun main() {
    val lastTimeOnlineInSec = 800
    println(agoToText(lastTimeOnlineInSec))
}

fun agoToText(lastTimeOnline : Int): String {
    val sec60 = 60
    val hour = 60 * 60
    val day = hour * 24
    val toMin = lastTimeOnline / sec60
    val toHours = lastTimeOnline / hour

    return when(lastTimeOnline) {
        in 0..sec60 -> "был(а) только что"
        in sec60 + 1 .. hour -> "был(а) в сети $toMin ${minMaker(toMin)} назад"
        in hour + 1 .. day -> "был(а) в сети $toHours ${hourMaker(toHours)} назад"
        in day + 1 .. 2 * day -> "был(а) сегодня"
        in 2 * day + 1 .. 3 * day -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun minMaker(min : Int) : String {
    return when(min){
        1 -> "минута"
        in 2 .. 4 -> "минуты"
        in 5 .. 19 -> "минут"
        else -> {
            when (min.toString()[min.toString().length - 1]) {
                '1' -> "минута"
                in '2'..'4' -> "минуты"
                else -> "минут"
            }
        }
    }
}

fun hourMaker(hour : Int) : String {
    return when(hour) {
        1, 21 -> "час"
        in 2..5, in 22..24 -> "часа"
        else -> "часов"
    }
}