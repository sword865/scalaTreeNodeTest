import TreeNode.asciiDisplay
import org.scalatest._

class TreeNodeSpec extends FlatSpec with Matchers {

  "Examples " should  " be parsed" in {

    val input1 = asciiDisplay(TreeNode("Root",
      children = List(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3"))))
    val output1 = """+-Root
                    |  +-level1-1
                    |  +-level1-2
                    |  +-level1-3""".stripMargin
    assert(input1.mkString("\n") === output1)

    val input2 = asciiDisplay(TreeNode("Root",
      children = List(
        TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
        TreeNode("level1-2"),
        TreeNode("level1-3"))))
    val output2 = """+-Root
                    |  +-level1-1
                    |  | +-level2-1
                    |  |   +-level3-1
                    |  |
                    |  +-level1-2
                    |  +-level1-3""".stripMargin
    assert(input2.mkString("\n") === output2)
  }


}

