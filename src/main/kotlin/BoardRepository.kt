import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

object BoardRepository {
    var lastId=0
    val boards = mutableListOf<Board>()

    fun saveBoard(arr:List<Board>){
        val mapper: ObjectMapper = jacksonObjectMapper()
        var tempBoards = mutableListOf<Board>() // Add elem to collection.
        for(i in arr){
            tempBoards.add(i)
        }
        mapper.writerWithDefaultPrettyPrinter() .writeValue( File("C:\\Users\\이재연\\IdeaProjects\\Exam12\\src\\main\\json\\.my_articles.json"), tempBoards )

    }
    fun readBoard() {
        val mapper  = jacksonObjectMapper()
        val temp = mapper.readValue<ArrayList<Board>>(File("C:\\Users\\이재연\\IdeaProjects\\Exam12\\src\\main\\json\\.my_articles.json"))

        for(i in temp){
            boards.add(i)
        }
    }
    fun addBoard(){
        boards.add(Board(1,"공지게시판",1))
        boards.add(Board(2,"자유게시판",2))
    }
    fun writeBoard(){
        val id =++lastId
        print("이름 : ")
        val name = readLineTrim()
        print("코드 : ")
        val code = readLineTrim().toInt()
        for(i in boards){
            if(i.name!=name && i.code!=code)
                boards.add(Board(id,name,code))
            else{
                println("오류!")
                return
            }
        }
        lastId=id
    }
    fun listBoard(){
        for(i in boards){
            println("${i.num} / ${i.name} / ${i.code}")
        }
    }
    fun modifyBoard(code:Int){
        for(i in boards){
            if(i.code!=code) {
                print("이름 : ")
                val name = readLineTrim()
                print("코드 : ")
                val code = readLineTrim().toInt()
                val id = i.num
                boards.add(Board(id, name, code))
            }
            else{
                println("오류!")
                return
            }
        }
    }
    fun deleteBoard(code: Int){

    }
}