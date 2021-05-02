class BoardController {
    val board =BoardRepository
    fun add(){
        board.addBoard()
    }
    fun write(){
        board.writeBoard()
    }
    fun list(){
        board.listBoard()
    }
    fun modify(rq: Rq) {
        val code = rq.getIntParam("code",0)
        board.modifyBoard(code)
    }
    fun delete(rq: Rq) {
        val code = rq.getIntParam("code",0)
        board.deleteBoard(code)
    }
}