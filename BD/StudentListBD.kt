package main.kotlin

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

// Определяем модель данных Student
data class Student(
    val id: Int? = null,
    val name: String? = null,
    val surname: String? = null,
    val patronymic: String? = null,
    val phoneNumber: String? = null,
    val gitHub: String? = null,
    val email: String? = null,
    val telegram: String? = null
)

class StudentsListDB {

    // Поле для соединения с базой данных
    private lateinit var connection: Connection

    // Инициализация соединения
    init {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234" // Убедитесь, что логин и пароль совпадают с вашим PostgreSQL
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Функция для выполнения SQL-запросов, ожидающих ResultSet
    private fun executeSqlSelect(query: String): ResultSet? {
        return try {
            connection.createStatement().executeQuery(query)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // Функция для выполнения SQL-запросов на выполнение (INSERT, UPDATE, DELETE)
    private fun executeSql(query: String) {
        try {
            connection.createStatement().executeUpdate(query)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun executeQuery(query: String): ResultSet? {
        return try {
            val stmt = connection.createStatement()
            stmt.executeQuery(query)
        } catch (e: Exception) {
//            e.printStackTrace()
            null
        }}

    // Получение студента по ID
    fun getStudentById(id: Int): Student? {
        val query = "SELECT * FROM student WHERE id = $id"
        val result = executeSqlSelect(query)
        return result?.let {
            if (it.next()) {
                val student = Student(
                    id = it.getInt("id"),
                    name = it.getString("name"),
                    surname = it.getString("surname"),
                    patronymic = it.getString("patronymic"),
                    phoneNumber = it.getString("phoneNumber"),
                    gitHub = it.getString("gitHub"),
                    email = it.getString("email"),
                    telegram = it.getString("telegram")
                )
                it.close()
                student
            } else {
                null
            }
        }
    }

    // Получение K студентов, начиная с N
    fun getKStudents(n: Int, k: Int): List<Student> {
        val offset = (n - 1) * k
        val query = "SELECT * FROM student ORDER BY id OFFSET $offset LIMIT $k"
        val result = executeSqlSelect(query)
        val studentsList = mutableListOf<Student>()
        result?.use { rs ->
            while (rs.next()) {
                studentsList.add(
                    Student(
                        id = rs.getInt("id"),
                        name = rs.getString("name"),
                        surname = rs.getString("surname"),
                        patronymic = rs.getString("patronymic"),
                        phoneNumber = rs.getString("phoneNumber"),
                        gitHub = rs.getString("gitHub"),
                        email = rs.getString("email"),
                        telegram = rs.getString("telegram")
                    )
                )
            }
        }
        return studentsList
    }

    // Добавление нового студента
    fun addStudent(student: Student) {
        var input = "'${student.surname}', '${student.name}', '${student.patronymic}'"
        if(student.phoneNumber==null){input+=", NULL"}
        else{input+=", '${student.phoneNumber}'"}
        if(student.telegram==null){input+=", NULL"}
        else{input+=", '${student.telegram}'"}
        if(student.email==null){input+=", NULL"}
        else{input+=", '${student.email}'"}
        if(student.gitHub==null){input+=", NULL"}
        else{input+=", '${student.gitHub}'"}
        executeQuery("INSERT INTO student (surname, name, patronymic, phoneNumber, telegram, mail, git) VALUES (${input})")
    }


    // Обновление информации о студенте
    fun updateStudent(id: Int, student: Student) {
        var input = "'${student.surname}', '${student.name}', '${student.patronymic}'"
        if(student.phoneNumber==null){input+=", NULL"}
        else{input+=", '${student.phoneNumber}'"}
        if(student.telegram==null){input+=", NULL"}
        else{input+=", '${student.telegram}'"}
        if(student.email==null){input+=", NULL"}
        else{input+=", '${student.email}'"}
        if(student.gitHub==null){input+=", NULL"}
        else{input+=", '${student.gitHub}'"}
        executeQuery("UPDATE student SET (surname, name, patronymic, phoneNumber, telegram, mail, git) = (${input}) WHERE id=${id} RETURING id;")
    }

    // Удаление студента по ID
    fun deleteStudent(id: Int) {
        val query = "DELETE FROM student WHERE id = $id"
        executeQuery(query)
    }

    // Получение количества студентов
    fun getCount(): Int {
        val query = "SELECT COUNT(*) AS count FROM student"
        val result = executeSqlSelect(query)
        return result?.let {
            if (it.next()) {
                it.getInt("count")
            } else {
                0
            }
        } ?: 0
    }
}

fun main() {
    val studentDB = StudentsListDB()

    // Пример вызова функций
    println("Получение студента по ID:")
    println(studentDB.getStudentById(1))
    println("\nДобавление нового студента:")
    val studentId = studentDB.addStudent(
        Student(
            name = "Иван",
            surname = "Иванов",
            patronymic = "Иванович",
            phoneNumber = "+79181130942",
            gitHub = "https://github.com/ivanov",
            email = "ivanov@gmail.com",
            telegram = "@ivan_telegram"
        )
    )

    if (studentId != null) {
        println("Студент успешно добавлен с id: $studentId")
    } else {
        println("Ошибка при добавлении студента.")

}






//    println("\nДобавление нового студента:")
//    studentDB.addStudent(
//        Student(
//            name = "Иван",
//            surname = "Иванов",
//            patronymic = "Иванович",
//            phoneNumber = "+79181130942",
//            gitHub = "https://github.com/ivanov",
//            email = "ivanov@gmail.com",
//            telegram = "@ivan_telegram"
//        )
//    )


    println("\nОбновление студента:")
    studentDB.updateStudent(3, Student(name = "Настя", surname = "Миленченко", phoneNumber = "+79181130942"))

    println("\nКоличество студентов:")
    println(studentDB.getCount())

    println("\nПолучение группы студентов:")
    studentDB.getKStudents(1, 2).forEach { println(it) }

    println("\nУдаление студента:")
    studentDB.deleteStudent(2)
}
