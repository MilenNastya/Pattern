fun main() {
    val students = mutableListOf<Student>()

    // Примеры создания студентом на основе предоставленных данных
    students.add(Student("Milen", "Nastya", "Romanovna"))
    students.add(Student("Krivosheev", "Ilia", "Vladivirovich", Telegram = "@IlyaVladimirovich00"))
    students.add(Student("Milen", "Nastya", "Romanovna", Phone = "+79181130942"))
    students.add(Student("Likova", "Karoline", "Dmitrievna", Email = "karolina@gmail.com"))
    students.add(Student("Malishev", "Denis", "Araratovich", Telegram = "@dmmvrs", Phone = "+79298491211"))
    students.add(Student(hashMapOf(
        "surname" to "Milenchenko",
        "name" to "N",
        "patronymic" to "Romanovna"
    )))

    students.forEach { student ->
        println(student)
    }
}

