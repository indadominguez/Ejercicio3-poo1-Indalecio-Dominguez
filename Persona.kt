enum class RangoIMC {
    PESO_INSUFICIENTE,
    PESO_SALUDABLE,
    SOBREPESO,
    OBESIDAD
}

class Persona(
    var nombre: String?,
    var peso: Double,
    var altura: Double
) {
    val imc: Double
        get() = peso / (altura * altura)

    constructor(peso: Double, altura: Double) : this("Desconocido", peso, altura)

    fun saludar(): String {
        return "¡Hola, soy $nombre!"
    }

    fun alturaEncimaMedia(): Boolean {
        return altura >= 1.75
    }

    fun pesoEncimaMedia(): Boolean {
        return peso >= 70
    }

    fun obtenerDescImc(): RangoIMC {
        return when {
            imc < 18.5 -> RangoIMC.PESO_INSUFICIENTE
            imc in 18.5..24.9 -> RangoIMC.PESO_SALUDABLE
            imc in 25.0..29.9 -> RangoIMC.SOBREPESO
            else -> RangoIMC.OBESIDAD
        }
    }

    fun obtenerDesc(): String {
        val rangoImc = obtenerDescImc()
        return "$nombre con una altura de $altura m (${if (alturaEncimaMedia()) "Por encima de la media" else "Por debajo de la media"}) " +
                "y un peso de $peso kg (${if (pesoEncimaMedia()) "Por encima de la media" else "Por debajo de la media"}) " +
                "tiene un IMC de %.2f (${rangoImc.name.replace('_', ' ')})".format(imc)
    }

    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso kg, Altura: $altura m, IMC: ${"%.2f".format(imc)}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        other as Persona
        return peso == other.peso && altura == other.altura
    }

    override fun hashCode(): Int {
        return (peso * 31 + altura).toInt()
    }
}