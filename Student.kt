data class Student(
    var surname:String,
    var name:String,
    var patronymic:String,
    var id:Int?= autoGenerateId(),
    var Phone:String?=null,
    var Telegram:String?=null,
    var Email:String?=null,
    var gitHub:String?=null,

) {
    companion object {
        var classId: Int = 0;
        fun autoGenerateId(): Int {
            classId += 1;
            return classId;
        }
    }
    // Конструктор через HashMap
    constructor(studentArgs: HashMap<String, Any?>) : this(
        studentArgs["surname"]?.toString() ?: "",
        studentArgs["name"]?.toString() ?: "",
        studentArgs["patronymic"]?.toString() ?: "",
        studentArgs["id"] as? Int ?: autoGenerateId(),
        studentArgs["Phone"]?.toString(),
         studentArgs["Telegram"]?.toString(),
         studentArgs["Email"]?.toString(),
        studentArgs["gitHub"]?.toString()
    )
}

