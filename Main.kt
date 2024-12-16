package org.example

import Student.Student
import StudentList.StudentListJson
import StudentList.StudentListTxt
import StudentList.StudentListYaml

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val studListTxt = StudentListTxt()
    studListTxt.readFromFile("src/main/resources/text.txt")
    studListTxt.writeToFile("src/main/resources/","out.txt")
    println(studListTxt.sortByInitials())
    studListTxt.addNewStudent(Student("A-B", "Bbbbbb", "Cccccc", emailValue = "kk@gmial.com"))
    println(studListTxt)
    studListTxt.deletebyId(4)
    println(studListTxt)
    studListTxt.replaceById(0,
        Student(hashMapOf(Pair("name", "E"), Pair("surname", "Bbbbbb"), Pair("patronymic", "Cccccc")))
    )
    println(studListTxt)

    val studentListJson = StudentListJson()
    studentListJson.readFromFile("src/main/resources/file.json")
    studentListJson.writeToFile("src/main/resources/","res.json")

    val studentListYaml = StudentListYaml()
    studentListYaml.readFromFile("src/main/resources/test.yaml")
    studentListYaml.writeToFile("src/main/resources/","res.yaml")
}