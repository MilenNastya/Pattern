fun main() {
    val students = mutableListOf<Student>();
    students.add(Student("Милен", "Настя", "Романовна"));
    students.add(Student("Кривошеев", "Илья", "Владимирович", studentTelegram = "@IlyaVladimirovich00"));
    students.add(Student("Миленченко", "Анастасия", "Романовна", studentPhone  = "+79181130942"));
    students.add(Student("Лыкова", "Каролина", "Дмитриевна", studentEmail = "karolina@gmail.com"));
    students.add(Student("Малышев", "Дмитрий", "Араратович", studentTelegram = "@dmmvrs", studentPhone = "+79298491219"));
    students.add(Student("Иванов", "Иван", "Иваныч"));
    students.forEach { it: Student -> println(it) };
}