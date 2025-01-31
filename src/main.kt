fun main() {
    val persona1 = Persona("Julia", 64.7, 1.72)
    val persona2 = Persona("Carlos", 80.0, 1.80)
    val persona3 = Persona("Ana", 60.0, 1.65)
    val persona4 = Persona("Luis", 90.0, 1.85)
    val persona5 = Persona("María", 55.0, 1.60)

    val personas = listOf(persona1, persona2, persona3, persona4, persona5)

    for (persona in personas) {
        println(persona.saludar())
        println(persona.obtenerDesc())
        println()
    }
}