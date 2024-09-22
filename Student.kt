class Student{
    companion object{
        var classId:Int = 0;
        fun autoGenerateId():Int{
            classId+=1;
            return classId;
        }
    }

    var id:Int? = null
        get():Int?{
            return field;
        }
        set(value:Int?) {
            field = value;
        };

    var surname:String = ""
        get():String{
            return field;
        }
        set(value:String) {
            field = value;
        };

    var name:String = ""
        get():String{
            return field;
        }
        set(value:String) {
            field = value;
        };

    var patronymic:String = ""
        get():String{
            return field;
        }
        set(value:String) {
            field = value;
        };

    var phoneNumber:String? = null
        get():String?{
            return field;
        }
        set(value:String?) {
            field = value;
        };

    var telegram:String? = null
        get():String?{
            return field;
        }
        set(value:String?) {
            field = value;
        };

    var email:String? = null
        get():String?{
            return field;
        }
        set(value:String?) {
            field = value;
        };

    var gitHub:String? = null
        get():String?{
            return field;
        }
        set(value:String?) {
            field = value;
        };

    //Конструктор класса
    constructor(
        studentSurname:String,
        studentName:String,
        studentPatronymic:String,
        studentId:Int?=autoGenerateId(),
        studentPhone:String?=null,
        studentTelegram:String?=null,
        studentEmail:String?=null,
        studentGit:String?=null
    )
    {
        this.id = studentId;
        this.surname = studentSurname;
        this.name = studentName;
        this.patronymic = studentPatronymic;
        this.phoneNumber = studentPhone;
        this.telegram = studentTelegram;
        this.email = studentEmail;
        this.gitHub = studentGit;
    }

    //Метод вывода
    override fun toString(): String {
        return "ID:${this.id} Surname:${this.surname} Name:${this.name} Patronymic:${this.patronymic} Phone:${this.phoneNumber} Telegram:${this.telegram} Email:${this.email} Git:${this.gitHub}";
    }
}