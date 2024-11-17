fun main() {
    val students = mutableListOf<Student>()

    // Примеры создания студентов на основе предоставленных данных
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

    println(Student(hashMapOf("name" to "N", "surname" to "Milenchenko", "patronymic" to "Romanovna")).validate())
    println(Student("Malishev", "Denis", "Araratovich", Telegram = "@dmmvrs", Phone = "+79298491211").validate())

    val stud = Student("Malishev", "Denis", "Araratovich", Telegram = "@dmmvrs", Phone = "+79298491211")
    stud.setContacts(hashMapOf("Telegram" to "@dmmvrs", "gitHub" to null))
    println(stud)
}