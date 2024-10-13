data class Student(
    var surname: String,
    var name: String,
    var patronymic: String,
    var id: Int = autoGenerateId(),
    var Phone: String? = null,
    var Telegram: String? = null,
    var Email: String? = null,
    var gitHub: String? = null
) {
    init {
        require(Student.isValidSurname(this.surname)) { "Surname must be a valid surname" }
        require(Student.isValidName(this.name)) { "Name must be a valid name" }
        require(Student.isValidPatronymic(this.patronymic)) { "Patronymic must be a valid patronymic" }
        require(Student.isValidPhone(this.Phone)) { "Phone must be a valid phone number" }
        require(Student.isValidTelegram(this.Telegram)) { "Telegram must be a valid telegram" }
        require(Student.isValidEmail(this.Email)) { "Email must be a valid email" }
        require(Student.isValidGitHub(this.gitHub)) { "GitHub must be a valid GitHub username" }
    }

    companion object {
        var classId: Int = 0
        fun autoGenerateId(): Int {
            classId += 1
            return classId
        }

        fun isValidPhone(phone: String?): Boolean {
            return phone?.matches(Regex("\\+7\\d{10}")) ?: true
        }

        fun isValidSurname(surname: String): Boolean {
            return surname.matches(Regex("^[A-Z][a-z]*(-([A-Za-z]?)[a-z]*)*$"))
        }

        fun isValidName(name: String): Boolean {
            return name.matches(Regex("^[A-Z][a-z]*(-([A-Za-z]?)[a-z]*)*$"))
        }

        fun isValidPatronymic(patronymic: String): Boolean {
            return patronymic.matches(Regex("^[A-Z][a-z]*(-([A-Za-z]?)[a-z]*)*$"))
        }

        fun isValidTelegram(telegram: String?): Boolean {
            return telegram?.matches(Regex("@(?=.{5,64})(?!_)(?!.*__)[a-zA-Z0-9_]+(?<![_.])")) ?: true
        }

        fun isValidEmail(email: String?): Boolean {
            return email?.matches(Regex("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")) ?: true
        }

        fun isValidGitHub(gitHub: String?): Boolean {
            return gitHub?.let { !Regex("[$%#@&/?]").matches(it) } ?: true
        }
    }

    constructor(studentArgs: HashMap<String, Any?>) : this(
        id = studentArgs.getOrDefault("id", autoGenerateId()) as Int,
        surname = studentArgs["surname"].toString(),
        name = studentArgs["name"].toString(),
        patronymic = studentArgs["patronymic"].toString(),
        Phone = studentArgs.getOrDefault("Phone", null) as String?,
        Telegram = studentArgs.getOrDefault("Telegram", null) as String?,
        Email = studentArgs.getOrDefault("Email", null) as String?,
        gitHub = studentArgs.getOrDefault("gitHub", null) as String?
    )
}
