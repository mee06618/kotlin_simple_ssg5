class MemberController {
    private val repository = MemberRepository
    fun read(){

    }
    fun save(){

    }
    fun add(){
        repository.addMember()
    }
    fun join(){
        repository.joinMember()

    }
    fun login():Int{
        return repository.loginMember()
    }
    fun logout(): Int {
        println("로그아웃 됬습니다")
        return 0
    }
    fun getNick(num:Int): String {
        return repository.getNick(num)
    }
}