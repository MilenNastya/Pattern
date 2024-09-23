data class Student(
    var surname:String,
    var name:String,
    var patronymic:String,
    var id:Int= autoGenerateId(),
    var Phone:String?=null,
    var Telegram:String?=null,
    var Email:String?=null,
    var gitHub:String?=null

) {
    init {
        require(
            Student.isValidPhone(this.Phone),
            { "Valib Phone" }
            );
        }

    companion object {
        var classId: Int = 0;
        fun autoGenerateId(): Int {
            classId += 1;
            return classId;
        }
       fun isValidPhone(phone: String?): Boolean {
           return phone?.matches(Regex("\\+7\\d{10}")) ?: true;
       }}
    // Конструктор через hasmpam класса
    constructor(studentArgs: HashMap<String,Any?>) : this(id = studentArgs.getOrDefault("id", autoGenerateId()) as Int,
        surname = studentArgs["surname"].toString(),
        name = studentArgs["name"].toString(),
        patronymic = studentArgs["patronymic"].toString(),
        Phone = studentArgs.getOrDefault("Phone",null) as String?,
        Telegram = studentArgs.getOrDefault("Telegram",null).toString(),
        Email = studentArgs.getOrDefault("Email",null).toString(),
        gitHub = studentArgs.getOrDefault("gitHub",null).toString()) {}

}


