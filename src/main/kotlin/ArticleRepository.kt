import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

object ArticleRepository {
    var lastid=0
    var articles = mutableListOf<Article>()
    val member =MemberRepository
    fun saveArticle(arr:List<Article>){
        val mapper: ObjectMapper = jacksonObjectMapper()
        var tempArticles = mutableListOf<Article>() // Add elem to collection.
        for(i in arr){
            tempArticles.add(i)
        }
        mapper.writerWithDefaultPrettyPrinter() .writeValue( File("C:\\Users\\이재연\\IdeaProjects\\Exam12\\src\\main\\json\\.my_articles.json"), tempArticles )

                        }
    fun readArticle() {
        val mapper  = jacksonObjectMapper()
        val temp = mapper.readValue<ArrayList<Article>>(File("C:\\Users\\이재연\\IdeaProjects\\Exam12\\src\\main\\json\\.my_articles.json"))

        for(i in temp){
            articles.add(i)
        }
    }
    fun addArticle(title:String,body:String){
        val id = ++lastid
        val regdate=Util.getNowDateStr()
        val update=Util.getNowDateStr()
        val temp =Article(id,title, body, regdate, update,1)
        articles.add(temp)


    }


    fun modifyArticle(id: Int, title:String, body:String){
        val temp = getArticleById(id)
        temp!!.title=title
        temp.body=body
        temp.update=Util.getNowDateStr()
    }




    fun getArticleById(id:Int):Article? {

        for(arr in articles){
            if(arr.id==id){
                return arr
            }
        }
        return null
    }

    fun deleteArticle(deletedArticle:Article) {
        articles.remove(deletedArticle)
    }
    fun filteredArticle(id:Int,page:Int,keyword:String): List<Article> {
        val list = filteredPageArticle(page)
        val list2 = filteredIdArtice(list,id)
        return filteredKeywordArtice(list2,keyword)
    }

    fun filteredPageArticle(page:Int) :MutableList<Article>{
        val filteredArticles = mutableListOf<Article>()
        val maxArticle=5
        val offset=(page-1)*maxArticle
        val startIndex= articles.lastIndex-offset
        var lastIndex=startIndex-(maxArticle-1)
        if(lastIndex<0){
            lastIndex=0
        }
        for(i in startIndex downTo lastIndex){
            filteredArticles.add(articles[i])
        }
        return filteredArticles
    }

    fun filteredIdArtice(arr:List<Article>,id:Int):List<Article>{

        return arr
    }
    fun filteredKeywordArtice(arr:List<Article>,keyword: String):List<Article>{
        return arr
    }
    fun detailArticle(detailArticle:Article){
        println("번호 : ${detailArticle.id}")
        println("제목 : ${detailArticle.title}")
        println("내용 : ${detailArticle.body}")
        println("생성날짜 : ${detailArticle.regdate}")
        println("수정날짜 : ${detailArticle.update}")
        println("작성자 : ${member.getNick(detailArticle.memberid)}")

    }

    fun writeArticle(memberId:Int) {
     val id = ++lastid
            print("제목 : ")
            val title=readLineTrim()
            print("내용 : ")
            val body=readLineTrim()
        val regdate=Util.getNowDateStr()
        val update=Util.getNowDateStr()
        val temp =Article(id,title, body, regdate, update,memberId)
        articles.add(temp)
        println("${id}번 게시물 생성")
            
        }
    }


