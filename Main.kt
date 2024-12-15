

import Student
import DataTable

fun main() {
    val students = mutableListOf<Student>();
    students.add(Student("Aaaaa","Bbbbbb","Cccccc"));
    students.add(Student("Aabbb-Abbb","Bbbbbb","Cccccc", telegramValue = "@elelelelele"));
    students.add(Student("Aaabbb","Bbb-Cbbb","Cccccc", gitHubValue = "eeefefefef"));
    students.add(Student("A-B","Bbbbbb","Cccccc", emailValue = "kk@gmial.com"));
    students.add(Student("B","Vbbbbb","Cccccc", phoneNumberValue = "+79889889898"));
    students.add(Student(hashMapOf(Pair("name","E"),Pair("surname","Bbbbbb"),Pair("patronymic","Cccccc"))));
    students.forEach { it: Student -> println(it) };
    Student.writeToTxt("src/","out.txt",Student.readFromTxt("src/text.txt"))
    var dat = DataTable(arrayOf(arrayOf(Student("Aaaaa","Bbbbbb","Cccccc"),3),arrayOf(4,3)))
    var ar = dat.getElement(0,0) as Student
    ar.telegram = "@aaaaaa"
    println(dat.getElement(0,0))
}