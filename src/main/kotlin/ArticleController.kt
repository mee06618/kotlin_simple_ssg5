

class ArticleController {

    private val repository =ArticleRepository
    fun save(){
        repository.saveArticle(repository.articles)
    }
    fun read(){
        val arr =repository.readArticle()

    }
    fun add(){
        for(i in 1..100){
            repository.addArticle("제목${i}","내용${i}")

        }

    }
    fun list(query: Rq){
        val page =query.getIntParam("page",1)
        val id =query.getIntParam("id",1)
        val keyword =query.getStringParam("keyword","")

        val arr= repository.filteredArticle(id,page, keyword) as MutableList<Article>

        for(i in arr){
            println("${i.id} / ${i.title} / ${i.body} / ${i.regdate} / ${i.update} / ${MemberRepository.getNick(i.memberid)}")
        }
    }
    fun write(num: Int) {


        if(num!=0)
            repository.writeArticle(num)
        else{
            println("로그인 해주세요")
            return
        }


    }

    fun modify(query: Rq, num: Int){
        val temp = query.getIntParam("id",1)
        if(num!=0) {
            if (repository.getArticleById(temp) == null) {
                println("없는 아이디입니다")
                return
            } else {
                print("제목 : ")
                val title = readLineTrim()
                print("내용 : ")
                val body = readLineTrim()

                repository.modifyArticle(temp, title, body)
            }
        }else{
            println("로그인 해주세요")
            return
        }

    }
    fun delete(query: Rq, num: Int){
        val temp = query.getIntParam("id",1)
        if(num!=0) {
            if (repository.getArticleById(temp) == null) {
                println("없는 아이디입니다")
                return
            } else {
                repository.deleteArticle(repository.getArticleById(temp)!!)
                println("${temp}번 게시물이 삭제되었습니다")
            }
        }else{
            println("로그인 해주세요")
            return
        }
    }
    fun detail(query: Rq){
        val temp = query.getIntParam("id",1)
        if(repository.getArticleById(temp)==null){
            println("없는 아이디입니다")
            return
        }else {
            val temp=repository.detailArticle(repository.getArticleById(temp)!!)

        }
    }

}