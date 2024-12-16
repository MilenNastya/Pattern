import Student
class Main {
    fun main()
    {
        val sasha = Student("Milen","Nastya","Povanovna", "+79181130942","@username","mailexample@gmail.com","https://github.com/Milen")
        val ravil = Student("Krivosheev","Ilia","Vladivirovich", "+7900000000","@username","mailexample@gmail.com","https://github.com/")
        println(sasha.toString())
        println(ravil.toString())
        println(ravil.validate())
        ravil.setContacts("89999999999","wrongtelegram","mail@yandex.ru")
        println(ravil.toString())
        var petrInp= hashMapOf<String,Any?>(
            "surname" to "Petrov",
            "name" to "Petr",
            "patronymic" to "Ivanovich"
        )
        var petr=Student(petrInp)
        println(petr.toString())
        var danila=Student("Daniil Danilanin Danilavich")
        println(danila.toString())
        var dlss=DataListStudentShort(mutableListOf(
            StudentShort(sasha),
            StudentShort(ravil),
            StudentShort(petr),
            StudentShort(danila)
        ))
        dlss.select(1)
        dlss.select(2)
        var dtss=dlss.getTable()
        for (i in 0..dtss.getRows()-1)
        {
            for(j in 0..dtss.getColumns()-1)
            {
                print(dtss.getElement(i,j))
                print(" ")
            }
            println()
        }
    }
}
fun main() = Main().main()