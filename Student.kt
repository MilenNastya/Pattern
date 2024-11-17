data class Student(
   private  var surname: String,
    private var name: String,
    private var patronymic: String,
    private var id: Int = autoGenerateId(),
    private var Phone: String? = null,
    private var Telegram: String? = null,
     private var Email: String? = null,
     private var gitHub: String? = null
) {
    init {
        require(isValidSurname(this.surname),) { "Surname must be a valid surname" }
        require(isValidName(this.name)) { "Name must be a valid name" }
        require(isValidPatronymic(this.patronymic)) { "Patronymic must be a valid patronymic" }
        require(isValidPhone(this.Phone)) { "Phone must be a valid phone number" }
        require(isValidTelegram(this.Telegram)) { "Telegram must be a valid telegram" }
        require(isValidEmail(this.Email)) { "Email must be a valid email" }
        require(isValidGitHub(this.gitHub)) { "GitHub must be a valid GitHub username" }
    }
    //Проверка наличия гита
    private fun gitExist() = this.gitHub!=null
    //Проверка наличия второго контакта
    private fun contactExist() = this.Email!=null || this.Telegram!=null || this.Phone!=null;
    //Проверка наличия гита и 1 из контактов
    fun validate() = this.gitExist() && this.contactExist();
    //Метод set_contacts
    private fun checkValueAndPropertyNotNull(value:String?,propertyValue:String?) = value==null && propertyValue!=null || value!=null
    private fun contactSetter(value: String?,propertyValue: String?,setter:(value: String?)->(Unit)){
        if(this.checkValueAndPropertyNotNull(value,propertyValue)){
            setter(value)
        }
    }
    // Сеттер телефона
    private fun phoneSetter(value: String?) {
        require(isValidPhone(value))
        this.Phone = value
    }
    private fun setPhoneNumber(value:String?) = this.contactSetter(value, this.Phone) { this.phoneSetter(it) }
    // Сеттер телеграмма
    private fun telegramSetter(value: String?) {
        require(isValidTelegram(value))
        this.Telegram = value
    }
    private fun setTelegram(value:String?) = this.contactSetter(value,this.Telegram,this::telegramSetter)
    //Сеттер почты
    private fun emailSetter(value: String?) {
        require(isValidEmail(value))
        this.Email = value
    }
    private fun setEmail(value:String?) = this.contactSetter(value,this.Email,this::emailSetter)
    //Сеттер гита
    private fun gitSetter(value: String?) {
        require(isValidGitHub(value))
        this.gitHub = value
    }
    private fun setGit(value:String?) = this.contactSetter(value,this.gitHub,this::gitSetter);
    // Сеттер контактов
    fun setContacts(contacts:HashMap<String,String?>){
        this.setPhoneNumber(contacts.getOrDefault("phoneNumber",this.Phone))
        this.setGit(contacts.getOrDefault("gitHub",this.gitHub))
        this.setEmail(contacts.getOrDefault("email",this.Email))
        this.setTelegram(contacts.getOrDefault("telegram",this.Telegram))
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

    constructor(studentArgs: HashMap<String,Any?>) : this(
        surname = studentArgs["surname"].toString(),
        name = studentArgs["name"].toString(),
        patronymic = studentArgs["patronymic"].toString(),
        Phone = studentArgs.getOrDefault("Phone", null) as String?,
        Telegram = studentArgs.getOrDefault("Telegram", null) as String?,
        Email = studentArgs.getOrDefault("Email", null) as String?,
        gitHub = studentArgs.getOrDefault("gitHub", null) as String?
    )
}
