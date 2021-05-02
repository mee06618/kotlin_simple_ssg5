object MemberRepository {
    var lastIdx=0
    val members= mutableListOf<Member>()
    fun joinMember() {
        val num = ++lastIdx
        print("아이디 : ")
        val id = readLineTrim()
        print("비밀번호 : ")
        val pass = readLineTrim()
        print("닉네임 : ")
        val nick = readLineTrim()
        val temp = Member(num,id,pass,nick)
        members.add(temp)
        println("${nick}님 회원가입 완료됬습니다")
    }

    fun loginMember():Int {
        print("아이디 : ")
        val id = readLineTrim()
        for(i in members){
            if(i.id.contains(id)){
                print("비밀번호 : ")
                val pass = readLineTrim()
                if(i.pass==pass){
                    println("로그인 됬습니다")
                    return i.num
                }else{
                    println("비밀번호가 틀립니다")
                    return 0
                }

            }else{
                return 0
            }

        }
        return 0
    }



    fun addMember() {
        TODO("Not yet implemented")
    }

    fun getNick(num: Int): String {
        for(i in members){
            if(i.num==num)
                return i.nick
        }
        return ""

    }
}