fun main() {
    val students = mutableListOf<Student>();
    students.add(Student("Милен", "Настя", "Романовна"));
    students.add(Student("Кривошеев", "Илья", "Владимирович", Telegram = "@IlyaVladimirovich00"));
    students.add(Student("Миленченко", "Анастасия", "Романовна", Phone  = "+79181130942"));
    students.add(Student("Лыкова", "Каролина", "Дмитриевна", Email = "karolina@gmail.com"));
    students.add(Student("Малышев", "Дмитрий", "Араратович", Telegram = "@dmmvrs", Phone = "+79298491219"));
    students.add(Student("Иванов", "Иван", "Иваныч"));
    students.add(Student(hashMapOf(Pair("name","Настя"),Pair("surname","Милен"),Pair("patronymic","Романовна"))));
    students.forEach { it: Student -> println(it) };
}