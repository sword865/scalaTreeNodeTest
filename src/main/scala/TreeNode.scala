import scala.collection.mutable.{MutableList=>MList}


case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

object TreeNode {
  def asciiDisplay(root: TreeNode[String]): Seq[String] = {
    assert(root != null)
    val result = MList[String]()
    def showTreeDFS(tree: TreeNode[String], header: String, isLast: Boolean): Unit ={
      result += f"$header+-${tree.data}"
      tree.children.zipWithIndex
        .foreach({
          case (x, idx) =>
            if(isLast) {
              showTreeDFS(x, f"$header  ", (idx + 1) == tree.children.size)
            }else{
              showTreeDFS(x, f"$header| ", (idx + 1) == tree.children.size)
            }
        })
      if(tree.children.nonEmpty && !isLast){
        result +=  f"$header|"
      }

    }
    showTreeDFS(root, "", isLast = true)
    result
  }

  def main(args: Array[String]): Unit = {

    println("=============example 1: =============")
    asciiDisplay(TreeNode("Root",
      children = List(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3")))).foreach(println)

    println("=============example 2: =============")

    asciiDisplay(TreeNode("Root",
      children = List(
        TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
        TreeNode("level1-2"),
        TreeNode("level1-3")))).foreach(println)
  }
}